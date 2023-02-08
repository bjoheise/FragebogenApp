package Fragebogen.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;

import javax.swing.text.Element;
import javax.swing.text.html.ImageView;

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

    public void onInfoClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("FragebogenApp");
        alert.setHeaderText("made by Flo,Thoma,Björn,Julez");
        alert.setContentText("FragebogenApp für den Fragebogen Egogramm");
        alert.setGraphic(null);
        alert.show();

    }
}
