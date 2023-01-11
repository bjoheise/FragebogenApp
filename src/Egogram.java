package Fragebogen;

import Fragebogen.Model.Question;
import javafx.application.Application;
import javafx.stage.Stage;

public class Egogram extends Application {

    public static Egogram instance;

    public static void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Question.berechnung();
    }

}
