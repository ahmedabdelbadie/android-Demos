package com.example.ahmed.storageapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    TextView user ,pass ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.email);
        pass = findViewById(R.id.password);
    }

    public void saveShared(View view) {
        SharedPreferences sharedPreferences = this.getSharedPreferences("save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user",user.getText().toString()).putString("pass",pass.getText().toString()).commit();
        Toast.makeText(this," Save in Shared Is Fine " ,Toast.LENGTH_SHORT).show();
    }

    public void nextActivity(View view) {
        startActivity(new Intent(this,LoadActivity.class));
    }

    public void saveFile(View view) throws IOException {
        FileOutputStream fileOutputStream = null;
        File file = null ;
        try {
            file = getFilesDir();
            String text = user.getText().toString() + " " + pass.getText().toString() ;
            fileOutputStream = openFileOutput("ahmed.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileOutputStream.close();
        }
        Toast.makeText(this," Save in File Is Fine In "+file+ " Here" ,Toast.LENGTH_SHORT).show();

    }
}


