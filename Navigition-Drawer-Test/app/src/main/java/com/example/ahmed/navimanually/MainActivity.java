package com.example.ahmed.navimanually;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;
import com.example.ahmed.navimanually.R;


public class MainActivity extends AppCompatActivity  {
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menue,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.app_bar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        BlankFragment fragment = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.blank_frag);
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        fragment.setup(R.id.blank_frag,drawerLayout,toolbar);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.men_next){
        startActivity(new Intent(this,Main2Activity.class));
        }
        return super.onOptionsItemSelected(item);

    }


}
