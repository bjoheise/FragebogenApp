package Fragebogen.Controller.Client;

import Fragebogen.Egogram;
import Fragebogen.Model.DatabaseModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.sql.SQLException;

import static Fragebogen.Model.DatabaseModel.*;

public class QuestionSceneClientController {

    // Get Radio-Buttons from FXML
    public RadioButton yesRadioButton;
    public RadioButton noRadioButton;
    public Label labelQuestion;

    //String frage1 = frage;


    // On Scene-Load
    public void initialize() {

        // Instantiate new Toddle-Group
        ToggleGroup clientAnswer = new ToggleGroup();

        // Set the Radio-Button-Group
        yesRadioButton.setToggleGroup(clientAnswer);
        noRadioButton.setToggleGroup(clientAnswer);
        labelQuestion.setText(frage1);
        //labelQuestion.setText(String.valueOf(id));
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

    public void nextQuestion(ActionEvent actionEvent) throws IOException, SQLException {

        i++;
        labelQuestion.setText(frage);
        DatabaseModel.readQuestions();
        Egogram.instance.loadScene("Client/QuestionSceneClient.fxml");


    }
}
