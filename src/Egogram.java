package Fragebogen;

import Fragebogen.Model.Question;
import Fragebogen.Model.DatabaseModel;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Egogram extends Application {

    public static Egogram instance;

    Stage primaryStage;

    BorderPane rootLayout;

    public static void run(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

//        DatabaseModel.connect();
//        Question.berechnung();

        this.primaryStage = primaryStage;
        instance = this;

        primaryStage.setTitle("Egogram");
        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);
        primaryStage.setResizable(false);

        initRootLayout();

    }

    private void initRootLayout() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/Fragebogen/src/View/MainScene.fxml"));

        rootLayout = fxmlLoader.load();
        Scene primaryScene = new Scene(rootLayout);
        primaryStage.setScene(primaryScene);

    }

    private void loadScene(String sceneToLoad) throws IOException {

        rootLayout.getChildren().remove(rootLayout.getCenter());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fragebogen/src/View/" + sceneToLoad));

    }

}
