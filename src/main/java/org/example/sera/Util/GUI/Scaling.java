package org.example.sera.Util.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;
import org.example.sera.SERAApplication;

import java.io.IOException;

public final class Scaling {

    public static Scene createScalableGUI(FXMLLoader loader, int initialWidth, int initialHeight) throws IOException {
        Node rootNode = loader.load();

        Group root = new Group(rootNode);

        Scale scale = new Scale();
        root.getTransforms().add(scale);

        scale.xProperty().bind(SERAApplication.getStage().widthProperty().divide(initialWidth));
        scale.yProperty().bind(SERAApplication.getStage().heightProperty().divide(initialHeight));
        Scene scene = new Scene(root, 320, 240);
        scene.getStylesheets().add(SERAApplication.class.getResource("style.css").toExternalForm());

        return scene;
    }
}
