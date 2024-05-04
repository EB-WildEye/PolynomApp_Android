package com.example.mypolinoms;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

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
    public void insert(Integer Degree, String Coefficient){
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
    public void delete(int id){
        database.delete(DataBaseHelper.DATABASE_TABLE,DataBaseHelper.FUNC_NUM+"="+id,null);
    }
    public List<Polynomial> getAllPolynomials() {

            List<Polynomial> polynomials = new ArrayList<>();
            // Select All Query
            String selectQuery = "SELECT * FROM " + DataBaseHelper.DATABASE_TABLE;
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            while(cursor.moveToNext()){
                Polynomial polynomial = new Polynomial(cursor.getInt(0),cursor.getInt(1),cursor.getString(2));
                //polynomial.setId(cursor.getInt(0));
                //polynomial.setDegree(cursor.getInt(1));
                //polynomial.setCoefficients(cursor.getString(2));
                polynomials.add(polynomial);
            }
            return polynomials;
        }

}
