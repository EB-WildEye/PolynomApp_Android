package com.example.mypolinoms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Scanner;


public class AddFunctionActivity extends AppCompatActivity {
    EditText Degree;
    Button SetD;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("ADFadAFa");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_function);
        Degree = (EditText)findViewById(R.id.deget);
        SetD = (Button)findViewById(R.id.SubmitB);
        submit = (Button)findViewById(R.id.SubmitPolynom);


    }
    public void setFdeg(View view){
        Integer Fdeg= new Integer(Degree.getText().toString());


    }
    public void submit(View view){

    }

}