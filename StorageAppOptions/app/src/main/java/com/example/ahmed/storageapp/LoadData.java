package com.example.ahmed.storageapp;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadData extends AppCompatActivity {
    TextView textd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);
        textd = findViewById(R.id.textView);
    }

    public void loadInternalCache(View view) {
        File folder = getCacheDir() ;
        File myfile = new File(folder,"mydata1");
        String data = readData(myfile);
        if (data == null){
            textd.setText("No Data Found Here ");
        }else {
            textd.setText(data);
        }

    }
    public String readData(File file){
        FileInputStream fileInputStream = null ;
        try {
            fileInputStream = new FileInputStream(file);
            int read = -1 ;
            StringBuilder builder = new StringBuilder();

            while ((read=fileInputStream.read()) != -1){
                builder.append((char) read);
            }
            Toast.makeText(this,builder.toString(),Toast.LENGTH_LONG).show();
            return builder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void loadExternalCache(View view) {
        File folder = getExternalCacheDir() ;
        File myfile = new File(folder,"mydata2");
        String data = readData(myfile);
        if (data == null){
            textd.setText("No Data Found Here ");
        }else {
            textd.setText(data);
        }
    }

    public void loadExPrivate(View view) {
        File folder = getExternalFilesDir("ahmed") ;
        File myfile = new File(folder,"mydata3");
        String data = readData(myfile);
        if (data == null){
            textd.setText("No Data Found Here ");
        }else {
            textd.setText(data);
        }
    }

    public void loadExPuplic(View view) {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS);
        File myfile = new File(file,"mydata4");
        String data = readData(myfile);
        if (data == null){
            textd.setText("No Data Found Here ");
        }else {
            textd.setText(data);
        }
    }

    public void backA(View view) {
        startActivity(new Intent(this,SaveData.class));
    }
}
