package Fragebogen.Controller.Client;

import Fragebogen.Egogram;

import java.io.IOException;

public class IntroSceneClientController {

    /**
     * Loads the Questions-Scene
     *
     * @throws IOException If fxml not found
     */
    public void onStartButtonClick() throws IOException {
        Egogram.instance.loadScene("Client/QuestionSceneClient.fxml");
    }

}
