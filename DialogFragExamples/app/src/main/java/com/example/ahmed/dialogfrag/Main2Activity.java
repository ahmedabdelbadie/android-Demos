package com.example.ahmed.dialogfrag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity {
    private final static String TAG = "dialog";
    private FragmentManager manager ;
    private FragmentDialog dialog ;
    private FragmentTransaction transaction ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        manager=getSupportFragmentManager();
        transaction = manager.beginTransaction();
        dialog = new FragmentDialog();


    }

    public void show(View view) {
        transaction.add(R.id.con,dialog,TAG).commit();

    }

    public void dismiss(View view) {
        dialog.dismiss();

    }
}
