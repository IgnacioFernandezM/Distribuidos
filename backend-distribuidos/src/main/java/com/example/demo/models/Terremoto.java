package com.example.demo.models;

public class Terremoto {
    private double mag;
    private String place;
    private double prof;

    public Terremoto(double mag, String place, double prof) {
        this.mag = mag;
        this.place = place;
        this.prof = prof;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getProf() {
        return prof;
    }

    public void setProf(double prof) {
        this.prof = prof;
    }
}
