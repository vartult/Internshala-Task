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

    public ArrayList<workshop> fetch(String name, String data) {
        ArrayList<workshop> newone=new ArrayList<>();
        String[] columns = new String[] { wsdatabase.USER, wsdatabase.WORKNAME };
        Cursor cursor = database.query(wsdatabase.TABLE_NAME_2, columns, "Column1 ="+name+" AND Column2 ="+data, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                workshop notes = new workshop();
                notes.setId(Integer.parseInt(cursor.getString(0)));
                notes.setWorkshop(cursor.getString(1));
                notes.setDescription(cursor.getString(2));
                // Adding note to list
                newone.add(notes);
            } while (cursor.moveToNext());
        }
        return newone;
    }


}

