package Fragebogen.Controller.Coach;

import Fragebogen.Egogram;
import Fragebogen.Modules.JavaFXPlotter;
import Fragebogen.Modules.ResultToPdf;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;


public class StartSceneCoachController {

    @FXML
    Button buttonExport;

    public void onButtonShowGraphClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Coach/ResultGraphScene.fxml");
    }

    public void onButtonExportGraphClick(ActionEvent actionEvent) throws Exception {

        System.out.println(buttonExport.getScene());


        Scene scene = buttonExport.getScene();
        // @TODO: Print PDF via ArrayList
        ResultToPdf resultToPdf = new ResultToPdf();

//        resultToPdf.generatePdf(scene);

        JavaFXPlotter javaFXPlotter = new JavaFXPlotter();
        javaFXPlotter.generateChart();

    }

    public void onButtonExitClick(ActionEvent actionEvent) {

        // Instantiate Alert Object
        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Exit?",
                ButtonType.OK,
                ButtonType.CANCEL
        );

        // Display the Alert-Popup
        alert.showAndWait();

        // Exit, if yes is clicked
        if (alert.getResult() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }

    }
}
