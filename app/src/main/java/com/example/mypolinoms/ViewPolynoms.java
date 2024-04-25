package com.example.mypolinoms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.sql.SQLDataException;
import java.util.List;

public class ViewPolynoms extends AppCompatActivity {
    ListView listView;
    private PolynomialAdapter adapter;
    private DataBaseManager dbManager;
    public class PolynomialListActivity extends AppCompatActivity {
        private ListView listView;
        private PolynomialAdapter adapter;
        private DataBaseManager dbManager;
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_polynoms);
        listView = (ListView)findViewById(R.id.listview);
        dbManager = new DataBaseManager(this);
        try {
            dbManager.open();
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        List<Polynomial> polynomials = dbManager.getAllPolynomials();
        adapter = new PolynomialAdapter(this, polynomials);
        listView.setAdapter(adapter);

    }
    @Override
    protected void onDestroy() {
        dbManager.close();
        super.onDestroy();
    }


}