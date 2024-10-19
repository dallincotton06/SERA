package org.example.sera.Util;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import org.example.sera.Util.GUI.AccordionUtil;

import java.util.List;

public final class ModuleUtils {

    public static void registerMultipleChoiceQuestion(Pane rootPane, List<String> radioButtonIds, String submitButtonId, String labelId, String correctAnswer) {
        ToggleGroup toggleGroup = new ToggleGroup();
        for (String radioButtonId : radioButtonIds) {
            RadioButton radioButton = (RadioButton) lookupComponent(rootPane, radioButtonId);
            radioButton.setToggleGroup(toggleGroup);
        }

        Button submitButton = (Button) lookupComponent(rootPane, submitButtonId);
        Label feedbackLabel = (Label) lookupComponent(rootPane, labelId);
        registerSubmitButton(toggleGroup, correctAnswer, feedbackLabel, submitButton);
    }

    public static void registerMultipleChoiceQuestion(Pane rootPane, ToggleGroup group, Button submitButton, Label feedbackLabel, String correctAnswer) {
        registerSubmitButton(group, correctAnswer, feedbackLabel, submitButton);
    }

    private static void registerSubmitButton(ToggleGroup group, String correctAnswer, Label feedbackLabel, Button submitButton) {
        submitButton.setOnAction(event -> {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            if (selectedRadioButton != null) {
                String selectedAnswer = selectedRadioButton.getText();

                if (selectedAnswer.equals(correctAnswer)) {
                    feedbackLabel.setText("Correct! The correct answer is " + correctAnswer + ".");
                    disable(group);
                    disable(submitButton);
                } else {
                    feedbackLabel.setText("Incorrect. Please Try Again.");
                }
            } else {
                feedbackLabel.setText("Please select an answer.");
            }
        });
    }

    public static Node lookupComponent(Pane pane, String id) {
        Node node = pane.lookup("#" + id);
        if (node == null) {
            System.out.println("Error: SubmitButton with ID " + node + " not found.");
            return new Label();
        }
        return node;
    }

    private static void disable(ToggleGroup group) {
        for (Toggle toggle : group.getToggles()) {
            if (toggle instanceof RadioButton) {
                ((RadioButton) toggle).setDisable(true);
            }
        }
    }

    private static void disable(Button button) {
        button.setDisable(true);
    }
}

