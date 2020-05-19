package com.example.eefrontend.api;

import com.example.eefrontend.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IUserApi {
    @GET("/user")
    public Call<List<User>> getUser(@Query("email") String email, @Query("password") String password);

    @POST("/user")
    public Call<User> postUser(@Body User user);
}