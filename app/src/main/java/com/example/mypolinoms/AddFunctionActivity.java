package com.example.mypolinoms;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLDataException;
import java.util.Scanner;


public class AddFunctionActivity extends AppCompatActivity {
    EditText Degree;
    Button submit;
    EditText CoeffEditT;
    String FinalCoeff;
    Integer FinalDegree;
    DataBaseManager db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_function);
        final EditText Degree = (EditText) findViewById(R.id.deget);
        submit = (Button) findViewById(R.id.SubmitPolynom);
        final EditText CoeffEditT = (EditText) findViewById(R.id.coeff);
        db = new DataBaseManager(this);
        try {
            db.open();
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        Cursor cursor=db.fetch();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer Fdeg = new Integer(Degree.getText().toString());
                Integer[] coefficients = new Integer[Fdeg];
                String coeff = CoeffEditT.getText().toString();
                if (coeff.isEmpty()&&coeff!=null || Fdeg.equals(0)&&Fdeg!=null) {
                    Toast.makeText(AddFunctionActivity.this, "invalid input", Toast.LENGTH_SHORT).show();
                }
                FinalCoeff = coeff;
                FinalDegree = Fdeg;

                db.insert(FinalDegree, FinalCoeff);
                Toast.makeText(AddFunctionActivity.this, "Polynom has been added", Toast.LENGTH_SHORT).show();
                //db.close();

            }
        });


    }

    /**public void submit(View view){
     Integer Fdeg= new Integer(Degree.getText().toString());
     Integer[] coefficients=new Integer[Fdeg];
     String coeff=CoeffEditT.getText().toString();
     if(coeff.isEmpty()||Fdeg.equals(0)){
     Toast.makeText(AddFunctionActivity.this,"invalid input",Toast.LENGTH_SHORT).show();
     }
     FinalCoeff=coeff;
     FinalDegree=Fdeg;
     dbHelper.add_polynom(FinalDegree,FinalCoeff);
     Toast.makeText(AddFunctionActivity.this,"Polynom has been added",Toast.LENGTH_SHORT).show();
     }**/
}