package com.example.eefrontend.api;

import com.example.eefrontend.entity.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ICourseApi {
    @GET("/course")
    public Call<List<Course>> getCourse(@Query("email") String email);
}
