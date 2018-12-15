package com.example.vartu.internshala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Final extends AppCompatActivity {
    TextView name;
    SessionManagement session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent i = getIntent();
        final String product = i.getStringExtra("tag");
        name=(TextView)findViewById(R.id.name);
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();

        String user = session.getUserDetails();
        name.setText(user);







    }
}
