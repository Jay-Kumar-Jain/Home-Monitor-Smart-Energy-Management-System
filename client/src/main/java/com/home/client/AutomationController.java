package com.home.client;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.util.Duration;

import java.util.List;
import java.util.stream.Collectors;

public class AutomationController {

    @FXML private ListView<String> automationList;
    @FXML private Label alertLabel;

    private ApplianceService service = new ApplianceService();

    @FXML
    public void initialize() {
        refreshAutomationRules();
        startMonitoring();
    }

    private void refreshAutomationRules() {
        automationList.getItems().clear();
        automationList.getItems().add("Rule 1: Turn off devices > 1200W if total load > 3000W");
        automationList.getItems().add("Rule 2: Turn off all appliances after midnight (simulation)");
        automationList.getItems().add("Rule 3: Auto balance high load");
    }

    private void startMonitoring() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            double totalPower = service.totalPowerNow(DataStore.getAppliances());

            if (totalPower > 3000) {
                List<Appliance> heavy = DataStore.getAppliances().stream()
                        .filter(a -> a.isOn() && a.getPowerRating() > 1200)
                        .collect(Collectors.toList());
                if (!heavy.isEmpty()) {
                    heavy.forEach(a -> a.setOn(false));
                    alertLabel.setText("⚠️ Overload detected! Turned off: " +
                            heavy.stream().map(Appliance::getName).collect(Collectors.joining(", ")));
                }
            } else {
                alertLabel.setText("✅ System operating normally");
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
