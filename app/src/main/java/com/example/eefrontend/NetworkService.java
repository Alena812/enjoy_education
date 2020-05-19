package com.example.eefrontend;

import com.example.eefrontend.api.ICourseApi;
import com.example.eefrontend.api.ILessonApi;
import com.example.eefrontend.api.IUserApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    private static final String BASE_URL = "http://192.168.1.35:3000";
    private Retrofit mRetrofit;

    private NetworkService() {
        Gson g = new GsonBuilder().setLenient().create();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(g))
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public IUserApi getUserApi() {
        return mRetrofit.create(IUserApi.class);
    }

    public ICourseApi getCourseApi() {
        return mRetrofit.create(ICourseApi.class);
    }

    public ILessonApi getLessonApi() {
        return mRetrofit.create(ILessonApi.class);
    }
}