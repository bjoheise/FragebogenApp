package Fragebogen.Controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class MainSceneController {

    /**
     * Run on "File > Close"-Click
     */
    public void onMenuCloseClick() {

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
