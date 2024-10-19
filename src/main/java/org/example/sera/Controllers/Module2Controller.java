package org.example.sera.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import org.example.sera.Util.ModuleUtils;
import javafx.scene.web.WebView;

public class Module2Controller {

    @FXML
    ToggleGroup q1;

    @FXML
    Button q1_submit;

    @FXML
    Label q1_feedback;

    @FXML
    VBox module_1_root;

    @FXML
    ToggleGroup q2;

    @FXML
    Button q2_submit;

    @FXML
    Label q2_feedback;

    @FXML
    public void initialize() {
        ModuleUtils.registerMultipleChoiceQuestion(module_1_root, q1, q1_submit, q1_feedback, 'C');
        ModuleUtils.registerMultipleChoiceQuestion(module_1_root, q2, q2_submit, q2_feedback, 'A');
    }
}
