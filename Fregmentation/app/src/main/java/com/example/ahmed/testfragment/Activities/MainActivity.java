package com.example.ahmed.testfragment.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ahmed.testfragment.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleTest(View view) {
        startActivity(new Intent(this,SimpleTestFag.class));
    }
    public void conterFrag(View view) {
        startActivity(new Intent(this,CounterFagActivit.class));
    }
    public void movieLandFrag(View view) { startActivity(new Intent(this,MovieLand.class));}
    public void movieListnerFrag(View view) { startActivity(new Intent(this,ListnerMovie.class));    }
}
