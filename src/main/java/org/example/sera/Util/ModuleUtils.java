package org.example.sera.Util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.sera.SERAApplication;
import org.example.sera.Util.GUI.AccordionUtil;
import org.example.sera.Util.GUI.Scaling;

import java.io.IOException;
import java.util.List;

public final class ModuleUtils {

    public static void registerMultipleChoiceQuestion(Pane rootPane, List<String> radioButtonIds, String submitButtonId, String labelId, char correctAnswer) {
        ToggleGroup toggleGroup = new ToggleGroup();
        for (String radioButtonId : radioButtonIds) {
            RadioButton radioButton = (RadioButton) lookupComponent(rootPane, radioButtonId);
            radioButton.setToggleGroup(toggleGroup);
        }

        Button submitButton = (Button) lookupComponent(rootPane, submitButtonId);
        Label feedbackLabel = (Label) lookupComponent(rootPane, labelId);
        registerSubmitButton(toggleGroup, correctAnswer, feedbackLabel, submitButton);
    }

    public static void registerMultipleChoiceQuestion(Pane rootPane, ToggleGroup group, Button submitButton, Label feedbackLabel, char correctAnswer) {
        registerSubmitButton(group, correctAnswer, feedbackLabel, submitButton);
    }

    public static void registerCompleteButton(Button button) {
        button.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(SERAApplication.class.getResource("congrats_popup.fxml"));
            Parent popupRoot;
            try {
                popupRoot = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Stage popupStage = new Stage();
            Scene popupScene = new Scene(popupRoot);

            popupStage.setScene(popupScene);

            // Make the popup dismiss when clicking outside
            popupStage.initModality(Modality.WINDOW_MODAL); // Blocks other windows until this popup is dismissed
            popupStage.initStyle(StageStyle.UNDECORATED);   // No default window decoration
            popupStage.setAlwaysOnTop(true);                // Popup stays on top
            popupStage.initOwner(null);                     // You can set the owner to main stage if needed

            // Close when clicking outside
            popupScene.setOnMouseClicked(event -> popupStage.close());

            // Show the popup
            popupStage.showAndWait();
        });
    }

    public static void registerBackButton(Button button) {
        button.setOnAction(actionEvent -> {
            try {
                SERAApplication.navigate(Scaling.createScalableGUI(new FXMLLoader(SERAApplication.class.getResource("home-page.fxml")), 638, 374));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void registerSubmitButton(ToggleGroup group, char correctAnswer, Label feedbackLabel, Button submitButton) {
        submitButton.setOnAction(event -> {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            if (selectedRadioButton != null) {
                char selectedAnswer = selectedRadioButton.getText().charAt(0);

                if (selectedAnswer == correctAnswer) {
                    feedbackLabel.setText("Woop Woop! Your Answer is Correct.");
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

    public static void registerTypedQuestion(TextField textField, Button submitButton, Label feedbackLabel, String correctAnswer) {
        submitButton.setOnAction(actionEvent -> {
            if (textField.getText().equalsIgnoreCase(correctAnswer)) {
                feedbackLabel.setText("Woop Woop! Your Answer is Correct.");
                textField.setDisable(true);
                submitButton.setDisable(true);
            } else {
                feedbackLabel.setText("Incorrect. Please Try Again. Make Sure Your Format is Correct!");
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

