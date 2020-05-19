package com.example.eefrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eefrontend.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInStudent extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_student);

        Button signInButton = findViewById(R.id.button3);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkService NS = NetworkService.getInstance();
                String email = ((EditText)findViewById(R.id.editText)).getText().toString();
                String password = ((EditText)findViewById(R.id.editText5)).getText().toString();
                NS.getUserApi().getUser(email, password).enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if(response.code() == 103) {
                            Toast.makeText(getApplicationContext(), "Такой пользователь не зарегистрирован", Toast.LENGTH_SHORT).show();
                        }

                        if(response.code() == 102) {
                            Toast.makeText(getApplicationContext(), "Неправильный пароль", Toast.LENGTH_SHORT).show();
                        }

                        if(response.code() == 101) {
                            Intent myIntent = new Intent(SignInStudent.this, CourseList.class);
                            SignInStudent.this.startActivity(myIntent);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
