package com.android.applidecathlon;

/**
 * Created by Elias on 05/08/2016.
 */
public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String store;

    public User() {
    }

    public User(String firstname, String lastname, String email, String store) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.store = store;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
