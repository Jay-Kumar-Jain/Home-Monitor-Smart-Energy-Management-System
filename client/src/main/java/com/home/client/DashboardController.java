package com.home.client;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.util.Duration;
import java.util.List;

public class DashboardController {

    @FXML private FlowPane appliancePane;
    @FXML private Label totalPowerLabel;
    @FXML private Label costPredictionLabel;
    @FXML private LineChart<Number, Number> powerChart;

    private ApplianceService applianceService = new ApplianceService();
    private XYChart.Series<Number, Number> series = new XYChart.Series<>();
    private int time = 0;

    @FXML
    public void initialize() {
        series.setName("Live Power Usage (W)");
        powerChart.getData().add(series);
        populateAppliances();
        startSimulation();
    }

    private void populateAppliances() {
        appliancePane.getChildren().clear();
        List<Appliance> appliances = DataStore.getAppliances();

        for (Appliance a : appliances) {
            ToggleButton toggle = new ToggleButton(a.getName());
            toggle.setPrefWidth(150);
            toggle.setSelected(a.isOn());
            toggle.setOnAction(e -> {
                a.setOn(toggle.isSelected());
                updateDashboard();
            });
            appliancePane.getChildren().add(toggle);
        }

        updateDashboard();
    }

    private void startSimulation() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            double totalPower = applianceService.totalPowerNow(DataStore.getAppliances());
            series.getData().add(new XYChart.Data<>(time++, totalPower));
            if (series.getData().size() > 40) series.getData().remove(0);
            updateDashboard();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateDashboard() {
        double totalPower = applianceService.totalPowerNow(DataStore.getAppliances());
        double cost = applianceService.predictMonthlyCost(DataStore.getAppliances(), 8);
        totalPowerLabel.setText(String.format("Total Power: %.1f W", totalPower));
        costPredictionLabel.setText(String.format("Predicted Monthly Cost: ₹%.2f", cost));
    }
}
