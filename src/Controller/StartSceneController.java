package Fragebogen.Controller;

import Fragebogen.Egogram;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StartSceneController {

    /**
     * Load Scene for Coach
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onButtonCoachClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Coach/IntroSceneCoach.fxml");
    }

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
