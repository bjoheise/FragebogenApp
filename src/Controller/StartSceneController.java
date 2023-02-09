package Fragebogen.Controller;

import Fragebogen.Egogram;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;

public class StartSceneController {

    public TextField pseudonymInput;
    public static String pseudonym;
    public Button buttonClientId;

    /**
     * @throws IOException If TextField is empty
     */
    public void onButtonClientClick() throws IOException {

        // First, store the variable to static
        pseudonym = pseudonymInput.getText();

        String pseudonymCheck = pseudonym.replaceAll("\\s+", "");

        if (pseudonymCheck.chars().count() <= 5) {

            Alert alert = new Alert(
                    Alert.AlertType.WARNING,
                    "Das Pseudonym muss mindestens 5 Zeichen enthalten (keine Leerzeichen).",
                    ButtonType.OK
            );

            alert.showAndWait();

        } else {

            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION,
                    "Gewähltes Pseudonym: " + pseudonym,
                    ButtonType.CANCEL,
                    ButtonType.OK
            );

            alert.showAndWait();

            if (Objects.equals(alert.getResult().getText(), "OK")) {
                Egogram.instance.loadScene("Client/IntroSceneClient.fxml");
            }

        }

    }

    /**
     * @throws IOException If not clicked
     */
    public void onMouseClickedInterview() throws IOException {
        onButtonClientClick();
    }

}
