package com.android.applidecathlon.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Elias on 05/08/2016.
 */
public class Users {

    @SerializedName("email")
    private String email;
    @SerializedName("firstname")
    private String firstname;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("store")
    private String store;

    public Users() {

    }

    public Users(String email, String firstname, String lastname, String store) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.store = store;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getStore() {
        return store;
    }
}
