package com.example.academy_intern.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnLogin =   findViewById(R.id.bntAdd);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DataSources data = new DataSources();

                EditText password = findViewById(R.id.txtPassword);
                EditText username = findViewById(R.id.txtUsername);

                if(username.getText().toString().isEmpty()){
                    username.setError("This field is empty");
                }else if(password.getText().toString().isEmpty()){
                    password.setError("This field is empty");
                } else{
                    if (data.isLoggedIn(username.getText().toString(), password.getText().toString())) {

                        Toast.makeText(getApplicationContext(),"You are logged in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Home.class);
                        startActivity(intent);

                    }else{

                        Toast.makeText(getApplicationContext(),"Wrong username or password", Toast.LENGTH_SHORT).show();

                    }
                }

            }

        });

    }

   public void registerView(View v){

       Intent intent = new Intent(MainActivity.this, Register.class);
       startActivity(intent);
       finish();
   }


}
