package Fragebogen.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class QuestionSceneClientController {

    // Get Radio-Buttons from FXML
    public RadioButton yesRadioButton;
    public RadioButton noRadioButton;

    // On Scene-Load
    public void initialize() {

        // Instantiate new Toddle-Group
        ToggleGroup clientAnswer = new ToggleGroup();

        // Set the Radio-Button-Group
        yesRadioButton.setToggleGroup(clientAnswer);
        noRadioButton.setToggleGroup(clientAnswer);

    }

    /**
     * @param actionEvent
     * @TODO Loop over Questions
     */
    public void radioYesClick(ActionEvent actionEvent) {
        boolean isSelected = yesRadioButton.isSelected();
        System.out.println("Yes");
    }

    /**
     * @param actionEvent
     * @TODO Loop over Questions
     */
    public void radioNoClick(ActionEvent actionEvent) {
        boolean isSelected = noRadioButton.isSelected();
        System.out.println("no");
    }

}
