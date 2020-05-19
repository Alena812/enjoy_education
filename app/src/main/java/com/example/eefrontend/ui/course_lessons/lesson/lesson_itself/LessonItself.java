package com.example.eefrontend.ui.course_lessons.lesson.lesson_itself;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.eefrontend.MainActivity;
import com.example.eefrontend.R;
import com.example.eefrontend.entity.Lesson;
import com.example.eefrontend.entity.User;
import com.example.eefrontend.ui.course_lessons.CourseLessonsViewModel;

import org.w3c.dom.Text;

public class LessonItself extends Fragment {
    private CourseLessonsViewModel courseLessonsViewModel;
    public User user;
    Lesson lesson;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        myCoursesViewModel =
//                ViewModelProviders.of(this).get(MyCoursesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lesson_itself, container, false);

        user = ((MainActivity) requireActivity()).user;
        lesson = (Lesson) getArguments().getSerializable("lesson");

        TextView title = root.findViewById(R.id.lessonTitle);
        TextView description = root.findViewById(R.id.lessonItself);
        title.setText(lesson.title);
        description.setText(lesson.big_info);

        return root;
    }
}
