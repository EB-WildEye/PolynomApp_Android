package com.example.mypolinoms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.sql.SQLDataException;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void addFuncactivity(View view){
        Intent intent=new Intent(this,AddFunctionActivity.class);
        startActivity(intent);
    }
    public void ViewPolynoms(View view){
        Intent intent=new Intent(this,ViewPolynoms.class);
        startActivity(intent);
    }
    public void DeletePolynom(View view){
        Intent intent=new Intent(this,DeletePolynom.class);
        startActivity(intent);
    }

    public void ShowPolynomFunction(View view){
        Intent intent=new Intent(this,ShowPolynomFunction.class);
        startActivity(intent);
    }
}