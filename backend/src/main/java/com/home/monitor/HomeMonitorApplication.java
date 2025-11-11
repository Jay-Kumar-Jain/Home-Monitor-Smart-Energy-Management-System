package com.home.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomeMonitorApplication.class, args);
        System.out.println("✅ Home Monitor Backend is running on http://localhost:8080");
    }
}
