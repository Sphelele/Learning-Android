package com.example.academy_intern.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import javax.sql.DataSource;


public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button reg = findViewById(R.id.bntRegister);

        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText username = findViewById(R.id.txtRusername);
                EditText password = findViewById(R.id.txtRpassword);
                EditText name = findViewById(R.id.txtname);
                EditText confirmPassword = findViewById(R.id.txtRConfirmpassword);


                User user = new User();
                DataSources data = new DataSources();

                if(name.getText().toString().isEmpty()){
                    name.setError("This field is empty");
                }
                else if(!data.isValidEmail(username.getText().toString())){
                    username.setError("Please check format");
                } else if(password.getText().toString().isEmpty()){
                    password.setError("This field is empty");
                }else if(confirmPassword.getText().toString().isEmpty()){
                    confirmPassword.setError("This field is empty");
                }else {

                    user.setUsername(username.getText().toString());
                    user.setName(name.getText().toString());
                    user.setPassword(password.getText().toString());

                    if(!(password.equals(confirmPassword)) && data.addUser(user)) {

                        Toast.makeText(getApplicationContext(), "You are registered successfully!!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, MainActivity.class);

                        startActivity(intent);
                    }else {
                        confirmPassword.getError();
                        Toast.makeText(getApplicationContext(), "Passwords don't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}
