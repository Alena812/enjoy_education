package com.example.eefrontend.ui.my_courses;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eefrontend.entity.Course;

import java.util.List;

public class MyCoursesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public List<Course> courses;

    public MyCoursesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fragment_my_courses fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}