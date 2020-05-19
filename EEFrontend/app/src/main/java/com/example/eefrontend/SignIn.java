package com.example.eefrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_role);

        LinearLayout studentLay = findViewById(R.id.linearLayout2);
        LinearLayout authorLay = findViewById(R.id.linearLayout);

        studentLay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SignIn.this, SignInStudent.class);
                SignIn.this.startActivity(myIntent);
            }
        });

        authorLay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SignIn.this, SignInAuthor.class);
                SignIn.this.startActivity(myIntent);
            }
        });
    }
}
