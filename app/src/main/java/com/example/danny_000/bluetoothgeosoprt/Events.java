package com.example.danny_000.bluetoothgeosoprt;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;


public class Events extends AppCompatActivity {

    ExpandableListView expandableListView;
    MyAdapter myAdapter;
    int numEvents;
    int numRegEvents = -1;
    String[] regEventTitle;
    String[] eventInfo;
    RegisteredEvents registeredEvents;
    String[] titleArray;
    String[] infoArray;

    static int current = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        setTitle("Events List");

        expandableListView = (ExpandableListView) findViewById(R.id.exp_listview);


        //------------------------------------------------
        numEvents = 7;
        String[] eventTitle = new String[numEvents];
        eventTitle[0] = "La Trobe Sport Center";
        eventTitle[1] = "Bundoora Park";
        eventTitle[2] = "Melbourne City";
        eventTitle[3] = "Melbourn University";
        eventTitle[4] = "Opera House Sydney";
        eventTitle[5] = "Kingsbury Suburb";
        eventTitle[6] = "RMIT University";

        eventInfo = new String[numEvents];
        eventInfo[0] = "Location: Melbourne Campus\nDate: 22, Aug 2016\nStart Time: 9:00 AM\nEvent Duration: 60 Mins";
        eventInfo[1] = "Location: Bundoora Park\nDate: 05, Sep 2016\nStart Time: 12:00 PM\nEvent Duration: 45 Mins";
        eventInfo[2] = "Location: Melbourne City Center\nDate: 15, Sep 2016\nStart Time: 11:30 AM\nEvent Duration: 90 Mins";
        eventInfo[3] = "Location: Melbourne Uni Campus\nDate: 25, Aug 2016\nStart Time: 9:00 AM\nEvent Duration: 60 Mins";
        eventInfo[4] = "Location: Opera House\nDate: 20, Sep 2016\nStart Time: 10:30 AM\nEvent Duration: 30 Mins";
        eventInfo[5] = "Location: Kingsbury\nDate: 17, Sep 2016\nStart Time: 1:30 PM\nEvent Duration: 90 Mins";
        eventInfo[6] = "Location: RMIT City Campus\nDate: 12, Sep 2016\nStart Time: 2:30 PM\nEvent Duration: 60 Mins";

        myAdapter = new MyAdapter(this, eventTitle, eventInfo);
        expandableListView.setAdapter(myAdapter);

        titleArray = new String[numEvents];
        infoArray = new String[numEvents];
    }

    public void show(View view) {
        Toast.makeText(this, "Enrolled in " + myAdapter.getGroup(myAdapter.getEvent()) + " Event", Toast.LENGTH_SHORT).show();
        int infoId = (int) myAdapter.getGroupId(myAdapter.getEvent());
        String regEventTitle = myAdapter.getGroup(myAdapter.getEvent()).toString();
     //   Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();

      /*  SharedPreferences prefs = getSharedPreferences("my_prefs", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("eTitle", regEventTitle);
        edit.putString("eInfo", eventInfo[infoId]);
        edit.commit();
        */

        ++current;
        titleArray[current] = regEventTitle;
        infoArray[current] = eventInfo[infoId];

        SharedPreferences prefs = getSharedPreferences("preferencename", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("size", titleArray.length);
        for(int i=0;i<titleArray.length;i++) {
            editor.putString("title" + "_" + i, titleArray[i]);
            editor.putString("info" + "_" + i, infoArray[i]);
        }
        editor.commit();
    }

}
