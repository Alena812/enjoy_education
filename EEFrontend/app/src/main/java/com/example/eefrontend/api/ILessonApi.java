package com.example.eefrontend.api;

import com.example.eefrontend.entity.Lesson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ILessonApi {
    @GET("/lesson")
    public Call<List<Lesson>> getLessons(@Query("id_course") int id_course);
}
