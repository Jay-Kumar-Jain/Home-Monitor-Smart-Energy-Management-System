package com.home.client;

public class Appliance {
    private String name;
    private double powerRating; // Watts
    private boolean isOn;

    public Appliance(String name, double powerRating) {
        this.name = name;
        this.powerRating = powerRating;
        this.isOn = false;
    }

    public String getName() { return name; }
    public double getPowerRating() { return powerRating; }
    public boolean isOn() { return isOn; }
    public void setOn(boolean on) { isOn = on; }
}
