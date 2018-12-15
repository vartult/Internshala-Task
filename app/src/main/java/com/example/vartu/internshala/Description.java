package com.example.vartu.internshala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Description extends AppCompatActivity {
    TextView heading,description;
    mydbmanager mydbmanager;
    workshop workshops;
    Button apply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        heading=(TextView)findViewById(R.id.heading);
        description=(TextView)findViewById(R.id.description);
        apply=(Button)findViewById(R.id.apply);
        Intent i = getIntent();
        final String product = i.getStringExtra("team");
        heading.setText(product);

        mydbmanager = new mydbmanager(this);
        mydbmanager.open();

        workshops = mydbmanager.fetch_specific(product);
        description.setText(workshops.getDescription());
        Log.d("newnew","ye agla page"+workshops.getDescription());

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), Final.class);
                // sending data to new activity
                i.putExtra("tag",product);
                startActivity(i);
            }
        });

    }
}
