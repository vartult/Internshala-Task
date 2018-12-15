package com.example.vartu.internshala;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    String[] sample=new String[4];


    public HomeFragment() {
        // Required empty public constructor
    }
    ListView workshop;
    mydbmanager mydbmanager;
    ArrayList<workshop> workshops;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        mydbmanager = new mydbmanager(getContext());
        mydbmanager.open();
        /*mydbmanager.insert("android","qwertyuiop");
        mydbmanager.insert("Python","asdfghjkl");
        mydbmanager.insert("Web Development","zxcvbnm");
        mydbmanager.insert("iOS","qwertyzxcvbnm");*/

        workshop=(ListView)view.findViewById(R.id.workshoplist);
        workshops = mydbmanager.fetch();
        //Log.d("YE BHAI ALAG HAI","all notes:"+workshops.get(3).getWorkshop());

            for(int i=0;i<4;i++){
                //Log.d("YE BHAI ALAG HAI","all notes:"+workshops.get(3).getWorkshop());
                sample[i]=workshops.get(i).getWorkshop();

            }


       ArrayAdapter<String> worklist= new ArrayAdapter<String>(
               getActivity(),
               android.R.layout.simple_list_item_1,
               android.R.id.text1,
               sample
        );

        workshop.setAdapter(worklist);

        workshop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item
                String team = ((TextView) view).getText().toString();

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getContext(), Description.class);
                // sending data to new activity
                i.putExtra("team", team);
                startActivity(i);

            }
        });
        //Log.e("YE BHAI ALAG HAIN", "all notes: " + workshops.toString());




        return view;
    }

}
