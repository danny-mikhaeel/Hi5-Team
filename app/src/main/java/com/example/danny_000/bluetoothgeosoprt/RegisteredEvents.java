package com.example.danny_000.bluetoothgeosoprt;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class RegisteredEvents extends AppCompatActivity {


    private String eventTitle;
    private String eventInfo;
    int maxEvents;
    static int current = -1;
    String[] titles;
    String[] info;

    MyAdapter adapter;
    ExpandableListView expandableListView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_events);
        this.setTitle("Registered Events");


        String[] titles = new String[7];
        String[] info = new String[7];

        expandableListView1 = (ExpandableListView) findViewById(R.id.exp_listview1);

       /* SharedPreferences preferences = getSharedPreferences("my_prefs", 0);
        eventTitle = preferences.getString("eTitle", "");
        eventInfo = preferences.getString("eInfo", "");
        titles[0] = eventTitle;
        info[0] = eventInfo;
        */


        SharedPreferences prefs = getSharedPreferences("preferencename", 0);
        int size = prefs.getInt("size", 0);
        String titleArray[] = new String[size];
        String infoArray[] = new String[size];
        for(int i=0;i<size;i++) {
            titleArray[i] = prefs.getString("title" + "_" + i, null);
            infoArray[i] = prefs.getString("info" + "_" + i, null);
        }

        adapter = new MyAdapter(this, titleArray, infoArray);
        expandableListView1.setAdapter(adapter);
     //   Toast.makeText(this, eventTitle + eventInfo, Toast.LENGTH_SHORT).show();

    }

}
