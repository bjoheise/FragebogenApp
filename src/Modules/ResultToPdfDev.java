package Fragebogen.Modules;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.draw.ILineDrawer;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;

public class ResultToPdfDev {

    public static final String DEST = "./target/sandbox/tables/simple_table.pdf";

    public void generatePdf() throws Exception {

//        FileChooser fileChooser = new FileChooser();
//
//        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF-Dokument", "*.pdf"));
//
//        fileChooser.showSaveDialog(null);
//
//        System.out.println(fileChooser.getTitle());

        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new ResultToPdfDev().manipulatePdf(DEST);

    }

    public void manipulatePdf(String dest) throws Exception {

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdfDoc);

//        Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();
//
//        for (int i = 0; i < 16; i++) {
//            table.addCell("hi");
//        }
//
//        doc.add(table);

        Rectangle pageSize = pdfDoc.getDefaultPageSize();
        float width = pageSize.getWidth() - document.getLeftMargin() - document.getRightMargin();

        SolidLine line = new SolidLine();
        addParagraphWithTabs(document, line, width);

        // Draw a custom line to fill both sides, as it is described in iText5 example
        MyLine customLine = new MyLine();
        addParagraphWithTabs(document, customLine, width);

        document.close();

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
                    ButtonType.OK
            );

            // Display the Alert-Popup
            alert.showAndWait();

        }


    }


    private static void addParagraphWithTabs(Document document, ILineDrawer line, float width) {

//        List<TabStop> tabStops = new ArrayList<>();
//
//        // Create a TabStop at the middle of the page
//        tabStops.add(new TabStop(width / 2, TabAlignment.CENTER, line));
//
//        // Create a TabStop at the end of the page
//        tabStops.add(new TabStop(width, TabAlignment.LEFT, line));
//
//        Paragraph p = new Paragraph().addTabStops(tabStops);
//        p
//                .add(new Tab())
//                .add("Text in the middle")
//                .add(new Tab());

        Paragraph p = new Paragraph();
        p.add("Egogramm");
        document.add(p);
    }

    private static class MyLine implements ILineDrawer {
        private float lineWidth = 1;
        private float offset = 2.02f;
        private Color color = ColorConstants.BLACK;

        @Override
        public void draw(PdfCanvas canvas, Rectangle drawArea) {
            float coordY = drawArea.getY() + lineWidth / 2 + offset;
            canvas
                    .saveState()
                    .setStrokeColor(color)
                    .setLineWidth(lineWidth)
                    .moveTo(drawArea.getX(), coordY)
                    .lineTo(drawArea.getX() + drawArea.getWidth(), coordY)
                    .stroke()
                    .restoreState();
        }

        @Override
        public float getLineWidth() {
            return lineWidth;
        }

        @Override
        public void setLineWidth(float lineWidth) {
            this.lineWidth = lineWidth;
        }

        @Override
        public Color getColor() {
            return color;
        }

        @Override
        public void setColor(Color color) {
            this.color = color;
        }

        public float getOffset() {
            return offset;
        }

        public void setOffset(float offset) {
            this.offset = offset;
        }
    }

}
