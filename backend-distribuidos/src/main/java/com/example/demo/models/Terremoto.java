package com.example.demo.models;

public class Terremoto {
    private double mag;
    private String lugar;
    private double prof;

    public Terremoto(double mag, String lugar, double prof) {
        this.mag = mag;
        this.lugar = lugar;
        this.prof = prof;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getProf() {
        return prof;
    }

    public void setProf(double prof) {
        this.prof = prof;
    }
}
