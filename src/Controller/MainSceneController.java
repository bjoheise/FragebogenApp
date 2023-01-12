package Fragebogen.Controller;

import Fragebogen.Egogram;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;

public class MainSceneController {

    /**
     * Run on "File > Close"-Click
     *
     * @param actionEvent
     */
    public void onMenuCloseClick(ActionEvent actionEvent) {

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

    /**
     * Load Scene for Coach
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onButtonCoachClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("IntroSceneCoach.fxml");
    }

    /**
     * Load Scene for Client
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onButtonClientClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("IntroSceneClient.fxml");
    }
}
