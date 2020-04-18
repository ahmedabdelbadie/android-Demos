package com.example.ahmed.dialogfrag;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = ".MainActivity";
    private FragmentManager manager ;
    private FragmentDialog dialog;
    private SimpleAlert simpleAlert ;
    private SimpleItemAlert simpleItemAlert ;
    private ItemCheckedDialog itemCheckedDialog ;
    private CustomMessage customMessage ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();


    }

    public void simpleDialog(View view) {
        simpleAlert = new SimpleAlert();
        simpleAlert.show(manager,TAG);
    }

    public void itemDialog(View view) {
        simpleItemAlert = new SimpleItemAlert();
        simpleItemAlert.show(manager,TAG);

    }

    public void itemCheckDialog(View view) {
        itemCheckedDialog = new ItemCheckedDialog();
        itemCheckedDialog.show(manager,TAG);
    }

    public void customMessageDialog(View view) {
        customMessage=new CustomMessage();
        customMessage.show(manager,TAG);
    }

    public void customDialog(View view) {
        dialog = new FragmentDialog();
        dialog.show(manager,TAG);

    }

    public void customInDialog(View view) {
        startActivity(new Intent(this,Main2Activity.class));
    }

    public void listFrag(View view) {
        startActivity(new Intent(this,ListActivity.class));
    }
}
