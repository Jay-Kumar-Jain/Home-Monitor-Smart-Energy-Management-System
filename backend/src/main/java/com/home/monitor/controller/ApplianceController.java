package com.home.monitor.controller;

import com.home.monitor.model.Appliance;
import com.home.monitor.service.ApplianceService;
import com.home.monitor.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appliances")
@CrossOrigin(origins = "*")
public class ApplianceController {

    @Autowired
    private ApplianceService applianceService;

    @Autowired
    private AnalyticsService analyticsService;

    // POST: Receive data from ESP32/ESP8266 or client app
    @PostMapping("/update")
    public String updateDevice(@RequestBody Appliance appliance) {
        applianceService.updateAppliance(appliance);
        return "✅ Device data received successfully for " + appliance.getName();
    }

    // GET: All appliances for dashboard
    @GetMapping
    public List<Appliance> getAll() {
        return applianceService.getAllAppliances();
    }

    // POST: Toggle appliance ON/OFF
    @PostMapping("/toggle/{name}")
    public String toggleAppliance(@PathVariable String name) {
        return applianceService.toggleAppliance(name);
    }

    // GET: Summary analytics
    @GetMapping("/analytics")
    public Map<String, Object> getAnalytics() {
        return analyticsService.getAnalyticsSummary();
    }
}
