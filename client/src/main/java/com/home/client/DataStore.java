package com.home.client;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static final List<Appliance> appliances = new ArrayList<>();

    static {
        appliances.add(new Appliance("Air Conditioner", 1500));
        appliances.add(new Appliance("Refrigerator", 200));
        appliances.add(new Appliance("Television", 100));
        appliances.add(new Appliance("Washing Machine", 800));
        appliances.add(new Appliance("Computer", 300));
        appliances.add(new Appliance("Heater", 1200));
        appliances.add(new Appliance("Microwave", 1000));
        appliances.add(new Appliance("Lights", 60));
    }

    public static List<Appliance> getAppliances() {
        return appliances;
    }
}
