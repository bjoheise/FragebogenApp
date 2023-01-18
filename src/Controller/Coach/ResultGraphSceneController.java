package Fragebogen.Controller.Coach;

import Fragebogen.Egogram;
import Fragebogen.Modules.ResultToPdf;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.xml.sax.ErrorHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static javafx.embed.swing.SwingFXUtils.fromFXImage;

public class ResultGraphSceneController {

    public StackedBarChart<String, Number> barChart;
    public CategoryAxis xAxis;
    public NumberAxis yAxis;
    public Button buttonExport;
    public Group chartGroup;

    public void initialize() {
        this.buildChart();
    }

    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Coach/IntroSceneCoach.fxml");
    }

    public void onButtonExportClick(ActionEvent actionEvent) throws Exception {

        // Get the node (StackedBarChart) via ID on Button Click
        Node node = buttonExport.getParent().lookup("#barChart");


        // Instantiate PDF-Generator
        ResultToPdf resultToPdf = new ResultToPdf();
        // Call Method to generate PDF
        resultToPdf.generatePdf(node);

    }

    public void buildChart() {

        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<String, Number>("Kritisch", 42));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.getData().add(new XYChart.Data<String, Number>("Stützend", 79));

        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.getData().add(new XYChart.Data<String, Number>("Erwachsen", 58));

        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        series4.getData().add(new XYChart.Data<String, Number>("Natürlich", 13));

        XYChart.Series<String, Number> series5 = new XYChart.Series<>();
        series5.getData().add(new XYChart.Data<String, Number>("Angepasst", 25));

        barChart.getData().addAll(series1, series2, series3, series4, series5);

    }


}
