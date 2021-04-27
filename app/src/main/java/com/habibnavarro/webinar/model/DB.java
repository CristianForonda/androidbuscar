package com.habibnavarro.webinar.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.habibnavarro.webinar.model.webinar.WebinarDefDB;

public class DB extends SQLiteOpenHelper {
    private final static String db_name = "Webinar_db";

    public DB(@Nullable Context context, int version) {
        super(context, DB.db_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WebinarDefDB.create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { onCreate(db); }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
