package com.example.ahmed.testfragment.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ahmed.testfragment.Fragment.FragmentB;
import com.example.ahmed.testfragment.Fragment.FragmentLA;
import com.example.ahmed.testfragment.Fragment.FragmentLB;
import com.example.ahmed.testfragment.R ;

public class ListnerMovie extends AppCompatActivity implements FragmentLA.Communicate {

    private FragmentLA fragmentLA ;
    private FragmentLB fragmentLd ;
    private FragmentManager manager ;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listner_movie);
        manager=getSupportFragmentManager();
        transaction = manager.beginTransaction();

        fragmentLA =(FragmentLA) manager.findFragmentById(R.id.fragmentla);
        fragmentLd = (FragmentLB) manager.findFragmentById(R.id.fragmentd);

        if ( findViewById(R.id.activity_mainL) == null ){

            transaction.show(fragmentLd).commit();
        }else {
            transaction.hide(fragmentLd).commit();
        }

        fragmentLA.setCom(this);
    }

    @Override
    public void respond(int i) {
        Log.e("respond","item "+i);
        if ( manager.findFragmentById(R.id.fragmentd) != null){
            fragmentLd.showdesc(i);
            Log.e("respond","fragmentb"+fragmentLd);
        }else {
            Intent in = new Intent(this,DetailMovie.class);

            in.putExtra("id",i);
            Log.e("respond","intent"+in);
            startActivity(in);
        }

    }
}
