package Fragebogen.Controller.Coach;

import Fragebogen.Egogram;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ResultGraphSceneController {

    // Loads the Root-Scene with a <BorderPane> XML-Tag
    final static String austria = "Kritisch";
    final static String brazil = "Stützend";
    final static String france = "Erwachsen";
    final static String italy = "Natürlich";
    final static String usa = "Angepasst";
    public StackedBarChart bc;

    public void initialize() {

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        bc.setTitle("Egogramm");

        xAxis.setLabel("Anteil");
        yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();
//            series1.setName("2003");
        series1.getData().add(new XYChart.Data(austria, 50));

        XYChart.Series series2 = new XYChart.Series();
//            series2.setName("2004");
        series2.getData().add(new XYChart.Data(brazil, 70));

        XYChart.Series series3 = new XYChart.Series();
//            series3.setName("2005");
        series3.getData().add(new XYChart.Data(france, 30));

        XYChart.Series series4 = new XYChart.Series();
//            series3.setName("2005");
        series4.getData().add(new XYChart.Data(italy, 15));

        XYChart.Series series5 = new XYChart.Series();
//            series3.setName("2005");
        series5.getData().add(new XYChart.Data(usa, 20));

        bc.getData().addAll(series1, series2, series3, series4, series5);

    }

}
