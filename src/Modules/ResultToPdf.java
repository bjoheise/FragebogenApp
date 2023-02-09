package Fragebogen.Modules;

import Fragebogen.Egogram;
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
import javafx.scene.image.WritableImage;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ResultToPdf {

    // Get Systems Temp-Dir
    private static final String TEMP_IMG_DEST = System.getProperty("java.io.tmpdir");

    // Create PNG File to temp dir
    private final File pngFile = new File(TEMP_IMG_DEST);
    private final File pngTemp = File.createTempFile("_egogram", ".png", pngFile);

    public ResultToPdf() throws IOException {
    }

    /**
     * Generates a PDF with a Chart and Answers
     *
     * @param scaleValues  Scale-Values to fill the Chart
     * @param answerValues Answers
     */
    public void manipulatePdf(ArrayList<Integer> scaleValues, ObservableList<String> answerValues, String pseudonym) {

        // Initialize File chooser
        FileChooser fileChooser = new FileChooser();

        // Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName(pseudonym + "-egogramm");
        File pdfDest = fileChooser.showSaveDialog(null);

        try {

            if (pdfDest != null) {

                // Create PDF File
                PdfDocument pdfDoc = new PdfDocument(new PdfWriter(pdfDest));

                // Create Document
                Document doc = new Document(pdfDoc);

                // Set PDF-Font
                PdfFont pdfFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
                pdfDoc.addFont(pdfFont);

                // Create Paragraph with Pseudonym
                Paragraph p = new Paragraph("Pseudonym: " + pseudonym);
                Paragraph pEmpty = new Paragraph("\n");
                // Set Font-Size of List
                p.setFontSize(12);

                // Create List with Answers
                List list = new List(ListNumberingType.DECIMAL);
                for (String answerValue : answerValues) {
                    list.add(answerValue);
                }
                // Set Font-Size of List
                list.setFontSize(12);

                // Generate a PNG of the Egogram to put it into the pdf
                Image img = new Image(this.saveAsPng(scaleValues));

                // Add all elements
                doc.add(p);
                doc.add(pEmpty);
                doc.add(img);
                doc.add(pEmpty);
                doc.add(list);

                // Close the PDF
                doc.close();

                // Delete the Temp Image File
                File tempImage = new File(String.valueOf(pngTemp));
                tempImage.deleteOnExit();

            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    /**
     * Takes a Screenshot of a node without displaying it and saves it as png
     *
     * @param scaleValues Scale-Values to fill the Chart
     * @return ImageData
     * @throws IOException Error Handler
     */
    public ImageData saveAsPng(ArrayList<Integer> scaleValues) throws IOException {

        // Create a line at 30%
        Line line70 = new Line(76.0f, 128.0f, 566.0f, 128.0f);
        // Create a line at 70%
        Line line30 = new Line(76.0f, 246.0f, 566.0f, 246.0f);
        // Create a new Scene without adding it to the Stage
        Scene scene = new Scene(new Group(), 600, 400);

        // Add the Elements to the Scene: Chart and two Lines
        ((Group) scene.getRoot()).getChildren().add(this.buildChart(scaleValues));
        ((Group) scene.getRoot()).getChildren().add(line30);
        ((Group) scene.getRoot()).getChildren().add(line70);

        // Add CSS-File
        scene.getStylesheets().add(Objects.requireNonNull(Egogram.class.getResource("/chart.css")).toExternalForm());

        // Saving the scene as image
        WritableImage image = scene.snapshot(null);

        // Write image to file
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", pngTemp);

        return ImageDataFactory.create(String.valueOf(pngTemp));

    }

    /**
     * @param scaleValues Values for the Chart
     * @return barChart
     */
    public StackedBarChart<String, Number> buildChart(ArrayList<Integer> scaleValues) {

        String criticalAdultMe = "Kritisches\n(auch steuerndes)\nEltern-Ich";
        String supportingAdultMe = "Stützendes\n(auch bemutterndes)\nEltern-Ich";
        String adultMe = "Erwachsenen-\nIch";
        String naturalChildMe = "Natürliches\n(auch egoistisches)\nKind-Ich";
        String adaptiveChildMe = "Angepasstes\n(auch rebellisches)\nKind-Ich";

        // Defining the x-axis
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("");
        xAxis.setCategories(FXCollections.observableArrayList(Arrays.asList(
                        criticalAdultMe,
                        supportingAdultMe,
                        adultMe,
                        naturalChildMe,
                        adaptiveChildMe
                ))
        );

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

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        XYChart.Series<String, Number> series5 = new XYChart.Series<>();

        if (scaleValues.get(0) < 30) {
            series1.getData().add(new XYChart.Data<>(criticalAdultMe, scaleValues.get(0)));
        } else if (scaleValues.get(0) > 30 && scaleValues.get(0) < 70) {
            series1.getData().add(new XYChart.Data<>(criticalAdultMe, 30));
            series1.getData().add(new XYChart.Data<>(criticalAdultMe, scaleValues.get(0) - 30));
        } else {
            series1.getData().add(new XYChart.Data<>(criticalAdultMe, 30));
            series1.getData().add(new XYChart.Data<>(criticalAdultMe, 40));
            series1.getData().add(new XYChart.Data<>(criticalAdultMe, scaleValues.get(0) - 70));
        }

        if (scaleValues.get(1) < 30) {
            series2.getData().add(new XYChart.Data<>(supportingAdultMe, scaleValues.get(1)));
        } else if (scaleValues.get(1) > 30 && scaleValues.get(1) < 70) {
            series2.getData().add(new XYChart.Data<>(supportingAdultMe, 30));
            series2.getData().add(new XYChart.Data<>(supportingAdultMe, scaleValues.get(1) - 30));
        } else {
            series2.getData().add(new XYChart.Data<>(supportingAdultMe, 30));
            series2.getData().add(new XYChart.Data<>(supportingAdultMe, 40));
            series2.getData().add(new XYChart.Data<>(supportingAdultMe, scaleValues.get(1) - 70));
        }

        if (scaleValues.get(2) < 30) {
            series3.getData().add(new XYChart.Data<>(adultMe, scaleValues.get(2)));
        } else if (scaleValues.get(2) > 30 && scaleValues.get(2) < 70) {
            series3.getData().add(new XYChart.Data<>(adultMe, 30));
            series3.getData().add(new XYChart.Data<>(adultMe, scaleValues.get(2) - 30));
        } else {
            series3.getData().add(new XYChart.Data<>(adultMe, 30));
            series3.getData().add(new XYChart.Data<>(adultMe, 40));
            series3.getData().add(new XYChart.Data<>(adultMe, scaleValues.get(2) - 70));
        }

        if (scaleValues.get(3) < 30) {
            series4.getData().add(new XYChart.Data<>(naturalChildMe, scaleValues.get(3)));
        } else if (scaleValues.get(3) > 30 && scaleValues.get(3) < 70) {
            series4.getData().add(new XYChart.Data<>(naturalChildMe, 30));
            series4.getData().add(new XYChart.Data<>(naturalChildMe, scaleValues.get(3) - 30));
        } else {
            series4.getData().add(new XYChart.Data<>(naturalChildMe, 30));
            series4.getData().add(new XYChart.Data<>(naturalChildMe, 40));
            series4.getData().add(new XYChart.Data<>(naturalChildMe, scaleValues.get(3) - 70));
        }

        if (scaleValues.get(4) < 30) {
            series5.getData().add(new XYChart.Data<>(adaptiveChildMe, scaleValues.get(4)));
        } else if (scaleValues.get(4) > 30 && scaleValues.get(4) < 70) {
            series5.getData().add(new XYChart.Data<>(adaptiveChildMe, 30));
            series5.getData().add(new XYChart.Data<>(adaptiveChildMe, scaleValues.get(4) - 30));
        } else {
            series5.getData().add(new XYChart.Data<>(adaptiveChildMe, 30));
            series5.getData().add(new XYChart.Data<>(adaptiveChildMe, 40));
            series5.getData().add(new XYChart.Data<>(adaptiveChildMe, scaleValues.get(4) - 70));
        }

        barChart.getData().add(series1);
        barChart.getData().add(series2);
        barChart.getData().add(series3);
        barChart.getData().add(series4);
        barChart.getData().add(series5);

        // Chart Options
        barChart.setPrefSize(580, 400);

        return barChart;

    }

}
