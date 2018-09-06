package com.example.academy_intern.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import javax.sql.DataSource;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button btnSearch = findViewById(R.id.btnSearch);
        TextView lblName = findViewById(R.id.lblName);

        TextView logout = findViewById(R.id.txtlogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {

            SearchView search = findViewById(R.id.txtSearch);
            TextView lblDisplay = findViewById(R.id.lblDisplayUser);

            DataSources data = new DataSources();

            @Override
            public void onClick(View v) {
                if(!(data.searchUser(search.getQuery().toString()).getName()).isEmpty()) {
                    if(data.searchUser(search.getQuery().toString()).getName() != null)
                        lblDisplay.setText(data.searchUser(search.getQuery().toString()).getName());
                    else
                        Toast.makeText(getApplicationContext(),"The is no matching username", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(getApplicationContext(),"Please enter value to the search bar", Toast.LENGTH_SHORT).show();

                }
            }
        });

        lblName.setText(DataSources.globalUser.getName());
    }
}
