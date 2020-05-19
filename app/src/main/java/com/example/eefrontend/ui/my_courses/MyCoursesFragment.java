package com.example.eefrontend.ui.my_courses;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.eefrontend.MainActivity;
import com.example.eefrontend.NetworkService;
import com.example.eefrontend.R;
import com.example.eefrontend.entity.Course;
import com.example.eefrontend.entity.User;
import com.example.eefrontend.ui.my_courses.course.CourseFragment;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCoursesFragment extends Fragment {

    private MyCoursesViewModel myCoursesViewModel;
    public User user;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        myCoursesViewModel =
//                ViewModelProviders.of(this).get(MyCoursesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my_courses, container, false);

        user = ((MainActivity) requireActivity()).user;

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

        NetworkService.getInstance().getCourseApi().getCourse(user.email).enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                FragmentTransaction FT = getChildFragmentManager().beginTransaction();
                for (Course course: response.body()) {
                    CourseFragment c1 = new CourseFragment();
                    Bundle b1 = new Bundle();
                    b1.putSerializable("user", user);
                    b1.putSerializable("course", course);
                    c1.setArguments(b1);
                    FT.add(R.id.fragment_my_courses, c1);
                }
                FT.commit();
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Toast.makeText(requireActivity().getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Error", t.getMessage());
            }
        });

        return root;
    }
}
