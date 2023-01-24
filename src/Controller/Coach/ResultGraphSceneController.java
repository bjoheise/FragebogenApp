package Fragebogen.Controller.Coach;

import Fragebogen.Egogram;
import Fragebogen.Model.Calculation;
import Fragebogen.Modules.ResultToPdf;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class ResultGraphSceneController {

    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Egogram.instance.loadScene("Coach/IntroSceneCoach.fxml");
    }

    public void onButtonExportClick(ActionEvent actionEvent) throws Exception {

        // Get the scales
        ArrayList<Integer> skala = Calculation.skala();

        // Generate PDF
        ResultToPdf resultToPdf = new ResultToPdf();
        resultToPdf.manipulatePdf(skala);

    }

}
