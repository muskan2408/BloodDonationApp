package com.startupnationgo.blooddonationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    @Override
    public void onBackPressed() {
        Intent i =new Intent(Notification.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
