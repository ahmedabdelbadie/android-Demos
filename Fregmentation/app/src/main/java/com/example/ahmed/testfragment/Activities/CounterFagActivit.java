package com.example.ahmed.testfragment.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahmed.testfragment.Fragment.CounterFragmentB;
import com.example.ahmed.testfragment.CounterInterface;
import com.example.ahmed.testfragment.R;

public class CounterFagActivit extends AppCompatActivity implements CounterInterface {
    CounterFragmentB fragmentB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_fag);
    }

    @Override
    public void Count(String c) {
        fragmentB = (CounterFragmentB) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fragmentB.respond(c);
    }
}
