package Fragebogen.Controller;

import Fragebogen.Egogram;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StartSceneCoachController {
    public void onButtonShowGraphClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("ResultGraphScene.fxml");
    }

    public void onButtonExportGraphClick(ActionEvent actionEvent) {
        // @TODO: Print PDF
    }
}
