package com.example.eefrontend.ui.my_courses.course;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.eefrontend.MainActivity;
import com.example.eefrontend.NetworkService;
import com.example.eefrontend.R;
import com.example.eefrontend.entity.Course;
import com.example.eefrontend.entity.Lesson;
import com.example.eefrontend.entity.User;
import com.example.eefrontend.ui.course_lessons.CourseLessonsFragment;
import com.example.eefrontend.ui.course_lessons.lesson.LessonFragment;
import com.example.eefrontend.ui.my_courses.MyCoursesViewModel;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseFragment extends Fragment {

    CourseViewModel courseViewModel;
    User user;
    Course course;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        courseViewModel =
                ViewModelProviders.of(this).get(CourseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_course, container, false);
        user = (User)getArguments().getSerializable("user");
        course = (Course)getArguments().getSerializable("course");
        TextView textView = root.findViewById(R.id.titleText);
        textView.setText(course.title);

        ImageView imageView = root.findViewById(R.id.imageBlock);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                final Activity activity = requireActivity();
//                FragmentManager fm = getParentFragmentManager(); // or 'getSupportFragmentManager();'
//                int count = fm.getBackStackEntryCount();
//                for(int i = 0; i < count; ++i) {
//                    fm.popBackStack();
//                }
//
//                if (getParentFragmentManager().getFragments() != null && getParentFragmentManager().getFragments().size() > 0) {
//                    for (int i = 0; i < getParentFragmentManager().getFragments().size(); i++) {
//                        Fragment mFragment = getParentFragmentManager().getFragments().get(i);
//                        if (mFragment != null)
//                            getParentFragmentManager().beginTransaction().remove(mFragment).commit();
//                    }
//                }

                CourseLessonsFragment c1 = new CourseLessonsFragment();
                Bundle b1 = new Bundle();
                b1.putSerializable("course", course);
//                c1.setArguments(b1);

//                ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().replace(requireActivity().getSupportFragmentManager().getFragments().get(0).getId(), c1).commit();


                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.action_nav_my_courses_to_nav_course_lessons, b1);
            }
        });

        return root;
    }

}
