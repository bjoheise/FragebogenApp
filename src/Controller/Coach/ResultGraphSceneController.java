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
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class ResultGraphSceneController {

    public void initialize() {
        this.buildChart();
    }

    public void buildChart() {
        CategoryAxis xAxis = new CategoryAxis();

        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
                "Speed", "User rating", "Mileage")));
        xAxis.setLabel("category");

//Defining the y axis
        NumberAxis yAxis = new NumberAxis(0, 100, 5);
        yAxis.setLabel("score");
//Creating the Bar chart
        StackedBarChart<String, Number> barChart = new StackedBarChart<>(xAxis, yAxis);
        barChart.setTitle("Comparison between various cars");

        //Prepare XYChart.Series objects by setting data
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("Speed", 15.0));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.getData().add(new XYChart.Data<>("User rating", 64.0));

        XYChart.Series<String, Number> series3 = new XYChart.Series<>();

        series3.getData().add(new XYChart.Data<>("Mileage", 21.0));

        //Setting the data to bar chart
        barChart.getData().addAll(series1, series2, series3);
        Group root = new Group(barChart);
        Scene scene = new Scene(root, 600, 300);
        Egogram.instance.primaryStage.setScene(scene);
        Egogram.instance.primaryStage.show();
    }

}
