package com.example.eefrontend.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eefrontend.NetworkService;
import com.example.eefrontend.entity.Course;
import com.example.eefrontend.entity.Lesson;
import com.example.eefrontend.entity.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
//        NetworkService NS = NetworkService.getInstance();
//        NS.getUserApi().getUser().enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                List<User> user = response.body();
//                //mText.setValue(user.get(0).name);
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//                //mText.setValue(t.getMessage());
//            }
//        });
//        User user = new User();
//        NS.getUserApi().postUser(user).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if (response.isSuccessful()) {
//                    System.out.println("onResponse body: " + response.body().toString());
//                } else {
//                    mText.setValue("Такой пользователь уже зарегистрирован!");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Log.e("Error", t.getMessage());
//            }
//        });

//        NS.getCourseApi().getCourse("shishaevaleksei98@gmail.com").enqueue(new Callback<Course>() {
//            @Override
//            public void onResponse(Call<Course> call, Response<Course> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<Course> call, Throwable t) {
//                Log.e("Error", t.getMessage());
//            }
//        });

//        NS.getLessonApi().getLessons(1).enqueue(new Callback<Lesson>() {
//            @Override
//            public void onResponse(Call<Lesson> call, Response<Lesson> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<Lesson> call, Throwable t) {
//                Log.e("Error", t.getMessage());
//            }
//        });
    }

    public LiveData<String> getText() {
        return mText;
    }
}