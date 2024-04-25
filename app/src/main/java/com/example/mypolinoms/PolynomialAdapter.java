package com.example.mypolinoms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PolynomialAdapter extends ArrayAdapter<Polynomial> {

    public PolynomialAdapter(Context context, List<Polynomial> polynomials) {
        super(context, 0, polynomials);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_polynomial, parent, false);
        }

        // Lookup view for data population
        TextView tvId = convertView.findViewById(R.id.tvId);
        TextView tvDegree = convertView.findViewById(R.id.tvDegree);
        TextView tvCoefficients = convertView.findViewById(R.id.tvCoefficients);

        // Get the data item for this position
        Polynomial polynomial = getItem(position);

        // Populate the data into the template view using the data object
        tvId.setText(String.valueOf(polynomial.getId()));
        tvDegree.setText(String.valueOf(polynomial.getDegree()));
        tvCoefficients.setText(polynomial.getCoefficients());

        // Return the completed view to render on screen
        return convertView;
    }
}