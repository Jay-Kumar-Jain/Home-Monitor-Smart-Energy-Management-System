package com.home.client;

import java.util.List;
import java.util.Random;

public class ApplianceService {
    private final Random random = new Random();

    public double totalPowerNow(List<Appliance> appliances) {
        return appliances.stream()
                .filter(Appliance::isOn)
                .mapToDouble(a -> a.getPowerRating() * (0.8 + 0.4 * random.nextDouble()))
                .sum();
    }

    public double predictMonthlyCost(List<Appliance> appliances, int hoursPerDay) {
        double totalPower = appliances.stream()
                .filter(Appliance::isOn)
                .mapToDouble(Appliance::getPowerRating)
                .sum();
        double kWh = (totalPower / 1000.0) * hoursPerDay * 30;
        double costPerKWh = 8.5;
        return kWh * costPerKWh;
    }
}
