package com.habibnavarro.webinar.model.webinar;

public class WebinarDefDB {
    public static final String table_name = "webinars";

    public static final String col_name = "name";
    public static final String col_institution = "institution";
    public static final String col_lecturer = "lecturer";
    public static final String col_date = "date";
    public static final String col_link = "link";

    public static final String drop_table = "DROP TABLE IF EXISTS" + WebinarDefDB.table_name + ";";
    public static final String create_table = "CREATE TABLE IF NOT EXISTS " +
            WebinarDefDB.table_name + " ( " +
            "id INTEGER PRIMARY KEY," +
            WebinarDefDB.col_name + " TEXT," +
            WebinarDefDB.col_institution + " TEXT," +
            WebinarDefDB.col_lecturer + " TEXT," +
            WebinarDefDB.col_date + " TEXT," +
            WebinarDefDB.col_link + " TEXT" +
            ");";
}
