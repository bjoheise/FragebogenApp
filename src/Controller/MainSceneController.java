package Fragebogen.Controller;

import Fragebogen.Egogram;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;

public class MainSceneController {

    public void onMenuCloseClick(ActionEvent actionEvent) {

        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Exit?",
                ButtonType.OK,
                ButtonType.CANCEL
        );

        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }

    }

    public void onButtonCoachClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("StartSceneCoach.fxml");
    }

    public void onButtonClientClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("StartSceneClient.fxml");
    }
}
