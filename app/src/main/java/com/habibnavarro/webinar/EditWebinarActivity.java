package com.habibnavarro.webinar;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.habibnavarro.webinar.model.webinar.Webinar;
import com.habibnavarro.webinar.model.webinar.WebinarController;

public class EditWebinarActivity extends AppCompatActivity {
    private WebinarController db;
    TextView inp_name, inp_institution, inp_conferencia, inp_date, inp_link;
    Button btn_edit, btn_back, btn_delete;
    Cursor webinar;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_webinar);

        inp_name = findViewById(R.id.inp_edit_webinar_name);
        inp_institution = findViewById(R.id.inp_edit_webinar_institution);
        inp_conferencia = findViewById(R.id.inp_edit_webinar_conferencia);
        inp_date = findViewById(R.id.inp_edit_webinar_date);
        inp_link = findViewById(R.id.inp_edit_webinar_link);
        btn_edit = findViewById(R.id.btn_edit_webinar);
        btn_back = findViewById(R.id.btn_edit_webinar_cancel);
        btn_delete = findViewById(R.id.btn_delete);

        id = getIntent().getStringExtra("id");

        db = new WebinarController(getApplicationContext());
        webinar = db.getById(id);

        inp_name.setText(webinar.getString(1));
        inp_institution.setText(webinar.getString(2));
        inp_conferencia.setText(webinar.getString(3));
        inp_date.setText(webinar.getString(4));
        inp_link.setText(webinar.getString(5));

        btn_edit.setOnClickListener(new View.OnClickListener() {
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

                    db.editById(id, w);
                    Toast.makeText(getApplicationContext(), "Registro actualizado", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.deleteById(id)) {
                    Toast.makeText(getApplicationContext(), "Registro eliminado satisfactoreamente", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                } else
                    Toast.makeText(getApplicationContext(), "Error!!!!!", Toast.LENGTH_SHORT).show();
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