package com.example.vartu.internshala;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class mydbmanager1 {



    private wsdatabase dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public mydbmanager1(Context c) {
        context = c;
    }

    public mydbmanager1 open() throws SQLException {
        dbHelper = new wsdatabase(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String des) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(wsdatabase.username, name);
        contentValue.put(wsdatabase.password, des);
        database.insert(wsdatabase.TABLE_NAME_1, null, contentValue);

    }


    public Integer fetch_specific(String work){
        String notes = null;
        String query = "SELECT * FROM workshoplist WHERE WORKSHOP= '" + work+"';";

        Cursor  cursor = database.rawQuery(query,null);

        if (cursor.moveToFirst()) {
            do {

                notes=cursor.getString(1);

            } while (cursor.moveToNext());
        }
        if(notes==null)
            return -1;
        else
            return 1;
    }


}

