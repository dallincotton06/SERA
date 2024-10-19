package org.example.sera.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.example.sera.Util.ModuleUtils;
import javafx.scene.web.WebView;

public class Module1Controller {

    boolean moduleComplete = true;
    @FXML
    WebView video_1;

    @FXML
    WebView video_2;

    @FXML
    ToggleGroup q1;

    @FXML
    Button q1_submit;

    @FXML
    Label q1_feedback;

    @FXML
    VBox module_1_root;

    @FXML
    TextField q2;

    @FXML
    TextField q3;

    @FXML
    Button q2_submit;

    @FXML
    Button q3_submit;

    @FXML
    Label q2_feedback;

    @FXML
    Label q3_feedback;

    @FXML
    Button back;

    @FXML
    Button complete;

    @FXML
    public void initialize() {
        video_1.getEngine().load("https://www.youtube.com/embed/lc7scxvKQOo?si=Cgb0_YJiBa_q6_qZ");
        video_2.getEngine().load("https://www.youtube.com/embed/uvKTMgWRPw4?si=LqaG8lQMUXaL_HlO");
        ModuleUtils.registerMultipleChoiceQuestion(module_1_root, q1, q1_submit, q1_feedback, 'C');
        ModuleUtils.registerTypedQuestion(q2, q2_submit, q2_feedback, "cell phone provider");
        ModuleUtils.registerTypedQuestion(q3, q3_submit, q3_feedback, "heightened emotions, urgency, trust");
        ModuleUtils.registerBackButton(back);
        ModuleUtils.registerCompleteButton(complete);
    }


}
