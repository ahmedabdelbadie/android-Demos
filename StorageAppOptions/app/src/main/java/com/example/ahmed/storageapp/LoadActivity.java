package com.example.ahmed.storageapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoadActivity extends AppCompatActivity {

    TextView userL , passL ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        // Set up the login form.
        userL = findViewById(R.id.emaill);
        passL = findViewById(R.id.passwordl);

    }

    public void loadShared(View view) {
        SharedPreferences sharedPreferences = this.getSharedPreferences("save", Context.MODE_PRIVATE);
        userL.setText(sharedPreferences.getString("user","ahmed").toString());
        passL.setText(sharedPreferences.getString("pass","123456").toString());
    }

    public void loadfile(View view) {
        try {
            FileInputStream fileInputStream = openFileInput("ahmed.txt");
            int read = -1 ;
            StringBuilder builder = new StringBuilder();

            while ((read=fileInputStream.read()) != -1){
                builder.append((char) read);
            }
            Toast.makeText(this,builder.toString(),Toast.LENGTH_LONG).show();
            String text1 =builder.substring(0,builder.indexOf(" ")).toString();
            String text2 =builder.substring(builder.indexOf(" ")+1).toString();
            userL.setText(text1);
            passL.setText(text2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

