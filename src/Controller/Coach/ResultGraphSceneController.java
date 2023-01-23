package Fragebogen.Controller.Coach;

import Fragebogen.Egogram;
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
import java.util.Arrays;

public class ResultGraphSceneController {

    public Button buttonExport;

    public Stage stage = Egogram.instance.primaryStage;

    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Coach/IntroSceneCoach.fxml");
    }

    public void onButtonExportClick(ActionEvent actionEvent) throws Exception {

        File file = new File("./target/egogram.png");
        file.getParentFile().mkdirs();

        Scene scene = new Scene(new Group(), 600, 400);

        ((Group) scene.getRoot()).getChildren().add(this.buildChart());
        //Saving the scene as image
        WritableImage image = scene.snapshot(null);
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);
        System.out.println("Image Saved");

        // Get the node (StackedBarChart) via ID on Button Click
//        Node node = buttonExport.getParent().lookup("#barChart");
//        Scene scene = buttonExport.getScene();
////        scene.getStylesheets().add("Res/chart.css");
//
//        ObservableList<Question> questionObservableList = DatabaseModel.readQuestions();
//
//        // Instantiate PDF-Generator
//        ResultToPdf resultToPdf = new ResultToPdf();
//        // Call Method to generate PDF
//        resultToPdf.generatePdf(node, questionObservableList);

    }

    public BarChart<String, Number> buildChart() {

        // Defining the x-axis
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Kategorie");

        // Defining the y-axis
        yAxis.setLabel("Score");

        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);

        yAxis.setTickUnit(10);
        yAxis.setTickLength(20);
        yAxis.setMinorTickCount(5);

        // Creating the Bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        barChart.setTitle("Egogramm");

        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
                ("1")));

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
//        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
//        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
//        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
//        XYChart.Series<String, Number> series5 = new XYChart.Series<>();

        series1.getData().add(new XYChart.Data<String, Number>("1", 20));
//        series2.getData().add(new XYChart.Data<String, Number>("3", 45));
//        series3.getData().add(new XYChart.Data<String, Number>("4", 12));
//        series4.getData().add(new XYChart.Data<String, Number>("5", 34));
//        series5.getData().add(new XYChart.Data<String, Number>("1", 78));

        // barChart.getData().addAll(series1, series2, series3, series4, series5);

        barChart.getData().addAll(series1);

        return barChart;

    }

}
