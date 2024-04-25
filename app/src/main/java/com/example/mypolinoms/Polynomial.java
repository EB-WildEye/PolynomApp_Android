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

    public Polynomial() {

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

    public void setCoefficients(String coefficients) {
        this.coefficients = coefficients;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setId(int id) {
        this.id = id;
    }
}

