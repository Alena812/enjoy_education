package com.example.eefrontend.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Lesson implements Serializable {
    @SerializedName("id_lesson")
    @Expose
    private int id_lesson;
    @SerializedName("id_course")
    @Expose
    public String id_course;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("img")
    @Expose
    private String email;
    @SerializedName("short_info")
    @Expose
    private String short_info;
    @SerializedName("big_info")
    @Expose
    public String big_info;
}
