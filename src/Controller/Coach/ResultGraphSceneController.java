package Fragebogen.Controller.Coach;

import Fragebogen.Egogram;
import javafx.event.ActionEvent;
import java.io.IOException;

public class ResultGraphSceneController {
    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Coach/IntroSceneCoach.fxml");
    }
}
