package com.home.monitor.service;

import com.home.monitor.model.Appliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalyticsService {

    @Autowired
    private ApplianceService applianceService;

    public Map<String, Object> getAnalyticsSummary() {
        Map<String, Object> data = new HashMap<>();

        List<Appliance> appliances = applianceService.getAllAppliances();
        double totalPower = applianceService.getTotalPower();
        double totalEnergy = applianceService.getTotalEnergy();
        double totalCost = applianceService.getTotalCost();

        data.put("totalPower", totalPower);
        data.put("totalEnergy", totalEnergy);
        data.put("totalCost", totalCost);
        data.put("deviceCount", appliances.size());
        data.put("timestamp", new Date().toString());

        List<Map<String, Object>> devices = new ArrayList<>();
        for (Appliance a : appliances) {
            Map<String, Object> d = new HashMap<>();
            d.put("name", a.getName());
            d.put("status", a.getStatus());
            d.put("power", a.getPower());
            d.put("energy", a.getEnergy());
            d.put("cost", a.getCost());
            devices.add(d);
        }

        data.put("devices", devices);
        return data;
    }
}
