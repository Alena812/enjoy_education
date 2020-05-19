package com.example.eefrontend.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("name")
    @Expose
    private String name;
//    @SerializedName("birthday")
//    @Expose
//    private Date birthday;

    public User() {
        email = "shishaevaleksei98@gmail.com";
        password = "asdasdasd";
        name = "name";
    }

    public User(String _email, String _password) {
        email = _email;
        password = _password;
        name = "name";
    }
}