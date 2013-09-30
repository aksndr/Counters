package ru.aksndr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 10:16
 */
@Entity
@Table(name="user")
public class User {
    private long id;
    private String lastName, firstName, middleName, pass;


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="userid")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name="pass")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    @Column(name="lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name="firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name="middlename")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
