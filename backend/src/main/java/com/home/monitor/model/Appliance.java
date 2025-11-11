package com.home.monitor.model;

public class Appliance {
    private String id;
    private String name;
    private String status;
    private double power;   // Instant power (W)
    private double energy;  // Total energy (kWh)
    private double cost;    // Calculated cost (₹)

    public Appliance() {}

    public Appliance(String id, String name, String status, double power, double energy) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.power = power;
        this.energy = energy;
        this.cost = 0.0;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getPower() { return power; }
    public void setPower(double power) { this.power = power; }

    public double getEnergy() { return energy; }
    public void setEnergy(double energy) { this.energy = energy; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}
