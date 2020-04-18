package com.example.ahmed.storageapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

/**
 * Created by Ahmed on 12/20/2017.
 */

public class SqlDBAdapter {

    SqlHelper sqlHelper ;

    public SqlDBAdapter(Context context) {
        sqlHelper = new SqlHelper(context);
    }

    public long insertData(String name,String pass){
        SQLiteDatabase sqLiteDatabase = sqlHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(sqlHelper.UNAME,name);
        contentValues.put(sqlHelper.UPASS,pass);
        long id = sqLiteDatabase.insert(sqlHelper.TABLE_NAME,null,contentValues);
        return id;
    }
    public String getALLData(){
        SQLiteDatabase sqLiteDatabase = sqlHelper.getWritableDatabase();
        String[] colums = {sqlHelper.UID,sqlHelper.UNAME,SqlHelper.UPASS};
        Cursor cursor = sqLiteDatabase.query(sqlHelper.TABLE_NAME,colums,null,null,null,null,null,null);
        StringBuilder builder = new StringBuilder();
        while (cursor.moveToNext()){
            /*int index = cursor.getColumnIndex(sqlHelper.UID);*/
            int gid = cursor.getInt(0);
            String gname = cursor.getString(1);
            String gpass = cursor.getString(2);
            builder.append(gid+" "+gname+" "+gpass+"/n");
        }
        cursor.close();
        return builder.toString();
    }
    public int deleteData(String name){
        SQLiteDatabase sqLiteDatabase = sqlHelper.getWritableDatabase();
        String[] arg = {name};
        int num=sqLiteDatabase.delete(sqlHelper.TABLE_NAME,sqlHelper.UNAME+"=?",arg);
        return num ;
    }
    public int updateData(String oldName , String newName){
        SQLiteDatabase sqLiteDatabase = sqlHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(sqlHelper.UNAME,newName);
        String[] arg = {oldName};
        int num=sqLiteDatabase.update(sqlHelper.TABLE_NAME,cv,sqlHelper.UNAME+" =? ",arg);
        return num;
    }
    public String getData(String name,String pass){
        SQLiteDatabase sqLiteDatabase = sqlHelper.getWritableDatabase();
        String[] colums = {sqlHelper.UID};
        String[] selectionarg = {name,pass};
        Cursor cursor = sqLiteDatabase.query(sqlHelper.TABLE_NAME,colums,sqlHelper.UNAME+"=? AND "+sqlHelper.UPASS+"=?",selectionarg,null,null,null);
        StringBuilder builder = new StringBuilder();
        while (cursor.moveToNext()){
            int index = cursor.getColumnIndex(sqlHelper.UID);
            int id = cursor.getInt(index);
            builder.append(id+"   ");
        }
        return  builder.toString();
    }
     static class SqlHelper extends SQLiteOpenHelper  {
        private Context context ;
        private static final String DB_NAME = "lOGINDB";
        private static final String TABLE_NAME = "lOGINTABLE";
        private static final int DB_VERSION = 2 ;
        private static final String UID = "_id" ;
        private static final String UNAME = "name" ;
        private static final String UPASS = "pass" ;
        /*,"+UPASS+"VARCHAR(255)*/
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+UNAME+" VARCHAR(255),"+UPASS+" VARCHAR(255));";
        private static final String Drop_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
        private static final String TAG = "SQL";


        public SqlHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            this.context=context ;
            Toast.makeText(context," Constructor Created ",Toast.LENGTH_LONG).show();
            Log.e(TAG," Constructor Created ");

        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                Toast.makeText(context," On create is called ",Toast.LENGTH_LONG).show();
                Log.e(TAG," On create is called ");
                sqLiteDatabase.execSQL(CREATE_TABLE);
            }catch (SQLException e){
                Toast.makeText(context,e.toString(),Toast.LENGTH_LONG).show();
                Log.e(TAG,e.toString());
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            try {
                Toast.makeText(context," On upgrade is called ",Toast.LENGTH_LONG).show();
                sqLiteDatabase.execSQL(Drop_TABLE);
                onCreate(sqLiteDatabase);
                Log.e(TAG," On upgrade is called ");
            }catch (SQLException e){
                Toast.makeText(context,e.toString(),Toast.LENGTH_LONG).show();
                Log.e(TAG,e.toString());
            }
        }
    }
}
