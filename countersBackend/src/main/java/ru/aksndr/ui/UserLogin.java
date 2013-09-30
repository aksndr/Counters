package ru.aksndr.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;
import ru.aksndr.entity.Address;
import ru.aksndr.entity.User;
import ru.aksndr.service.AddressService;
import ru.aksndr.service.UserService;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * User: a.arzamastsev Date: 19.09.13 Time: 15:28
 */
@ManagedBean(name="UserLogin")
@Controller
@SessionScoped
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private String name, lastName, message, country, city, street, house, flat, pass;
    private int id;
    private boolean registered = true;

    @ManagedProperty(value="#{addressService}")
    AddressService addressService;
    @ManagedProperty(value="#{userService}")
    UserService userService;

    public void login(){
        if (id>0){
            try {
                User user = getUserService().getUserById(id);
                if (user!=null){
                    cleanMessage();

                    setName(user.getFirstName());
                    setLastName(user.getLastName());
                    Address address = getAddressService().getAddressByUserId(id);
                    try {
                        if (address!=null){
                            setCountry(address.getCountry());
                            setCity(address.getCity());
                            setStreet(address.getStreet());
                            setHouse(address.getHouse());
                            setFlat(address.getFlat());
                        } else {
                            setMessage("Пользователю не указан адресс.");
                        }
                    } catch (Exception e)  {
                        setMessage("Ошибка: "+e);
                    }
                } else {
                    nullFields();
                    setMessage("Пользователь с логином " + id + " не зарегистрирован.");
                    setRegistered(false);
                }
            } catch (Exception e)  {
                setMessage("Ошибка: "+e);
            }
        }
    }

    public String register(){
    return "/pages/register.xhtml?faces-redirect=true";
    }

    private void cleanMessage() {
        this.message = null;
    }

    private void nullFields() {
        setName(null);
        setLastName(null);
        setCountry(null);
        setCity(null);
        setStreet(null);
        setHouse(null);
        setFlat(null);
    }

    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public AddressService getAddressService() {
        return addressService;
    }
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
}
