package com.home.monitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
            <html>
                <head>
                    <title>Home Monitor Backend</title>
                </head>
                <body style="font-family: Arial; background-color: #f7f7f7; padding: 20px;">
                    <h2>🏠 Home Monitor Backend is Running!</h2>
                    <p>Welcome to the backend API for the Smart Home Energy Monitor.</p>
                    <hr>
                    <p>Available endpoints:</p>
                    <ul>
                        <li><a href='/api/appliances'>/api/appliances</a> — List all appliances</li>
                        <li><a href='/api/appliances/analytics'>/api/appliances/analytics</a> — Analytics summary</li>
                        <li><a href='/api/appliances/update'>/api/appliances/update</a> — POST device updates</li>
                    </ul>
                    <p>Use Postman or ESP32 to send JSON updates here.</p>
                </body>
            </html>
        """;
    }
}
