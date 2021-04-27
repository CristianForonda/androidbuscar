package com.habibnavarro.webinar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.habibnavarro.webinar.model.webinar.WebinarAdapter;

public class ListWebinarActivity extends AppCompatActivity {
    RecyclerView recyclerWebinar;
    TextView name, institution, lecture;
    WebinarAdapter webinarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_webinar);

        name = findViewById(R.id.list_filter_name);
        institution = findViewById(R.id.list_filter_institution);
        lecture = findViewById(R.id.list_filter_lecture);

        recyclerWebinar = findViewById(R.id.recyclerViewListWebinar);
        recyclerWebinar.setLayoutManager(new LinearLayoutManager(this));

        webinarAdapter = new WebinarAdapter(getApplicationContext(), recyclerWebinar);
        webinarAdapter.generateList();
        
        TextWatcher filter = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                webinarAdapter.generateListByFilter(
                        name.getText().toString(),
                        institution.getText().toString(),
                        lecture.getText().toString()
                    );
            }

            @Override
            public void afterTextChanged(Editable s) { }
        };
        
        name.addTextChangedListener(filter);
        institution.addTextChangedListener(filter);
        lecture.addTextChangedListener(filter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        webinarAdapter.generateListByFilter(
                name.getText().toString(),
                institution.getText().toString(),
                lecture.getText().toString()
        );
    }
}