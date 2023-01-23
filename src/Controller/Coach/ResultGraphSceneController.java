package Fragebogen.Controller.Coach;

import Fragebogen.Egogram;
import Fragebogen.Model.Calculation;
import Fragebogen.Modules.ResultToPdf;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ResultGraphSceneController {

    public Button buttonExport;

    public Stage stage = Egogram.instance.primaryStage;

    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Coach/IntroSceneCoach.fxml");
    }

    public void onButtonExportClick(ActionEvent actionEvent) throws Exception {

        // Get the scales
        ArrayList<Integer> skala = Calculation.skala();

        // Generate PDF
        ResultToPdf resultToPdf = new ResultToPdf();
        resultToPdf.manipulatePdf(skala);

    }

}
