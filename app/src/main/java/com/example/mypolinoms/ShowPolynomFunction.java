package com.example.mypolinoms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLDataException;
import java.util.List;

public class ShowPolynomFunction extends AppCompatActivity {
    private Button show;
    private TextView polynomTV;
    private EditText id;
    private DataBaseManager dbManager;
    private DataBaseHelper dbHelper;
    private Polynomial polynom;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_polynom_function);
        dbManager = new DataBaseManager(this);
        dbHelper = new DataBaseHelper(this);
        show = (Button)findViewById(R.id.showBTN);
        id = (EditText)findViewById(R.id.insertID);
        polynomTV = (TextView)findViewById(R.id.showFinalPoly);

        try {
            dbManager.open();
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }

        List<Polynomial> polynomials = dbManager.getAllPolynomials();
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idShow = Integer.parseInt(id.getText().toString());
                String selectQuery = "SELECT * FROM " + DataBaseHelper.DATABASE_TABLE;
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery(selectQuery, null);
                while(cursor.moveToNext()) {
                    Polynomial polynomial = new Polynomial();
                    polynomial.setId(cursor.getInt(0));
                    polynomial.setDegree(cursor.getInt(1));
                    polynomial.setCoefficients(cursor.getString(2));
                    if(Polynomial.getId() == idShow) {
                        polynomTV.setText(polynomial.toString());
                        break;
                    }
                }
            }
        });


    }
}