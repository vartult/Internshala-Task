package com.example.vartu.internshala;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    public DashboardFragment() {
        // Required empty public constructor
    }
    ListView taken;
    mydbmanager2 mydbmanager2;
    SessionManagement session;
    ArrayList<String> all=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);
        taken=(ListView)view.findViewById(R.id.taken);
        session = new SessionManagement(getContext());
        session.checkLogin();

        String user = session.getUserDetails();
        mydbmanager2 = new mydbmanager2(getContext());
        mydbmanager2.open();

        all.add("String");
        all=mydbmanager2.fetch_all(user);

        ArrayAdapter<String> worklist= new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                all
        );

        taken.setAdapter(worklist);
        return view;
    }

}
