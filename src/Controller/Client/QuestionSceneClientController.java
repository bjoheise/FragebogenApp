package Fragebogen.Controller.Client;

import Fragebogen.Egogram;
import Fragebogen.Model.Calculation;
import Fragebogen.Model.DatabaseModel;
import Fragebogen.Model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;

import static Fragebogen.Model.DatabaseModel.*;

public class QuestionSceneClientController {

    // Get Radio-Buttons from FXML
    public  RadioButton yesRadioButton;
    public RadioButton noRadioButton;

    public RadioButton getYesRadioButton() {
        return yesRadioButton;
    }

    public void setYesRadioButton(RadioButton yesRadioButton) {
        this.yesRadioButton = yesRadioButton;
    }

    public RadioButton getNoRadioButton() {
        return noRadioButton;
    }

    public void setNoRadioButton(RadioButton noRadioButton) {
        this.noRadioButton = noRadioButton;
    }

    public Text labelQuestion;
    public Button nextButton;

    public int counter = 0;

    public ObservableList<Question> questionList= FXCollections.observableArrayList();

    // On Scene-Load
    public void initialize() throws SQLException {

        questionList = DatabaseModel.readQuestions();
        counter = 0;

        // Instantiate new Toddle-Group
        ToggleGroup clientAnswer = new ToggleGroup();

        // Set the Radio-Button-Group
        yesRadioButton.setToggleGroup(clientAnswer);
        noRadioButton.setToggleGroup(clientAnswer);
        nextButton.setDisable(true);

        String frage = questionList.get(0).getFrage();
        FrageNummerAnzeigen(frage, questionList.get(counter).getId());
        noRadioButton.setSelected(false);
        yesRadioButton.setSelected(false);
        nextButton.setDisable(true);

    }

    public void FrageNummerAnzeigen(String frage, int wert){
        labelQuestion.setText( wert + ".) " + frage);
    }

    public void radioYesClick(ActionEvent actionEvent) {
        boolean isSelected = yesRadioButton.isSelected();
        nextButton.setDisable(false);
//        System.out.println("Yes");
    }

    public void radioNoClick(ActionEvent actionEvent) {
        boolean isSelected = noRadioButton.isSelected();
        nextButton.setDisable(false);
    }

    public void nextQuestion(ActionEvent actionEvent) throws IOException, SQLException {

        //System.out.println("DEBUG: Counter" + counter);
        Calculation.algorhythm(questionList, yesRadioButton, noRadioButton, counter);
        counter++;

        // Hochzählen solange wir nicht das ende des arrays erreicht haben, ansonsten end szena anzeigen
        if(counter < questionList.size()){

            String frage = questionList.get(counter).getFrage();

            FrageNummerAnzeigen(frage, questionList.get(counter).getId());

            noRadioButton.setSelected(false);
            yesRadioButton.setSelected(false);
            nextButton.setDisable(true);
        }
        else{
            Egogram.instance.loadScene("Client/EndSceneClient.fxml");
        }

    }

}
