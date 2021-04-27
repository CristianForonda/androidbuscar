package com.habibnavarro.webinar.model.webinar;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.habibnavarro.webinar.EditWebinarActivity;
import com.habibnavarro.webinar.R;

import java.util.ArrayList;

public class WebinarAdapter extends RecyclerView.Adapter<WebinarAdapter.WebinarViewHolder> {
    ArrayList<Webinar> webinars;
    RecyclerView recyclerViewWebinar;
    Context c;
    WebinarController db;

    public WebinarAdapter(Context c, RecyclerView recyclerViewWebinar) {
        this.db = new WebinarController(c);
        this.c = c;
        this.recyclerViewWebinar = recyclerViewWebinar;
    }

    public void generateList() {
        this.webinars = new ArrayList<>();

        try {
            Cursor cursor = this.db.getAll();
            cursor.moveToFirst();
            do {
                this.webinars.add(new Webinar(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
                ));
            } while (cursor.moveToNext());
        } catch (Exception e) { }
        this.recyclerViewWebinar.setAdapter(this);
    }

    public void generateListByFilter(String name, String institute, String lecture) {
        this.webinars = new ArrayList<>();

        try {
            Cursor cursor = this.db.getByNameInstuteAndLecture(name, institute, lecture);
            cursor.moveToFirst();
            do {
                this.webinars.add(new Webinar(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                ));
            } while (cursor.moveToNext());
        } catch (Exception e) { }
        this.recyclerViewWebinar.setAdapter(this);
    }

    @NonNull
    @Override
    public WebinarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_webinar, null, false);
        return new WebinarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WebinarViewHolder holder, int position) {
        holder.id.setText(webinars.get(position).getId());
        holder.name.setText(webinars.get(position).getName());
        holder.institution.setText(webinars.get(position).getInstitution());
        holder.lecturer.setText(webinars.get(position).getLecturer());
        holder.date.setText(webinars.get(position).getDate());
        holder.link.setText(webinars.get(position).getLink());
    }

    @Override
    public int getItemCount() { return webinars.size(); }

    public class WebinarViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, institution, lecturer, date, link;
        Button btn_show_webinar;

        public WebinarViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.list_id);
            name = itemView.findViewById(R.id.list_name);
            institution = itemView.findViewById(R.id.list_institution);
            lecturer = itemView.findViewById(R.id.list_lecturer);
            date = itemView.findViewById(R.id.list_date);
            link = itemView.findViewById(R.id.list_link);
            btn_show_webinar = itemView.findViewById(R.id.btn_show_webinar);

            btn_show_webinar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(itemView.getContext(), EditWebinarActivity.class);
                    i.putExtra("id", id.getText().toString());
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }
}
