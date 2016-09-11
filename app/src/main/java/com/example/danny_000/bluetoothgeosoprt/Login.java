package com.example.danny_000.bluetoothgeosoprt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void go(View view) {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
