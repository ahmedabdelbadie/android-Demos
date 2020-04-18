package com.example.ahmed.testfragment.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.ahmed.testfragment.Fragment.FragmentA;
import com.example.ahmed.testfragment.Fragment.FragmentB;
import com.example.ahmed.testfragment.ItemId;
import com.example.ahmed.testfragment.R;


public class MovieLand extends AppCompatActivity  implements ItemId {

    FragmentA fragmentA ;
    FragmentB fragmentB ;
    private FragmentManager manager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_land);
        manager=getSupportFragmentManager();
        if (savedInstanceState != null){
            fragmentA = (FragmentA) manager.findFragmentById(R.id.fragmenta);
            fragmentB = (FragmentB) manager.findFragmentById(R.id.fragmentb);
        }
    }
    @Override
    public void respond(int id) {
        FragmentB fragment = (FragmentB) manager.findFragmentById(R.id.fragmentb);
        fragment.showdesc(id);

    }
}
