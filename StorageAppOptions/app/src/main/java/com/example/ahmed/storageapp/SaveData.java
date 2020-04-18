package com.example.ahmed.storageapp;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveData extends AppCompatActivity {
    EditText text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);
        text = findViewById(R.id.editText);
    }

    public void saveInternalCache(View view) {
        File file = getCacheDir() ;
        File myfile = new File(file,"mydata1");
        writeData(myfile);
    }

    public void writeData(File file){
        FileOutputStream fileOutputStream = null ;
        try {
            fileOutputStream =new FileOutputStream(file);
            fileOutputStream.write(text.getText().toString().getBytes());
            message(text.getText().toString()+" was Written Succes in Path "+file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveExternalCache(View view) {
        File file = getExternalCacheDir() ;
        File myfile = new File(file,"mydata2");
        writeData(myfile);
    }

    public void saveExPrivate(View view) {
        File file = getExternalFilesDir("ahmed") ;
        File myfile = new File(file,"mydata3");
        writeData(myfile);
    }

    public void saveExPuplic(View view) throws IOException {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS);
        File myfile = new File(file,"mydata4");
        writeData(myfile);
    }

    public void nextA(View view) {
        startActivity(new Intent(this,LoadData.class));
    }
    public void message(String m){
        Toast.makeText(this,m,Toast.LENGTH_SHORT).show();
    }

}
