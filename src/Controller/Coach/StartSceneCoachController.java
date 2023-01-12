package Fragebogen.Controller.Coach;

import Fragebogen.Egogram;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;

public class StartSceneCoachController {
    public void onButtonShowGraphClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Coach/ResultGraphScene.fxml");
    }

    public void onButtonExportGraphClick(ActionEvent actionEvent) {
        // @TODO: Print PDF
    }

    public void onButtonExitClick(ActionEvent actionEvent) {

        // Instantiate Alert Object
        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Exit?",
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
}
