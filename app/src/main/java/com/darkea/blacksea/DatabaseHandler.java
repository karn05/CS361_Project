package com.darkea.blacksea;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    //constant variables (name, ver, columns)
    private static final String DB_NAME = "BlackSea";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "BioHistory";
    //private static final String TABLE_NAME_2 = "PlayText";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "Name";
    private static final String BIO_COL = "Bio";
    public static final String DAYS_COL = "Days";
    //public static final String DPASS_COL = "DaysPassed";
    //public static final String PLAY_COL = "PlayTxt";

    //constructor
    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table using query
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + BIO_COL + " TEXT,"
                + DAYS_COL + " INT)";
        db.execSQL(query);

        /*
        String query2 = "CREATE TABLE " + TABLE_NAME_2 + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PLAY_COL + " TEXT,"
                + DPASS_COL + " INT)";
        db.execSQL(query2);
         */
    }

    public void addNewData(String name, String biography, int daySurvived) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            //assign value --> columns
            values.put(NAME_COL, name);
            values.put(BIO_COL, biography);
            values.put(DAYS_COL, daySurvived);

            //passing values
            db.insert(TABLE_NAME, null, values);
            db.close();


    }

    public ArrayList<Instance> readCourses() {
        SQLiteDatabase db = this.getReadableDatabase();
        //sql query to select
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<Instance> courseModalArrayList = new ArrayList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                courseModalArrayList.add(new Instance(cursorCourses.getString(1),
                        cursorCourses.getString(2)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return courseModalArrayList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2);
        onCreate(db);
    }





}