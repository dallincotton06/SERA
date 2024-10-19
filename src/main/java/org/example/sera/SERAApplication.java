package org.example.sera;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.sera.Util.GUI.Scaling;

import java.io.IOException;

public class SERAApplication extends Application {

    private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        SERAApplication.stage = stage;
        Scene scene = Scaling.createScalableGUI(new FXMLLoader(SERAApplication.class.getResource("home-page.fxml")), 638, 374);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        SERAApplication.stage.setTitle("Social Engineering Resistance Application");
        SERAApplication.stage.setScene(scene);
        SERAApplication.stage.show();
    }

    public static void navigate(Scene scene) {
        SERAApplication.stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }
}