package Fragebogen.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class StartSceneClientController {

    public RadioButton yesRadioButton;
    public RadioButton noRadioButton;

    public void initialize() {

        ToggleGroup clientAnswer = new ToggleGroup();

        yesRadioButton.setToggleGroup(clientAnswer);
        noRadioButton.setToggleGroup(clientAnswer);

    }

    public void radioYesClick(ActionEvent actionEvent) {
        boolean isSelected = yesRadioButton.isSelected();
        System.out.println("Yes");
    }

    public void radioNoClick(ActionEvent actionEvent) {
        boolean isSelected = noRadioButton.isSelected();
        System.out.println("no");
    }

}
