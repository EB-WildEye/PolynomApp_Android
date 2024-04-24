package com.example.mypolinoms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;

public class DataBaseManager {
    private  DataBaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;
    public DataBaseManager(Context ctx){
        context=ctx;
    }
    public DataBaseManager open() throws SQLDataException {
        dbHelper = new DataBaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }
    public void insert(Integer Degree, Integer Coefficient){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.DEG, Degree);
        contentValues.put(DataBaseHelper.COEFF, Coefficient);
        database.insert(DataBaseHelper.DATABASE_TABLE, null, contentValues);
    }
    public Cursor fetch(){
        String[] columns = new String[] {DataBaseHelper.FUNC_NUM,DataBaseHelper.DEG,DataBaseHelper.COEFF};
        Cursor cursor = database.query(DataBaseHelper.DATABASE_TABLE , columns ,null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public int update(Integer id,Integer Deg,Integer Coefficients){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.DEG,Deg);
        contentValues.put(DataBaseHelper.COEFF, Coefficients);
        int ret = database.update(DataBaseHelper.DATABASE_TABLE,contentValues,DataBaseHelper.FUNC_NUM+"="+ id,null);
        return ret;
    }

}
