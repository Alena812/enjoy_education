package com.example.eefrontend.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Course implements Serializable {
    @SerializedName("id_course")
    @Expose
    public int id_course;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("email")
    @Expose
    private String email;
}
