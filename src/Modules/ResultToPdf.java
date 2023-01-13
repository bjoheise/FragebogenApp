package Fragebogen.Modules;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.UnitValue;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;

public class ResultToPdf {

    public static final String DEST = "./target/sandbox/tables/simple_table.pdf";

    public void generatePdf() throws Exception {

        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new ResultToPdf().manipulatePdf(DEST);

    }

    public void manipulatePdf(String dest) throws Exception {

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();

        for (int i = 0; i < 16; i++) {
            table.addCell("hi");
        }

        doc.add(table);

        doc.close();

        File pdfFile = new File(dest);

        if (pdfFile.exists() && !pdfFile.isDirectory()) {

            // do something
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

}
