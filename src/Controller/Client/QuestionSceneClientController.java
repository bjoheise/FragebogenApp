package Fragebogen.Controller.Client;

import Fragebogen.Controller.StartSceneController;
import Fragebogen.Egogram;
import Fragebogen.Model.Calculation;
import Fragebogen.Model.DatabaseModel;
import Fragebogen.Model.Question;
import Fragebogen.Modules.ResultToPdf;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionSceneClientController {

    // Get Radio-Buttons from FXML
    public RadioButton yesRadioButton;
    public RadioButton noRadioButton;
    public Label questionCounter;

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

    public ObservableList<Question> questionList = FXCollections.observableArrayList();

    public String pseudonym;

    // On Scene-Load
    public void initialize() throws SQLException {

        DatabaseModel.connect();
        questionList = DatabaseModel.readQuestions();
        counter = 140;

        // Instantiate new Toggle-Group
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

        questionCounter.setText("Frage: " + questionList.get(counter).getId() + "/143");

    }

    public void FrageNummerAnzeigen(String frage, int wert) {
        labelQuestion.setText(wert + ".) " + frage);
    }

    public void radioYesClick(ActionEvent actionEvent) {
        boolean isSelected = yesRadioButton.isSelected();
        nextButton.setDisable(false);
    }

    public void radioNoClick(ActionEvent actionEvent) {
        boolean isSelected = noRadioButton.isSelected();
        nextButton.setDisable(false);
    }

    public void nextQuestion(ActionEvent actionEvent) throws Exception {

        Calculation.algorhythm(questionList, yesRadioButton, noRadioButton, counter);
        Calculation.writeAnswers(questionList, yesRadioButton, noRadioButton, counter);

        counter++;

        // Hochzählen solange wir nicht das ende des arrays erreicht haben, ansonsten end szena anzeigen
        if (counter < questionList.size()) {

            questionCounter.setText("Frage: " + questionList.get(counter).getId() + "/143");
            String frage = questionList.get(counter).getFrage();

            FrageNummerAnzeigen(frage, questionList.get(counter).getId());

            noRadioButton.setSelected(false);
            yesRadioButton.setSelected(false);
            nextButton.setDisable(true);

        } else {

            // Get Chart Values
            ArrayList<Integer> scaleValues = Calculation.skala();
            // Get Answers
            ObservableList<String> answerValues = Calculation.answerList;

            // Generate PDF
            ResultToPdf resultToPdf = new ResultToPdf();
            resultToPdf.manipulatePdf(scaleValues, answerValues, StartSceneController.pseudonym);

            // Load End-Scene
            Egogram.instance.loadScene("Client/EndSceneClient.fxml");

        }

    }

}
