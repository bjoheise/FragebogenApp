package Fragebogen.Modules;

import Fragebogen.Model.Question;
import com.itextpdf.io.exceptions.IOException;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;

import static javafx.embed.swing.SwingFXUtils.fromFXImage;

public class ResultToPdf {

    public static final String PDF_DEST = "./target/egogram-export.pdf";
    public static final String TEMP_IMG_DEST = "./target/egogram.png";

    public void generatePdf(Node node) throws Exception {

        File file = new File(PDF_DEST);
        file.getParentFile().mkdirs();

        this.manipulatePdf(PDF_DEST, node);

    }

    public void manipulatePdf(String dest, Node node) throws Exception {

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        Table table = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();

        ObservableList<Question> observableListQuestion = FXCollections.observableArrayList();

        observableListQuestion.add(new Question(0, "Was sind wir, warum und ... woher", 1));
        observableListQuestion.add(new Question(1, "Wohin und weshalb", 0));
        observableListQuestion.add(new Question(2, "Was sind wir, warum und ... woher", 1));

        for (Question question : observableListQuestion) {

            System.out.println(question.getFrage());
           // System.out.println(question.getId());

            table.addCell(question.getFrage());
            //table.addCell(String.valueOf(question.getId()));

        }

        // Generate a PNG of the Egogram to put it into the pdf
        this.saveAsPng(node);

        // Creating an ImageData object
        ImageData data = ImageDataFactory.create(TEMP_IMG_DEST);
        Image img = new Image(data);

        // Add the elements
        doc.add(img);
        doc.add(table);

        // Close the PDF
        doc.close();

        // Delete the Temp Image File
        File tempImage = new File(TEMP_IMG_DEST);
        if (tempImage.delete()) {
            System.out.println(tempImage.getName() + " deleted.");
        }

        File pdfFile = new File(dest);
        if (pdfFile.exists() && !pdfFile.isDirectory()) {

            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION,
                    "Datei exportiert",
                    ButtonType.OK,
                    ButtonType.CANCEL
            );

            // Display the Alert-Popup
            alert.showAndWait();

        } else {

            Alert alert = new Alert(
                    Alert.AlertType.ERROR,
                    "Fehler!",
                    ButtonType.OK,
                    ButtonType.CANCEL
            );

            // Display the Alert-Popup
            alert.showAndWait();

        }

    }

    /**
     * Takes a Screenshot of a node and saves it to a png
     *
     * @param node
     */
    public void saveAsPng(Node node) {

        // Create file
        File file = new File(TEMP_IMG_DEST);
        // Get the height and width of the selected ID
        Bounds bounds = node.getBoundsInParent();

        // Create Image from the selected ID
        WritableImage writableImage = new WritableImage((int) bounds.getWidth(), (int) bounds.getHeight());

        // Set Snapshot Parameters
        SnapshotParameters params = new SnapshotParameters();
        // Snapshot the Scene
        node.snapshot(params, writableImage);

        // Save the Image
        try {
            ImageIO.write(fromFXImage(writableImage, null), "png", file);
        } catch (IOException | java.io.IOException e) {
            e.printStackTrace();
        }

    }

}
