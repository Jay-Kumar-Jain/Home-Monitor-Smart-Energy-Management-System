package com.home.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class MainLayoutController {

    @FXML
    private BorderPane rootPane;

    @FXML
    private void showDashboard() throws Exception {
        setCenter("dashboard.fxml");
    }

    @FXML
    private void showAnalytics() throws Exception {
        setCenter("analytics.fxml");
    }

    @FXML
    private void showAutomation() throws Exception {
        setCenter("automation.fxml");
    }

    @FXML
    private void refreshData() throws Exception {
        setCenter("dashboard.fxml");
    }

    private void setCenter(String fxml) throws Exception {
        Node node = FXMLLoader.load(getClass().getResource("/ui/" + fxml));
        rootPane.setCenter(node);
    }
}
