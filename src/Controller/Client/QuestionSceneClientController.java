package Fragebogen.Controller.Client;

import Fragebogen.Controller.StartSceneController;
import Fragebogen.Egogram;
import Fragebogen.Model.Calculation;
import Fragebogen.Model.DatabaseModel;
import Fragebogen.Model.Question;
import Fragebogen.Modules.ResultToPdf;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionSceneClientController {

    // Get Radio-Buttons from FXML
    public RadioButton yesRadioButton;
    public RadioButton noRadioButton;
    public Label questionCounter;
    public Text labelQuestion;
    public Button nextButton;
    public int counter = 0;

    public ObservableList<Question> questionList = FXCollections.observableArrayList();

    /**
     * Runs when the Scene is loaded
     *
     * @throws SQLException If not able to read from DB
     */
    public void initialize() throws SQLException {

        DatabaseModel.connect();
        questionList = DatabaseModel.readQuestions();
        counter = 0;

        // Instantiate new Toggle-Group
        ToggleGroup clientAnswer = new ToggleGroup();

        // Set the Radio-Button-Group
        yesRadioButton.setToggleGroup(clientAnswer);
        noRadioButton.setToggleGroup(clientAnswer);
        nextButton.setDisable(true);

        String question = questionList.get(0).getQuestion();
        FrageNummerAnzeigen(question, questionList.get(counter).getId());
        noRadioButton.setSelected(false);
        yesRadioButton.setSelected(false);
        nextButton.setDisable(true);

        questionCounter.setText("Frage: " + questionList.get(counter).getId() + "/143");

    }

    public void FrageNummerAnzeigen(String question, int value) {
        labelQuestion.setText(value + ".) " + question);
    }

    public void radioYesClick() {
        nextButton.setDisable(false);
    }

    public void radioNoClick() {
        nextButton.setDisable(false);
    }

    public void nextQuestion() throws Exception {

        Calculation.algorhythm(questionList, yesRadioButton, counter);
        Calculation.writeAnswers(questionList, yesRadioButton, counter);

        counter++;

        // Hochzählen solange wir nicht das ende des arrays erreicht haben, ansonsten end szena anzeigen
        if (counter < questionList.size()) {

            questionCounter.setText("Frage: " + questionList.get(counter).getId() + "/143");
            String frage = questionList.get(counter).getQuestion();

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
