package com.example.kuliah.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kuliah.Model.ModelUser;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="USER";
    private static final String TABLE_LOGIN ="tbl_login";
    private static final String KEY_ID = "id";
    private static final String USERNAME ="username";
    private static final String PASSWORD ="PASSWORD";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase SQLiteDatabase){
        String createDB = "CREATE TABLE "+TABLE_LOGIN+"("+KEY_ID+" INTEGER PRIMARY KEY,"+USERNAME+" TEXT,"+PASSWORD+" TEXT)";
        SQLiteDatabase.execSQL(createDB);
    }
    public void SaveLogin(ModelUser USER){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERNAME,USER.getUsername());
        cv.put(PASSWORD,USER.getPassword());
        db.insert(TABLE_LOGIN, null,cv);
        db.close();
    }

    public ModelUser SearchQuery(ModelUser USER){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from "+TABLE_LOGIN+"where"+USERNAME+"="+USER.getUsername()+" and"+PASSWORD+"="+USER.getPassword(), null);
        ModelUser MU =  new ModelUser();
        if (cursor.moveToFirst()){
            do {
                MU.setUsername(cursor.getString(1));
                MU.setPassword(cursor.getString(2));
            }
            while (cursor.moveToFirst());

        }
        cursor.close();
        db.close();
        return MU;
    }
    public void onUpgrade(SQLiteDatabase SQLiteDatabase,int i,int i1){

    }

}
