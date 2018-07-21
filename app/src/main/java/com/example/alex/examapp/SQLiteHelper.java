package com.example.alex.examapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import java.util.ArrayList;



public class SQLiteHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "DB_STRING";
    private final static int DB_VERSION = 2;
    private final static String ID = "_id";
    private final static String STRING_TEXT = "STRING_TEXT";
    private final static String TABLE_NAME = "TABLE_NAME";




    private final static String ID_VIEWED_VACANCY = "ID_VIEWED_VACANCY";

    private final String CREATED_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + "(" +
            ID + " INTEGER_PRIMARY_KEY, " +
            STRING_TEXT + " TEXT " +
            ");";



    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATED_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATED_TABLE);

        onCreate(sqLiteDatabase);
    }

    public void save(ArrayList<String> list) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        for (int i = 0; i < list.size(); i++) {
            cv.put(STRING_TEXT, list.get(i));
            db.insert(CREATED_TABLE,null,cv);
        }

        db.close();
    }

    public ArrayList<String> getViewed() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = db.query(
                CREATED_TABLE,
                null,
                null,
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            int id_text = cursor.getColumnIndex(STRING_TEXT);

            do {
                list.add(cursor.getString(id_text));

            } while (cursor.moveToNext());
            Log.d("row is getting", "ok");
        } else {
            Log.d("row is not getting", "fail");
        }

        cursor.close();
        db.close();
        return list;
    }



}
