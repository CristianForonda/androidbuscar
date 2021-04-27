package com.habibnavarro.webinar.model.webinar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.habibnavarro.webinar.model.DB;

public class WebinarController {
    private DB db;
    private Context c;

    public WebinarController(Context c) {
        this.db = new DB(c, 1);
        this.c = c;
    }

    public long create(Webinar w) {
        SQLiteDatabase sql = this.db.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(WebinarDefDB.col_name, w.getName());
        cv.put(WebinarDefDB.col_institution, w.getInstitution());
        cv.put(WebinarDefDB.col_lecturer, w.getLecturer());
        cv.put(WebinarDefDB.col_date, w.getDate());
        cv.put(WebinarDefDB.col_link, w.getLink());

        long id = sql.insert(WebinarDefDB.table_name,null, cv);
        sql.close();

        return id;
    }

    public Cursor getAll() {
        SQLiteDatabase data = db.getReadableDatabase();
        Cursor cur = data.rawQuery( "SELECT * FROM " + WebinarDefDB.table_name,null);
        if (cur != null)
            cur.moveToFirst();
        return cur;
    }

    public Cursor getById(String id) {
        SQLiteDatabase data = db.getReadableDatabase();
        Cursor cur = data.rawQuery( "SELECT * FROM " + WebinarDefDB.table_name + " WHERE id=" + id,null);
        if (cur != null)
            cur.moveToFirst();
        return cur;
    }

    public Cursor getByNameInstuteAndLecture(String name, String institute, String lecture) {
        SQLiteDatabase data = db.getReadableDatabase();
        String where = "1 = 1 ";

        if (name.length() != 0)
            where += "AND " + WebinarDefDB.col_name + " LIKE '%" + name + "%' ";
        if (institute.length() != 0)
            where += "AND " + WebinarDefDB.col_institution + " LIKE '%" + institute + "%' ";
        if (lecture.length() != 0)
            where += "AND " + WebinarDefDB.col_lecturer + " LIKE '%" + lecture + "%' ";

        Cursor cur = data.rawQuery( "SELECT * FROM " + WebinarDefDB.table_name + " WHERE " + where,null);
        if (cur != null)
            cur.moveToFirst();
        return cur;
    }

    public boolean deleteById(String id) {
        SQLiteDatabase db = this.db.getWritableDatabase();
        return db.delete(WebinarDefDB.table_name, "id="+id, null) > 0;
    }

    public void editById(String id, Webinar w) {
        SQLiteDatabase sql = this.db.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(WebinarDefDB.col_name, w.getName());
        cv.put(WebinarDefDB.col_institution, w.getInstitution());
        cv.put(WebinarDefDB.col_lecturer, w.getLecturer());
        cv.put(WebinarDefDB.col_date, w.getDate());
        cv.put(WebinarDefDB.col_link, w.getLink());

        sql.update(WebinarDefDB.table_name, cv,"id=?", new String[]{id});
    }
}
