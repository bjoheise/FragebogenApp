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

//    public  Label labelQuestion;
    public Text labelQuestion;
    public Button nextButton;
    public int fragenid;

    public int counter = 0;
    public int fragencounter = 1;
    //String frage1 = frage;
    public ObservableList<Question> questionList= FXCollections.observableArrayList();

    // On Scene-Load
    public void initialize() throws SQLException {

        questionList = DatabaseModel.readQuestions();
        //Calculation.algorhythm(questionList, yesRadioButton, noRadioButton, counter);
        //counter++;
        String firstQuestionText = questionList.get(0).getFrage();
        fragencounter = 1;

        // Instantiate new Toddle-Group
        ToggleGroup clientAnswer = new ToggleGroup();

        // Set the Radio-Button-Group
        yesRadioButton.setToggleGroup(clientAnswer);
        noRadioButton.setToggleGroup(clientAnswer);
        nextButton.setDisable(true);
        //questionList.get(counter).getStar();

        labelQuestion.setText(fragencounter + ".) " + firstQuestionText);


    }

    /**
     * @param actionEvent
     * @TODO Loop over Questions
     */
    public void radioYesClick(ActionEvent actionEvent) {
        boolean isSelected = yesRadioButton.isSelected();
        nextButton.setDisable(false);
//        System.out.println("Yes");
    }

    /**
     * @param actionEvent
     * @TODO Loop over Questions
     */
    public void radioNoClick(ActionEvent actionEvent) {
        boolean isSelected = noRadioButton.isSelected();
        nextButton.setDisable(false);
//        System.out.println("no");
    }

    public void nextQuestion(ActionEvent actionEvent) throws IOException, SQLException {


        fragencounter++;

        Calculation.algorhythm(questionList, yesRadioButton, noRadioButton, counter);
        counter++;
        String frage = questionList.get(counter).getFrage();

        labelQuestion.setText(fragencounter + ".) " + frage);

        noRadioButton.setSelected(false);
        yesRadioButton.setSelected(false);
        nextButton.setDisable(true);

        if (fragencounter == 143){
            Egogram.instance.loadScene("Client/EndSceneClient.fxml");
        }



    }

}
