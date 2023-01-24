package Fragebogen.Modules;

import Fragebogen.Model.Calculation;
import Fragebogen.Model.Question;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.ListNumberingType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.*;
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ResultToPdf {

    private Line valueMarker = new Line();

    public static final String PDF_DEST = "./target/egogram-export.pdf";
    public static final String TEMP_IMG_DEST = "./target/egogram.png";

    public void manipulatePdf(ArrayList<Integer> scaleValues) throws Exception {

        String pseudonym = "Karl";

        // Create File
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(PDF_DEST));
        // Create Document
        Document doc = new Document(pdfDoc);

        PdfFont pdfFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        pdfDoc.addFont(pdfFont);

        Paragraph p = new Paragraph("Pseudonym: " + pseudonym);
        p.setFontSize(10);

        List list = new List(ListNumberingType.DECIMAL);

        // for (Question question : scaleValues) {
        //
        //     String content = question.getFrage() + ": " + question.getStar();
        //
        //     list.add(content);
        //
        // }

        // Generate a PNG of the Egogram to put it into the pdf
        this.saveAsPng(scaleValues);
        ImageData data = ImageDataFactory.create(TEMP_IMG_DEST);
        Image img = new Image(data);

        // Add the elements
        doc.add(p);
        doc.add(img);
        doc.add(list);

        // Close the PDF
        doc.close();

        // Delete the Temp Image File
        // File tempImage = new File(TEMP_IMG_DEST);
        // if (tempImage.delete()) {
        //     System.out.println(tempImage.getName() + " deleted.");
        // }

        // Check if the file exists
//        File pdfFile = new File(PDF_DEST);
//
//        if (pdfFile.exists() && !pdfFile.isDirectory()) {
//
//            Alert alert = new Alert(
//                    Alert.AlertType.CONFIRMATION,
//                    "Datei exportiert",
//                    ButtonType.OK
//            );
//
//            // Display the Alert-Popup
//            alert.showAndWait();
//
//        } else {
//
//            Alert alert = new Alert(
//                    Alert.AlertType.ERROR,
//                    "Fehler!",
//                    ButtonType.OK
//            );
//
//            // Display the Alert-Popup
//            alert.showAndWait();
//
//        }

    }

    /**
     * Takes a Screenshot of a node and saves it as png
     */
    public void saveAsPng(ArrayList<Integer> scaleValues) throws IOException {

        File file = new File(TEMP_IMG_DEST);

        // create a line at 30%
        Line line70 = new Line(76.0f, 130.0f, 567.0f, 130.0f);
        // create a line at 70%
        Line line30 = new Line(76.0f, 251.0f, 567.0f, 251.0f);

        Scene scene = new Scene(new Group(), 600, 400);

        ((Group) scene.getRoot()).getChildren().add(this.buildChart());
        ((Group) scene.getRoot()).getChildren().add(line30);
        ((Group) scene.getRoot()).getChildren().add(line70);

        // Saving the scene as image
        WritableImage image = scene.snapshot(null);
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);

        System.out.println("Image Saved");

    }

    /**
     * @return barChart
     */
    public StackedBarChart<String, Number> buildChart() {

        // @TODO: Get Values on buttonFinishClick
        // Values
        ArrayList<Integer> test = Calculation.skala();

        int test2[] = {12, 30, 25, 3, 65};

        // Defining the x-axis
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Kategorie");

        // Defining the y-axis
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Score");
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);
        yAxis.setTickUnit(10);
        yAxis.setTickLength(20);
        yAxis.setMinorTickCount(5);

        // Creating the Bar chart
        StackedBarChart<String, Number> barChart = new StackedBarChart<>(xAxis, yAxis);

        barChart.setTitle("Egogramm");
        barChart.setAnimated(false);
        barChart.setLegendVisible(false);

        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
                ("1", "2", "3", "4", "5"))
        );

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        XYChart.Series<String, Number> series5 = new XYChart.Series<>();


        series1.getData().add(new XYChart.Data<String, Number>("1", 30));
        series1.getData().add(new XYChart.Data<String, Number>("1", 40));
        series1.getData().add(new XYChart.Data<String, Number>("1", 25));

        series2.getData().add(new XYChart.Data<String, Number>("2", 32));
        series2.getData().add(new XYChart.Data<String, Number>("2", 78));

        series3.getData().add(new XYChart.Data<String, Number>("3", 45));
        series4.getData().add(new XYChart.Data<String, Number>("4", 12));
        series5.getData().add(new XYChart.Data<String, Number>("5", 34));


        barChart.getData().addAll(series1, series2, series3, series4, series5);


        //
        Node n1 = barChart.lookup(".data0.chart-bar");
        n1.setStyle("-fx-bar-fill: red");
        Node n2 = barChart.lookup(".data1.chart-bar");
        n2.setStyle("-fx-bar-fill: blue");
        Node n3 = barChart.lookup(".data2.chart-bar");
        n3.setStyle("-fx-bar-fill: yellow");


//        if (series1.getYValue().intValue() > 8) {
//            node.setStyle("-fx-bar-fill: -fx-exceeded;");
//        } else if (data.getYValue().intValue() > 5) {
//            node.setStyle("-fx-bar-fill: -fx-achieved;");
//        } else {
//            node.setStyle("-fx-bar-fill: -fx-not-achieved;");
//        }


        barChart.setPrefSize(580, 400);
        //


        return barChart;

    }

}
