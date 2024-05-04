package com.example.mypolinoms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLDataException;

public class DeletePolynom extends AppCompatActivity {
    Button delete;
    EditText id;
    DataBaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_polynom);
        delete = (Button)findViewById(R.id.deleteBTN);
        id = (EditText)findViewById(R.id.tvId);
        db = new DataBaseManager(this);
        try {
            db.open();
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idDelete=Integer.parseInt(id.getText().toString());
                db.delete(idDelete);
                Toast.makeText(DeletePolynom.this, "Polynom has been DELETED", Toast.LENGTH_SHORT).show();
            }
        });
    }
}