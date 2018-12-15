package com.example.vartu.internshala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Final extends AppCompatActivity {
    TextView name;
    mydbmanager2 mydbmanager2;
    SessionManagement session;
    ArrayList<String> all=new ArrayList<>();
    ListView taken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent i = getIntent();
        final String product = i.getStringExtra("tag");
        taken=(ListView)findViewById(R.id.taken);
        name=(TextView)findViewById(R.id.name);
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();

        String user = session.getUserDetails();
        name.setText(user);

        mydbmanager2 = new mydbmanager2(this);
        mydbmanager2.open();

        if(mydbmanager2.fetch(user,product)==1){
            Toast.makeText(getApplicationContext(),"Already Registered",Toast.LENGTH_LONG).show();
        }
        else{
            mydbmanager2.insert(user,product);
            Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_LONG).show();
        }



    }
}
