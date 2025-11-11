#🏠 Home Monitor — Smart Energy Management System
📘 Overview

Home Monitor is a full-stack IoT-based Smart Energy Management System designed to monitor, control, and optimize the energy consumption of household appliances in real-time.

The system consists of:

IoT Hardware (ESP32 / ESP8266) – Collects real-time power usage.

Spring Boot Backend – Processes, stores, and exposes REST APIs.

JavaFX Frontend (Client) – Visual dashboard for analytics, automation, and control.

🎯 Objectives

Monitor energy consumption of each connected device.

Predict monthly cost and show detailed usage analytics.

Automate devices using smart rules (e.g., turn off AC when power > 2000W).

Control appliances remotely via dashboard.

Encourage energy-efficient habits and reduce electricity bills.

🧩 System Architecture
[ESP32 / IoT Device]
↓ (Wi-Fi HTTP)
[Spring Boot Backend API]
↓ (REST JSON)
[JavaFX Client Application]

The ESP32 continuously measures appliance power and sends data to the backend via HTTP POST requests.

The Spring Boot backend stores, analyzes, and responds with updated energy statistics.

The JavaFX client fetches data from the backend to display real-time analytics and device control options.

⚙️ Features

✅ Live Monitoring — View current power, energy, and cost for each device.
✅ Data Visualization — Interactive charts showing daily, weekly, and monthly usage.
✅ Smart Automation — Set conditions like “Turn off AC if usage exceeds 2000W.”
✅ Cost Prediction — Forecast electricity bills based on past consumption.
✅ Device Control — Turn ON/OFF appliances from your dashboard.
✅ Real-Time Updates — Data refreshed every few seconds from backend.
✅ Dark / Light Theme Support — Choose your preferred dashboard look.

🧰 Technologies Used
Layer Technology
Frontend (Client) JavaFX, FXML, CSS, Charts
Backend Spring Boot (Java), REST APIs
Database (Optional) In-memory or JSON DataStore
Hardware ESP32 / ESP8266 / Raspberry Pi
Communication HTTP REST (JSON over Wi-Fi)
Build Tools Maven
IDE IntelliJ IDEA / Eclipse / VS Code / Arduino IDE
🖥️ Folder Structure
home-monitor/
├── backend/
│ ├── src/main/java/com/home/monitor/
│ │ ├── controller/
│ │ │ ├── ApplianceController.java
│ │ │ └── HomeController.java
│ │ ├── model/
│ │ │ └── Appliance.java
│ │ ├── service/
│ │ │ ├── ApplianceService.java
│ │ │ └── AnalyticsService.java
│ │ └── HomeMonitorApplication.java
│ ├── src/main/resources/application.properties
│ └── pom.xml
│
├── client/
│ ├── src/main/java/com/home/client/
│ │ ├── HomeClientApp.java
│ │ ├── controllers/
│ │ │ ├── DashboardController.java
│ │ │ ├── AnalyticsController.java
│ │ │ └── AutomationController.java
│ │ ├── models/
│ │ │ └── Appliance.java
│ │ ├── services/
│ │ │ ├── DataStore.java
│ │ │ └── ApplianceService.java
│ ├── src/main/resources/ui/
│ │ ├── dashboard.fxml
│ │ ├── analytics.fxml
│ │ ├── automation.fxml
│ │ └── style.css
│ └── pom.xml
│
└── README.md

🪄 Installation & Setup
🧱 1️⃣ Prerequisites

JDK 21 or later

Maven

Arduino IDE (optional, for ESP32)

Wi-Fi connection

⚙️ 2️⃣ Running the Backend
cd backend
mvn spring-boot:run

🟢 The backend starts on http://localhost:8080/

You can test it in your browser:
👉 http://localhost:8080/

Expected Output:

🏠 Home Monitor Backend is Running!
Available endpoints:

- /api/appliances
- /api/appliances/analytics
- /api/appliances/update

💻 3️⃣ Running the Client (JavaFX)
cd client
mvn clean javafx:run

The dashboard window will open showing:

Device list

Power, energy, and cost

Analytics graphs

Automation control panel

🔌 4️⃣ Connecting ESP32 Hardware (Optional)
Example Arduino Code
#include <WiFi.h>
#include <HTTPClient.h>

const char* ssid = "Your_WiFi_Name";
const char* password = "Your_WiFi_Password";
String serverName = "http://192.168.1.5:8080/api/appliances/update"; // your backend IP

void setup() {
Serial.begin(115200);
WiFi.begin(ssid, password);
while (WiFi.status() != WL_CONNECTED) { delay(500); Serial.print("."); }
Serial.println("\nConnected!");
}

void loop() {
if (WiFi.status() == WL_CONNECTED) {
HTTPClient http;
http.begin(serverName);
http.addHeader("Content-Type", "application/json");
String json = "{\"id\":\"1\",\"name\":\"Fan\",\"status\":\"ON\",\"power\":42.5,\"energy\":0.008}";
http.POST(json);
http.end();
}
delay(5000);
}

✅ ESP32 connects to your Wi-Fi
✅ Sends power usage JSON to backend every 5 seconds
✅ Backend updates data → Dashboard refreshes automatically

📊 Analytics Examples
Appliance Status Power (W) Energy (kWh) Cost (₹)
Fan ON 45.3 0.01 0.065
AC OFF 0 1.2 7.8
Light ON 10 0.5 3.25

Total Energy: 1.71 kWh
Predicted Monthly Cost: ₹340

🧠 Automation Rules Examples

“Turn off AC when total power > 2000W.”

“Turn off lights automatically after 11:00 PM.”

“Send alert when daily cost exceeds ₹100.”

🧩 Future Enhancements

🚀 Add AI-based cost prediction
🚀 Enable cloud connectivity (Firebase / AWS IoT)
🚀 Mobile app integration (Flutter / Android)
🚀 Voice assistant support (Alexa / Google Assistant)
🚀 Machine learning for energy optimization

🧪 Testing

All APIs tested via Postman.

Frontend UI tested with sample JSON data.

ESP32 simulated via Arduino serial monitor.

🧰 Troubleshooting
Issue Cause Solution
Whitelabel Error Page Missing HomeController Add /controller/HomeController.java
Cannot find Gson Missing dependency Add Gson to pom.xml
Blank JavaFX screen Missing sample data Backend must be running first
ESP32 not connecting Wrong IP address Replace localhost with your PC’s IP
🧾 License

This project is open-source and free to use for educational purposes.

👨‍💻 Author

Developed by: Jay
Role: Programmer / Data Science Student
Project Type: IoT + Java + Energy Analytics
