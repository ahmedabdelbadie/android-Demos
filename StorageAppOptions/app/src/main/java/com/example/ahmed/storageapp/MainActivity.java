package com.example.ahmed.storageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void shared(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void storage(View view) {
        startActivity(new Intent(this,SaveData.class));
    }

    public void saveSQL(View view) {
        startActivity(new Intent(this,LoginSQL.class));
    }
}
