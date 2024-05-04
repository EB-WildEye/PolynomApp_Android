package com.example.mypolinoms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLDataException;

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
        Degree = (EditText) findViewById(R.id.deget);
        submit = (Button) findViewById(R.id.SubmitPolynom);
        CoeffEditT = (EditText) findViewById(R.id.coeff);
        db = new DataBaseManager(this);
        try {
            db.open();
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String degreeStr = Degree.getText().toString();
                String coeffStr = CoeffEditT.getText().toString();

                // Validate inputs
                if (degreeStr.isEmpty() || coeffStr.isEmpty()) {
                    Toast.makeText(AddFunctionActivity.this, "Invalid input: fields cannot be empty.", Toast.LENGTH_SHORT).show();
                    goToMainActivity();
                    return;
                }


                try {
                    FinalDegree = Integer.parseInt(degreeStr);
                    String[] arr = coeffStr.split(",");
                    if (FinalDegree < 0 || FinalDegree != arr.length-1) {
                        throw new NumberFormatException("Invalid Degree or Coefficients input");
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(AddFunctionActivity.this, "Invalid Degree or Coefficients input", Toast.LENGTH_SHORT).show();
                    goToMainActivity();
                    return;
                }

                FinalCoeff = coeffStr;
                db.insert(FinalDegree, FinalCoeff);
                Toast.makeText(AddFunctionActivity.this, "Polynom has been added.", Toast.LENGTH_SHORT).show();
                db.close();
                goToMainActivity();
            }
        });
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // This flag will close all activities below the main in the stack
        startActivity(intent);
    }
}
