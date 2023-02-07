package Fragebogen.Controller.Client;

import Fragebogen.Controller.StartSceneController;
import Fragebogen.Model.Calculation;
import Fragebogen.Modules.ResultToPdf;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;

public class EndSceneClientController {

    /**
     * Exit Application
     */
    public void buttonExitClick() {

        // Instantiate Alert Object
        Alert alert = new Alert(
                Alert.AlertType.WARNING,
                "Programm Beenden? Nicht gespeicherte Änderungen gehen verloren!",
                ButtonType.OK,
                ButtonType.CANCEL
        );

        // Display the Alert-Popup
        alert.showAndWait();

        // Exit, if yes is clicked
        if (alert.getResult() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }

    }

    public void buttonSavePdfClick() throws Exception {

        // Get Chart Values
        ArrayList<Integer> scaleValues = Calculation.skala();
        // Get Answers
        ObservableList<String> answerValues = Calculation.answerList;
        // Instantiate Class
        ResultToPdf resultToPdf = new ResultToPdf();
        // Generate PDF
        resultToPdf.manipulatePdf(scaleValues, answerValues, StartSceneController.pseudonym);

    }

}
