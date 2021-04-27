package com.habibnavarro.webinar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.habibnavarro.webinar.model.webinar.WebinarDefDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_main_create_webinar = findViewById(R.id.btn_main_create_webinar);
        Button btn_list_webinars = findViewById(R.id.btn_list_webinars);

        btn_main_create_webinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateWebinarActivity.class));
            }
        });

        btn_list_webinars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListWebinarActivity.class));
            }
        });
    }
}