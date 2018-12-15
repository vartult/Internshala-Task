package com.example.vartu.internshala;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class wsdatabase extends SQLiteOpenHelper {

    //for the first table
    public static final String WS_TABLE_NAME = "workshoplist";
    public static final String WS_COLUMN_ID = "ID";
    public static final String WS_COLUMN_NAME = "WORKSHOP";
    public static final String WS_COLUMN_DES = "DESCRIPTION";

    //second table
    public static final String TABLE_NAME_1 = "userlist";
    public static final String username = "USERID";
    public static final String password = "PASS";

    //third table
    public static final String TABLE_NAME_2 = "userwork";
    public static final String USER = "USERID";
    public static final String WORKNAME = "WORKSHOP";

//table 1
    private static final String CREATE_TABLE = "CREATE TABLE " + WS_TABLE_NAME + " (" + WS_COLUMN_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + WS_COLUMN_NAME + " TEXT, " +WS_COLUMN_DES + " TEXT ); ";


    //second table
    private static final String CREATE_TABLE_1 = "CREATE TABLE " + TABLE_NAME_1 + " (" + username
            + " TEXT PRIMARY KEY, " +password + " TEXT ); ";


    //third table
    private static final String CREATE_TABLE_2 = "CREATE TABLE " + TABLE_NAME_2 + " (" + USER
            + " TEXT, " +WORKNAME + " TEXT ); ";

    public wsdatabase(Context context) {
        super(context,"new.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE_1);
        db.execSQL(CREATE_TABLE_2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2);
        onCreate(db);
    }
}






