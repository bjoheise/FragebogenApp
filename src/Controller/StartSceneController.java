package Fragebogen.Controller;

import Fragebogen.Egogram;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StartSceneController {

    public TextField pseudonymInput;

    public static String pseudonym;
    public static Button onButtonClientId;

    /**
     * Load Scene for Client
     *
     * @throws IOException If fxml not found
     *
     */

    //HIER DIE METHODE UM DEN INTERVIEW BUTTON DISABLED ZU MACHEN
    public void onTextfieldInput(ActionEvent actionEvent) {

    }


    public void onButtonClientClick() throws IOException {

        // First, store the variable to static
        pseudonym = pseudonymInput.getText();

        Egogram.instance.loadScene("Client/IntroSceneClient.fxml");
    }


    public void onMouseClickedInterview(MouseEvent mouseEvent) throws IOException {
        onButtonClientClick();
    }
}
