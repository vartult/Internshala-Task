package com.example.vartu.internshala;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class wsdatabase extends SQLiteOpenHelper {
    public static final String WS_TABLE_NAME = "workshoplist";
    public static final String WS_COLUMN_ID = "ID";
    public static final String WS_COLUMN_NAME = "WORKSHOP";
    public static final String WS_COLUMN_DES = "DESCRIPTION";

    private static final String CREATE_TABLE = "CREATE TABLE " + WS_TABLE_NAME + " (" + WS_COLUMN_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + WS_COLUMN_NAME + " TEXT, " +WS_COLUMN_DES + " TEXT ); ";

    public wsdatabase(Context context) {
        super(context,"new.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WS_TABLE_NAME);
        onCreate(db);
    }
}






