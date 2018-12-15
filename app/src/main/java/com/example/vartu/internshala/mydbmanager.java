package com.example.vartu.internshala;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class mydbmanager {

    

        private wsdatabase dbHelper;

        private Context context;

        private SQLiteDatabase database;

        public mydbmanager(Context c) {
            context = c;
        }

        public mydbmanager open() throws SQLException {
            dbHelper = new wsdatabase(context);
            database = dbHelper.getWritableDatabase();
            return this;
        }

        public void close() {
            dbHelper.close();
        }

        public void insert(String name, String des) {
            ContentValues contentValue = new ContentValues();
            contentValue.put(wsdatabase.WS_COLUMN_NAME, name);
            contentValue.put(wsdatabase.WS_COLUMN_DES, des);
            database.insert(wsdatabase.WS_TABLE_NAME, null, contentValue);

        }

        public ArrayList<workshop> fetch() {
            ArrayList<workshop> newone=new ArrayList<>();
            String[] columns = new String[] { wsdatabase.WS_COLUMN_ID, wsdatabase.WS_COLUMN_NAME, wsdatabase.WS_COLUMN_DES };
            Cursor cursor = database.query(wsdatabase.WS_TABLE_NAME, columns, null, null, null, null, null);
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
        public workshop fetch_specific(String work){
            workshop notes=new workshop();
            String query = "SELECT * FROM workshoplist WHERE WORKSHOP= '" + work+"';";

            Cursor  cursor = database.rawQuery(query,null);

            if (cursor.moveToFirst()) {
                do {
                    notes.setId(Integer.parseInt(cursor.getString(0)));
                    notes.setWorkshop(cursor.getString(1));
                    notes.setDescription(cursor.getString(2));

                } while (cursor.moveToNext());
            }
            return notes;
        }


    }

