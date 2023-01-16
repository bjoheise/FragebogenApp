package Fragebogen.Modules;

import Fragebogen.Egogram;
import com.itextpdf.io.exceptions.IOException;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.*;
import java.io.File;
import java.util.List;

public class JavaFXPlotter {

    public void generateChart() {

//        Stage stage = Egogram.instance.start();

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        xAxis.setLabel("Number of Month");
        //creating the chart
        LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));


        lineChart.setAnimated(false);
        lineChart.getData().add(series);

        System.out.println(lineChart);

        WritableImage image = lineChart;
        File file = new File("./target/sandbox/pdf/simple_table.png");
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);


        //        WritableImage image = scene.snapshot(null);
//        File file = new File("./target/sandbox/tables/test.png");
//        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);
//        System.out.println("Image Saved");


        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException | java.io.IOException e) {
            e.printStackTrace();
        }

        System.out.println("After show");
    }

    public static void saveAsPng(Scene scene, String path) {

        WritableImage image = scene.snapshot(null);
        File file = new File(path);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException | java.io.IOException e) {
            e.printStackTrace();
        }


//        WritableImage image = scene.snapshot(null);
//        File file = new File("./target/sandbox/tables/test.png");
//        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);
//        System.out.println("Image Saved");

    }

}