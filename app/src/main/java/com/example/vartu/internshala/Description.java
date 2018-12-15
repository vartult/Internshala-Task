package com.example.vartu.internshala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Description extends AppCompatActivity {
    TextView heading,description;
    mydbmanager mydbmanager;
    workshop workshops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        heading=(TextView)findViewById(R.id.heading);
        description=(TextView)findViewById(R.id.description);
        Intent i = getIntent();
        String product = i.getStringExtra("team");
        heading.setText(product);

        mydbmanager = new mydbmanager(this);
        mydbmanager.open();

        workshops = mydbmanager.fetch_specific(product);
        description.setText(workshops.getDescription());
        Log.d("newnew","ye agla page"+workshops.getDescription());

    }
}
