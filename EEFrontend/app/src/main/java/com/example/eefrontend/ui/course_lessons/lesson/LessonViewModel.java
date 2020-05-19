package com.example.eefrontend.ui.course_lessons.lesson;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eefrontend.entity.Course;

import java.util.List;

public class LessonViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public List<Course> courses;

    public LessonViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fragment_my_courses fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}