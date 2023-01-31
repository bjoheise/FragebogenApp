package Fragebogen.Controller;

import Fragebogen.Egogram;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StartSceneController {

    public TextField pseudonymInput;

    public static String pseudonym;

    /**
     * Load Scene for Client
     *
     * @throws IOException If fxml not found
     */
    public void onButtonClientClick() throws IOException {
        // First, store the variable to static
        pseudonym = pseudonymInput.getText();
        Egogram.instance.loadScene("Client/IntroSceneClient.fxml");
    }

}
