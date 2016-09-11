package com.example.danny_000.bluetoothgeosoprt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.setTitle("Dashboard");
    }

    public void showEvents(View view) {
        intent = new Intent(this, Events.class);
        startActivity(intent);
    }

    public void showProfile(View view) {
        intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void showRegEvents(View view) {
        intent = new Intent(this, RegisteredEvents.class);
        startActivity(intent);
    }
}
