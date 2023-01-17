package Fragebogen.Controller.Client;

import Fragebogen.Egogram;
import Fragebogen.Model.Calculation;
import Fragebogen.Model.DatabaseModel;
import Fragebogen.Model.Question;
import Fragebogen.Model.Calculation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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

    public Label labelQuestion;
    public Button nextButton;

    private int counter = 0;

    //String frage1 = frage;
    public ObservableList<Question> questionList= FXCollections.observableArrayList();

    // On Scene-Load
    public void initialize() throws SQLException {

        // Instantiate new Toddle-Group
        ToggleGroup clientAnswer = new ToggleGroup();

        // Set the Radio-Button-Group
        yesRadioButton.setToggleGroup(clientAnswer);
        noRadioButton.setToggleGroup(clientAnswer);
        nextButton.setDisable(true);
        labelQuestion.setText(frage1);
        //labelQuestion.setText(String.valueOf(id));
        questionList = DatabaseModel.readQuestions();
    }

    /**
     * @param actionEvent
     * @TODO Loop over Questions
     */
    public void radioYesClick(ActionEvent actionEvent) {
        boolean isSelected = yesRadioButton.isSelected();
        nextButton.setDisable(false);
        System.out.println("Yes");
    }

    /**
     * @param actionEvent
     * @TODO Loop over Questions
     */
    public void radioNoClick(ActionEvent actionEvent) {
        boolean isSelected = noRadioButton.isSelected();
        nextButton.setDisable(false);
        System.out.println("no");
    }

    public void nextQuestion(ActionEvent actionEvent) throws IOException, SQLException {

        counter++;


        if(counter > questionList.size()) {
            return;
        }
        String frage =  questionList.get(counter).getFrage();
        int star = questionList.get(counter).getStar();

        

            if(yesRadioButton.isSelected()){
                Calculation.bw++;

                if(star == 1){
                    Calculation.kel++;
                }
            }
            System.out.println("bw:" + Calculation.bw + " kel:" + Calculation.kel);
            Calculation.sel = Calculation.bw -Calculation.kel;
            System.out.println("sel:" + Calculation.sel);

        labelQuestion.setText(frage);
        noRadioButton.setSelected(false);
        yesRadioButton.setSelected(false);
        nextButton.setDisable(true);
        //Calculation.algorhythm();




    }
}
