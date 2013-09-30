package ru.aksndr.ui;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

/**
 * User: a.arzamastsev Date: 24.09.13 Time: 16:51
 */
@ManagedBean(name="passwordValidationBean")
@SessionScoped
public class PasswordValidationBean implements Cloneable, Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1952428504080910113L;
    @Size(min = 5, max = 15, message = "Пароль должен быть от {min} до {max} символов.")
    private String password = "";
    private String confirm = "";

    @AssertTrue(message = "Введенные пароли не совпадают!")
    public boolean isPasswordsEquals() {
        return password.equals(confirm);
    }

    public void storeNewPassword() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Пользователь зарегистрирован!", "Пользователь зарегистрирован!"));
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm() {
        return confirm;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
