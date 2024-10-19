package org.example.sera.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.example.sera.Util.ModuleUtils;

public class Module1Controller {

    @FXML
    ToggleGroup q1;

    @FXML
    Button q1_submit;

    @FXML
    Label q1_feedback;

    @FXML
    VBox module_1_root;

    @FXML
    public void initialize() {
        ModuleUtils.registerMultipleChoiceQuestion(module_1_root, q1, q1_submit, q1_feedback, "Paris");
    }
}
