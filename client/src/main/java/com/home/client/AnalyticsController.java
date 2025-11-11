package com.home.client;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class AnalyticsController {

    @FXML private PieChart energyPieChart;
    @FXML private BarChart<String, Number> usageBarChart;

    @FXML
    public void initialize() {
        loadPieChart();
        loadBarChart();
    }

    private void loadPieChart() {
        energyPieChart.getData().add(new PieChart.Data("Air Conditioner", 35));
        energyPieChart.getData().add(new PieChart.Data("Heater", 25));
        energyPieChart.getData().add(new PieChart.Data("Refrigerator", 10));
        energyPieChart.getData().add(new PieChart.Data("TV & Computer", 15));
        energyPieChart.getData().add(new PieChart.Data("Others", 15));
    }

    private void loadBarChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Weekly Power Consumption (kWh)");
        series.getData().add(new XYChart.Data<>("Mon", 12));
        series.getData().add(new XYChart.Data<>("Tue", 15));
        series.getData().add(new XYChart.Data<>("Wed", 10));
        series.getData().add(new XYChart.Data<>("Thu", 18));
        series.getData().add(new XYChart.Data<>("Fri", 14));
        series.getData().add(new XYChart.Data<>("Sat", 20));
        series.getData().add(new XYChart.Data<>("Sun", 16));
        usageBarChart.getData().add(series);
    }
}
