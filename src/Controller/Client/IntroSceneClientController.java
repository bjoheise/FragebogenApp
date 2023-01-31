package Fragebogen.Controller.Client;

import Fragebogen.Egogram;
import javafx.event.ActionEvent;

import java.io.IOException;

public class IntroSceneClientController {

    public void onStartButtonClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Client/QuestionSceneClient.fxml");
    }

}
