package com.example.eefrontend;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.eefrontend.entity.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        final EditText nameEditText = findViewById(R.id.editText2);
        final EditText emailEditText = findViewById(R.id.editText3);
        final EditText passwordEditText = findViewById(R.id.editText4);
        final Button signUpButton = findViewById(R.id.button4);

        final ImageView studentImage = findViewById(R.id.imageView14);
        final ImageView authorImage = findViewById(R.id.imageView13);

        studentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEditText.setEnabled(true);
                emailEditText.setEnabled(true);
                passwordEditText.setEnabled(true);
                signUpButton.setEnabled(true);

                studentImage.setEnabled(false);
                authorImage.setEnabled(true);

                authorImage.setImageAlpha(126);
                studentImage.setImageAlpha(255);
            }
        });

        authorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEditText.setEnabled(true);
                emailEditText.setEnabled(true);
                passwordEditText.setEnabled(true);
                signUpButton.setEnabled(true);

                authorImage.setEnabled(false);
                studentImage.setEnabled(true);

                authorImage.setImageAlpha(255);
                studentImage.setImageAlpha(126);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (email == "" || password == "") {
                    Toast.makeText(getApplicationContext(), "Заполните все необходимые поля!", Toast.LENGTH_SHORT).show();
                    return;
                }

                NetworkService NS = NetworkService.getInstance();
                NS.getUserApi().postUser(new User(email, password)).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Успешно!", Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(SignUp.this, FirstPage.class);
                            SignUp.this.startActivity(myIntent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Такой пользователь уже зарегистрирован!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("Error", t.getMessage());
                    }
                });
            }
        });
    }
}
