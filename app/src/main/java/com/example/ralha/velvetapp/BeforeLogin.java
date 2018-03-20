package com.example.ralha.velvetapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BeforeLogin extends AppCompatActivity {

    Button register;
    Button login;
    Button continueGuest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_login);

        login=(Button)findViewById(R.id.buttonLogIn);
        register=(Button)findViewById(R.id.registerBtn);
        continueGuest=(Button)findViewById(R.id.continueasguestBtn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BeforeLogin.this,LogInActivity.class);
                startActivity(intent);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BeforeLogin.this, MainActivity.class));
            }
        });

        continueGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BeforeLogin.this,HomePage.class));

            }
        });



    }
}
