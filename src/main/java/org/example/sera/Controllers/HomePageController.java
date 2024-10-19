package org.example.sera.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.sera.SERAApplication;
import org.example.sera.Util.GUI.Scaling;

import java.io.IOException;

public class HomePageController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button module_1_link;

    @FXML
    private Button module_2_link;

    @FXML
    private Button module_3_link;

    @FXML
    private Button module_4_link;

    @FXML
    private Button module_5_link;

    @FXML
    private Button module_6_link;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void module_1_linkAction() throws IOException {
        Scene scene = Scaling.createScalableGUI(new FXMLLoader(SERAApplication.class.getResource("module_1_social_engineering.fxml")), 640, 400);
        SERAApplication.navigate(scene);
    }
    @FXML
    private void module_2_linkAction() throws IOException {
        Scene scene = Scaling.createScalableGUI(new FXMLLoader(SERAApplication.class.getResource("module_2_phishing.fxml")), 640, 400);
        SERAApplication.navigate(scene);
    }
    @FXML
    private void module_3_linkAction() throws IOException {
        Scene scene = Scaling.createScalableGUI(new FXMLLoader(SERAApplication.class.getResource("module_3_deep_fakes.fxml")), 640, 400);
        SERAApplication.navigate(scene);
    }
    @FXML
    private void module_4_linkAction() throws IOException {
        Scene scene = Scaling.createScalableGUI(new FXMLLoader(SERAApplication.class.getResource("module_4_piggybacking.fxml")), 640, 400);
        SERAApplication.navigate(scene);
    }
}