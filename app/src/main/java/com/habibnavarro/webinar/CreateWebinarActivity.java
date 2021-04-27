package com.habibnavarro.webinar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.habibnavarro.webinar.model.webinar.Webinar;
import com.habibnavarro.webinar.model.webinar.WebinarController;

public class CreateWebinarActivity extends AppCompatActivity {
    TextView inp_name, inp_institution, inp_conferencia, inp_date, inp_link;
    Button btn_create, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_webinar);

        inp_name = findViewById(R.id.inp_create_webinar_name);
        inp_institution = findViewById(R.id.inp_create_webinar_institution);
        inp_conferencia = findViewById(R.id.inp_create_webinar_conferencia);
        inp_date = findViewById(R.id.inp_create_webinar_date);
        inp_link = findViewById(R.id.inp_create_webinar_link);
        btn_create = findViewById(R.id.btn_create_webinar);
        btn_back = findViewById(R.id.btn_create_webinar_cancel);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inp_name.getText().toString(),
                        institution = inp_institution.getText().toString(),
                        lecture = inp_conferencia.getText().toString(),
                        date = inp_date.getText().toString(),
                        link = inp_link.getText().toString();

                if (name.length() == 0)
                    Toast.makeText(getApplicationContext(), "Nombre requerido", Toast.LENGTH_SHORT).show();
                else if (institution.length() == 0)
                    Toast.makeText(getApplicationContext(), "Institución Organizadora requerida", Toast.LENGTH_SHORT).show();
                else if (lecture.length() == 0)
                    Toast.makeText(getApplicationContext(), "Conferencista requerido", Toast.LENGTH_SHORT).show();
                else if (date.length() == 0)
                    Toast.makeText(getApplicationContext(), "Fecha requerida", Toast.LENGTH_SHORT).show();
                else if (link.length() == 0)
                    Toast.makeText(getApplicationContext(), "Link de Webinar requerido", Toast.LENGTH_SHORT).show();
                else {
                    Webinar w = new Webinar(name, institution, lecture, date, link);
                    WebinarController wc = new WebinarController(getApplicationContext());

                    Toast.makeText(getApplicationContext(), "Registro satisfactorio: " + wc.create(w), Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}