package com.example.mypolinoms;

import androidx.annotation.NonNull;

public class Polynomial {
    private int id;
    private int degree;
    private String coefficients;

    public Polynomial(int id, int degree, String coefficients) {
        this.id = id;
        this.degree = degree;
        this.coefficients = coefficients;
    }

    public Polynomial() {

    }

    public int getId() {
        return this.id;
    }

    public int getDegree() {
        return degree;
    }

    public String getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(String coefficients) {
        this.coefficients = coefficients;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String toString() {
        StringBuilder poly = new StringBuilder("F(x) = ");
        String[] coeff = coefficients.split(",");
        boolean first = true; // flag for the first term

        for (int i = degree; i >= 0; i--) {
            int coefficient = Integer.parseInt(coeff[i]);

            if (coefficient == 0) continue;

            String sign = " + ";
            if (coefficient < 0) {
                sign = " - ";
                coefficient = -coefficient;
            }

            if (first) {
                sign = (coefficient < 0) ? "- " : "";
                first = false;
            }


            if (i == 0) {
                poly.append(sign).append(coefficient);
            } else if (i == 1) {
                poly.append(sign).append(coefficient != 1 ? coefficient : "").append("x");
            } else {
                poly.append(sign).append(coefficient != 1 ? coefficient : "").append("x^").append(i);
            }
        }

        if (poly.toString().equals("F(x) = ")) { // If all coefficients were zero
            poly.append("0");
        }

        return poly.toString();
    }

}

