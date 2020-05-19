package com.example.eefrontend.ui.course_lessons.lesson;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.eefrontend.MainActivity;
import com.example.eefrontend.NetworkService;
import com.example.eefrontend.R;
import com.example.eefrontend.entity.Course;
import com.example.eefrontend.entity.Lesson;
import com.example.eefrontend.entity.User;
import com.example.eefrontend.ui.course_lessons.CourseLessonsViewModel;
import com.example.eefrontend.ui.my_courses.course.CourseFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LessonFragment extends Fragment {

    private CourseLessonsViewModel courseLessonsViewModel;
    public User user;
    Lesson lesson;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        myCoursesViewModel =
//                ViewModelProviders.of(this).get(MyCoursesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lesson, container, false);

        user = ((MainActivity) requireActivity()).user;
        lesson = (Lesson) getArguments().getSerializable("lesson");

        TextView textView = root.findViewById(R.id.lessonTitle);
        textView.setText(lesson.title);

        ConstraintLayout lay = root.findViewById(R.id.fragment_lesson);
        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putSerializable("lesson", lesson);
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.action_nav_course_lessons_to_nav_lesson_itself, b);
            }
        });

        return root;
    }
}
