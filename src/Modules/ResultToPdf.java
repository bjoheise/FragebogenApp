package Fragebogen.Modules;

import Fragebogen.Model.Calculation;
import Fragebogen.Model.Question;
import com.itextpdf.io.exceptions.IOException;
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
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.ListNumberingType;
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

    /**
     * @param node
     * @param questionObservableList
     * @throws Exception
     */
    public void generatePdf(Node node, ObservableList<Question> questionObservableList) throws Exception {

        File file = new File(PDF_DEST);
        file.getParentFile().mkdirs();

        this.manipulatePdf(PDF_DEST, node, questionObservableList);

    }

    /**
     * @param dest                   File-Destination
     * @param node                   Node of which the screenshot is taken from
     * @param questionObservableList
     * @throws Exception
     */
    public void manipulatePdf(String dest, Node node, ObservableList<Question> questionObservableList) throws Exception {

        String pseudonym = "Karl";

        // Create File
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        // Create Document
        Document doc = new Document(pdfDoc);

        PdfFont pdfFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        pdfDoc.addFont(pdfFont);

        Paragraph p = new Paragraph("Pseudonym: " + pseudonym);
        p.setFontSize(10);

        List list = new List(ListNumberingType.DECIMAL);

        for (Question question : questionObservableList) {

            String content = question.getFrage() + ": " + question.getStar();

            list.add(content);

        }

        // Generate a PNG of the Egogram to put it into the pdf
        this.saveAsPng(node);
        // Create an ImageData object
        ImageData data = ImageDataFactory.create(TEMP_IMG_DEST);
        Image img = new Image(data);

        // Add the elements
        doc.add(p);
        doc.add(img);
        doc.add(list);

        // Close the PDF
        doc.close();

        // Delete the Temp Image File
        File tempImage = new File(TEMP_IMG_DEST);
        if (tempImage.delete()) {
            System.out.println(tempImage.getName() + " deleted.");
        }

        // Check if the file exists
        File pdfFile = new File(dest);
        if (pdfFile.exists() && !pdfFile.isDirectory()) {

            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION,
                    "Datei exportiert",
                    ButtonType.OK
            );

            // Display the Alert-Popup
            alert.showAndWait();

        } else {

            Alert alert = new Alert(
                    Alert.AlertType.ERROR,
                    "Fehler!",
                    ButtonType.OK
            );

            // Display the Alert-Popup
            alert.showAndWait();

        }

    }

    /**
     * Takes a Screenshot of a node and saves it as png
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

        // Refinement: Try without saving the image:
//        WritableImage image = node.snapshot(new SnapshotParameters(), null);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try {
//            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", baos);
//        }
//        catch (IOException e) {
//            //bla
//        } catch (java.io.IOException e) {
//            throw new RuntimeException(e);
//        }
//        byte pgnBytes [] = baos.toByteArray();
//        Base64.Encoder base64_enc = Base64.getEncoder();
//        String base64_image = base64_enc.encodeToString(pgnBytes);
//        byte[] data = Base64.decodeBase64(base64_image);
//        Image image2 = new Image(ImageDataFactory.create(data));


    }

    public void getPdfBw() {

    }

}
