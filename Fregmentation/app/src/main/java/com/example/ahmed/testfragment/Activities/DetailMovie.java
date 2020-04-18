package com.example.ahmed.testfragment.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ahmed.testfragment.Fragment.FragmentLB;
import com.example.ahmed.testfragment.R ;

public class DetailMovie extends AppCompatActivity {

    private FragmentLB fragmentLB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Log.e("respond","on create activity 2 ");

        Intent in = getIntent() ;
        Log.e("respond","on create activity 3 ");

        fragmentLB = (FragmentLB) getSupportFragmentManager().findFragmentById(R.id.fragment3);
        Log.e("respond","item "+in.getIntExtra("id",0));
        fragmentLB.showdesc(in.getIntExtra("id",0));
        Log.e("respond","item "+in.getIntExtra("id",0));
    }
}
