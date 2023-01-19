package Fragebogen.Controller.Coach;

import Fragebogen.Egogram;
import Fragebogen.Model.DatabaseModel;
import Fragebogen.Model.Question;
import Fragebogen.Modules.ResultToPdf;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Arrays;

public class ResultGraphSceneController {

    public StackedBarChart<String, Number> barChart;
    public CategoryAxis xAxis;
    public NumberAxis yAxis;
    public Button buttonExport;

    public void initialize() {
        this.buildChart();
    }

    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Coach/IntroSceneCoach.fxml");
    }

    public void onButtonExportClick(ActionEvent actionEvent) throws Exception {

        // Get the node (StackedBarChart) via ID on Button Click
        Node node = buttonExport.getParent().lookup("#barChart");
        Scene scene = buttonExport.getScene();
        scene.getStylesheets().add("Res/chart.css");

        ObservableList<Question> questionObservableList = DatabaseModel.readQuestions();

        // Instantiate PDF-Generator
        ResultToPdf resultToPdf = new ResultToPdf();
        // Call Method to generate PDF
        resultToPdf.generatePdf(node, questionObservableList);

    }

    public void buildChart() {

        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);

        yAxis.setTickUnit(10f);
        yAxis.setTickLength(20);
        yAxis.setMinorTickCount(0);

//        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
//                ("Kritisch", "Stützend")));

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        XYChart.Series<String, Number> series5 = new XYChart.Series<>();

        series5.getData().add(new XYChart.Data<String, Number>("1", 78));
        series1.getData().add(new XYChart.Data<String, Number>("2", 20));
        series2.getData().add(new XYChart.Data<String, Number>("3", 45));
        series3.getData().add(new XYChart.Data<String, Number>("4", 12));
        series4.getData().add(new XYChart.Data<String, Number>("5", 34));

        barChart.getData().addAll(series1, series2, series3, series4, series5);

    }

}
