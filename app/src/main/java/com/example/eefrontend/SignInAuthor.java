package com.example.eefrontend;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eefrontend.entity.User;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInAuthor extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_author);

        Button signInButton = findViewById(R.id.button6);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkService NS = NetworkService.getInstance();
                String email = ((EditText)findViewById(R.id.editText7)).getText().toString();
                String password = ((EditText)findViewById(R.id.editText8)).getText().toString();
                NS.getUserApi().getUser(email, password).enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if(response.code() == 103) {
                            Toast.makeText(getApplicationContext(), "Такой пользователь не зарегистрирован", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if(response.code() == 102) {
                            Toast.makeText(getApplicationContext(), "Неправильный пароль", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Intent myIntent = new Intent(SignInAuthor.this, MainActivity.class);
                        List<User> user = response.body();
                        myIntent.putExtra(User.class.getSimpleName(), user.get(0));
                        SignInAuthor.this.startActivity(myIntent);
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("Error", t.getMessage());
                    }
                });
            }
        });
    }
}
