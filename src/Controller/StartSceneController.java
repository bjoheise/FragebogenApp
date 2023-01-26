package Fragebogen.Controller;

import Fragebogen.Egogram;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.io.IOException;

public class StartSceneController {

    public TextField pseudonymInput;

    /**
     * Load Scene for Client
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onButtonClientClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Client/IntroSceneClient.fxml");
    }

}
