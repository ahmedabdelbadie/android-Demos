package com.example.ahmed.navimanually;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity {
    private Toolbar toolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar =findViewById(R.id.app_bar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("home", "onOptionsItemSelected: clicked ");
        Log.d("home", "onOptionsItemSelected: "+android.R.id.home);
        Log.d("home", "onOptionsItemSelected: "+item.getItemId());
        if (item.getItemId()==android.R.id.home){
            Log.d("home", "onOptionsItemSelected: Home ");
            NavUtils.navigateUpFromSameTask(this);
            return  true ;
        }
        return super.onOptionsItemSelected(item);
    }
}
