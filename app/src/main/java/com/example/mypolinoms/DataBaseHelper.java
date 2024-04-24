package com.example.mypolinoms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    static final String DataBase_Name= "Functions";
    static final int version = 1;
    static final String DATABASE_TABLE = "Polynoms";
    static final String FUNC_NUM = "id";
    static final String DEG= "Deg";
    static final String COEFF= " Coefficients ";
    private static final String CREATE_DB_QUERY = " CREATE TABLE "+DATABASE_TABLE+"("+FUNC_NUM+"INTEGER PRIMARY KEY AUTOINCREMENT,"+ DEG+"INTEGER,"+ COEFF+"INTEGER"+");";
    public DataBaseHelper(Context context) {
        super(context, DataBase_Name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+DATABASE_TABLE);

    }
}
