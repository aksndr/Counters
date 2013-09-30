package ru.aksndr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 11:34
 */

@Entity
@Table(name="address")
public class Address {
    private long id, userId, index;
    private String country, city, street, house, flat;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="userid")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name="postind")
    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    @Column(name="country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name="house")
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Column(name="flat")
    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}
