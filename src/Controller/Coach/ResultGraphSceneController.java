package Fragebogen.Controller.Coach;

import Fragebogen.Egogram;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ResultGraphSceneController {

    public StackedBarChart<String, Number> barChart;
    public CategoryAxis xAxis;
    public NumberAxis yAxis;

    public void initialize() {
        this.buildChart();
    }

    public void buildChart() {


//        barChart.setTitle("Egogram");
//        barChart.setLegendVisible(false);
//        barChart.setAnimated(false);
//
//        barChart.setBarGap(0);
//        barChart.setCategoryGap(0);
////        barChart.setHorizontalGridLinesVisible(true);
//
//        xAxis.setLabel("Anteile");
//        xAxis.setCategories(FXCollections
//                .<String>observableArrayList(Arrays.asList(
//                "Euro",
//                "Euro2"
//                )));
//        xAxis.setLabel("category");
//
//
//        yAxis.setLabel("%");
//        yAxis.setAnimated(false);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);

//        XYChart.Series series1 = new XYChart.Series();
//        series1.getData().add(new XYChart.Data("Kritisches", 15));
//
//        XYChart.Series series2 = new XYChart.Series();
//        series2.getData().add(new XYChart.Data("2", 85));
//
//        XYChart.Series series3 = new XYChart.Series();
//        series3.getData().add(new XYChart.Data("3", 55));

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
