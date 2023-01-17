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

    public BarChart<String, Number> barChart;
    public CategoryAxis xAxis;
    public NumberAxis yAxis;

    public void initialize() {
        this.buildChart();
    }

    public void buildChart() {
//        CategoryAxis xAxis = new CategoryAxis();
//        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
//                "Speed", "User rating", "Mileage")));
//        xAxis.setLabel("category");
//
////Defining the y axis
//        NumberAxis yAxis = new NumberAxis(0, 100, 5);
//        yAxis.setLabel("score");
////Creating the Bar chart
//        StackedBarChart<String, Number> barChart = new StackedBarChart<>(xAxis, yAxis);
//        barChart.setTitle("Comparison between various cars");
//
//        //Prepare XYChart.Series objects by setting data
//        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
//        series1.getData().add(new XYChart.Data<>("Speed", 15.0));
//
//        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
//        series2.getData().add(new XYChart.Data<>("User rating", 64.0));
//
//        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
//
//        series3.getData().add(new XYChart.Data<>("Mileage", 21.0));
//
//        //Setting the data to bar chart
//        barChart.getData().addAll(series1, series2, series3);
//        Group root = new Group(barChart);
//        Scene scene = new Scene(root, 600, 300);
//        Egogram.instance.primaryStage.setScene(scene);
//        Egogram.instance.primaryStage.show();

        barChart.setTitle("Egogram");
        barChart.setBarGap(20);
        barChart.setCategoryGap(50);

        xAxis.setLabel("Anteile");

        yAxis.setLabel("%");
        yAxis.setAnimated(false);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data("1", 15));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2005");
        series2.getData().add(new XYChart.Data("2", 85));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data("3", 55));

        barChart.getData().addAll(series1, series2, series3);


    }

}
