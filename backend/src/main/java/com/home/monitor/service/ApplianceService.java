package com.home.monitor.service;

import com.home.monitor.model.Appliance;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.LocalDateTime;

@Service
public class ApplianceService {

    private final Map<String, Appliance> appliances = new HashMap<>();
    private static final double RATE_PER_KWH = 6.5; // ₹6.5 per kWh (India standard)

    public void updateAppliance(Appliance appliance) {
        // If appliance exists, update data; otherwise add new one
        Appliance existing = appliances.get(appliance.getName());
        if (existing != null) {
            existing.setStatus(appliance.getStatus());
            existing.setPower(appliance.getPower());
            existing.setEnergy(existing.getEnergy() + (appliance.getPower() / 1000.0 / 3600.0)); // Convert W to kWh per sec
            existing.setCost(existing.getEnergy() * RATE_PER_KWH);
        } else {
            appliance.setCost(appliance.getEnergy() * RATE_PER_KWH);
            appliances.put(appliance.getName(), appliance);
        }

        System.out.println(LocalDateTime.now() + " ✅ Updated: " + appliance.getName() +
                " | Power: " + appliance.getPower() + "W | Status: " + appliance.getStatus());
    }

    public List<Appliance> getAllAppliances() {
        return new ArrayList<>(appliances.values());
    }

    public String toggleAppliance(String name) {
        Appliance a = appliances.get(name);
        if (a != null) {
            String newStatus = a.getStatus().equalsIgnoreCase("ON") ? "OFF" : "ON";
            a.setStatus(newStatus);
            System.out.println("🔁 Toggled " + name + " → " + newStatus);
            return "Appliance " + name + " is now " + newStatus;
        }
        return "❌ Appliance not found!";
    }

    public double getTotalCost() {
        return appliances.values().stream().mapToDouble(Appliance::getCost).sum();
    }

    public double getTotalPower() {
        return appliances.values().stream().mapToDouble(Appliance::getPower).sum();
    }

    public double getTotalEnergy() {
        return appliances.values().stream().mapToDouble(Appliance::getEnergy).sum();
    }
}
