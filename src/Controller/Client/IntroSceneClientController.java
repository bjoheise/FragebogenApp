package Fragebogen.Controller.Client;

import Fragebogen.Egogram;
import Fragebogen.Model.DatabaseModel;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.SQLException;

public class IntroSceneClientController {

    public void onStartButtonClick(ActionEvent actionEvent) throws IOException, SQLException {
        Egogram.instance.loadScene("Client/QuestionSceneClient.fxml");
    }

}
