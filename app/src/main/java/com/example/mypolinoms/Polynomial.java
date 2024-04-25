package com.example.mypolinoms;

public class Polynomial {
    private int id;
    private int degree;
    private String coefficients;

    public Polynomial(int id, int degree, String coefficients) {
        this.id = id;
        this.degree = degree;
        this.coefficients = coefficients;
    }

    public int getId() {
        return id;
    }

    public int getDegree() {
        return degree;
    }
    public String getCoefficients(){
        return coefficients;
    }
}

