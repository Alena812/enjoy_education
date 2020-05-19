package com.example.eefrontend.ui.course_lessons;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.eefrontend.MainActivity;
import com.example.eefrontend.NetworkService;
import com.example.eefrontend.R;
import com.example.eefrontend.entity.Course;
import com.example.eefrontend.entity.Lesson;
import com.example.eefrontend.entity.User;
import com.example.eefrontend.ui.course_lessons.lesson.LessonFragment;
import com.example.eefrontend.ui.my_courses.course.CourseFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseLessonsFragment extends Fragment {

    private CourseLessonsViewModel courseLessonsViewModel;
    public User user;
    public Course course;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        myCoursesViewModel =
//                ViewModelProviders.of(this).get(MyCoursesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_course_lessons, container, false);

        user = ((MainActivity) requireActivity()).user;
        course = (Course) getArguments().getSerializable("course");

        FragmentManager fm = getChildFragmentManager();
        int count = fm.getBackStackEntryCount();
        for(int i = 0; i < count; ++i) {
            fm.popBackStack();
        }

        if (getChildFragmentManager().getFragments() != null && getChildFragmentManager().getFragments().size() > 0) {
            for (int i = 0; i < getChildFragmentManager().getFragments().size(); i++) {
                Fragment mFragment = getChildFragmentManager().getFragments().get(i);
                if (mFragment != null)
                    getChildFragmentManager().beginTransaction().remove(mFragment).commit();
            }
        }

        NetworkService.getInstance().getLessonApi().getLessons(course.id_course).enqueue(new Callback<List<Lesson>>() {
                @Override
                public void onResponse(Call<List<Lesson>> call, Response<List<Lesson>> response) {
                    FragmentTransaction FT = getChildFragmentManager().beginTransaction();
                    for (Lesson lesson: response.body()) {
                        LessonFragment c1 = new LessonFragment();
                        Bundle b1 = new Bundle();
                        b1.putSerializable("user", user);
                        b1.putSerializable("lesson", lesson);
                        c1.setArguments(b1);
                        FT.add(R.id.fragment_course_lessons, c1);
                    }
                    FT.commit();
                }

                @Override
                public void onFailure(Call<List<Lesson>> call, Throwable t) {
                    Toast.makeText(requireActivity().getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("Error", t.getMessage());
                }
            });

        return root;
    }
}
