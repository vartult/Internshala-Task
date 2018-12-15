package com.example.vartu.internshala;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class mydbmanager2 {



    private wsdatabase dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public mydbmanager2(Context c) {
        context = c;
    }

    public mydbmanager2 open() throws SQLException {
        dbHelper = new wsdatabase(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String des) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(wsdatabase.USER, name);
        contentValue.put(wsdatabase.WORKNAME, des);
        database.insert(wsdatabase.TABLE_NAME_2, null, contentValue);

    }

    public int fetch(String name, String data) {
        ArrayList<taken> newone=new ArrayList<>();
        String query = "SELECT * FROM userwork2 WHERE USERID= '" + name+"' AND WORKSHOP= '"+ data+ "';";

        Cursor  cursor = database.rawQuery(query,null);
        if (cursor.moveToFirst())
        {
            return 1;

        } else
        {

            return -1;
        }
    }


    public ArrayList<String> fetch_all(String name) {
        ArrayList<String> newone= new ArrayList<>();
        String query = "SELECT * FROM userwork2 ;";

        Cursor  cursor = database.rawQuery(query,null);
        if (cursor.moveToFirst()) {
            do {
                newone.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }
        return newone;
    }


}

