package com.example.ahmed.storageapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;


public class LoginSQL extends AppCompatActivity  {
    private TextView pass,user;
    SqlDBAdapter sqlDBAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sql);
        pass=findViewById(R.id.passwordsql);
        user=findViewById(R.id.emailsql);
        sqlDBAdapter = new SqlDBAdapter(this);

        }

    public void addSQL(View view) {
        /*long id = sqlDBAdapter.insertData(user.getText().toString(),pass.getText().toString());
        if (id<0){
            Toast.makeText(this," Can't Insert Values "+id,Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this," Data Insert Successfully "+id,Toast.LENGTH_LONG).show();
        }*/
        int data = sqlDBAdapter.deleteData("momomo");
        Toast.makeText(this," number of row "+Integer.toString(data),Toast.LENGTH_LONG).show();
    }

    public void showData(View view) {
        Toast.makeText(this,sqlDBAdapter.getALLData().toString(),Toast.LENGTH_LONG).show();
    }
}

