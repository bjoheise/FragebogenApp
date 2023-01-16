package Fragebogen;

import Fragebogen.Model.Calculation;
import Fragebogen.Model.Question;
import Fragebogen.Model.DatabaseModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Egogram extends Application {

    public static Egogram instance;

    Stage primaryStage;

    BorderPane rootLayout;

    public static void run(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {

        // Set the Primary-Stage, the Window of the Application
        this.primaryStage = primaryStage;

        // Singleton
        instance = this;

        // Set the parameters for the Window
        primaryStage.setTitle("Egogram");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.setResizable(false);

        // @see initRootLayout()
        initRootLayout();

        // Display the Stage
        primaryStage.show();
      

        DatabaseModel.readQuestions();
        //Calculation.algorhythm();

    }

    /**
     * Initialize Root-Layout
     *
     * @throws IOException
     */
    public void initRootLayout() throws IOException {

        // Instantiate FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader();

        // Loads the Root-Scene with a <BorderPane> XML-Tag
        fxmlLoader.setLocation(getClass().getResource("/Fragebogen/View/MainScene.fxml"));

        rootLayout = fxmlLoader.load();

        // Instantiate the Root-Scene
        Scene primaryScene = new Scene(rootLayout);

        // Set the Root-Scene to the center of the <BorderPane> XML
        primaryStage.setScene(primaryScene);

    }

    /**
     * Loads a new Scene
     *
     * @param sceneToLoad
     * @throws IOException
     */
    public void loadScene(String sceneToLoad) throws IOException {

        // Remove the Center-Scene in the <BorderPane> XML
        rootLayout.getChildren().remove(rootLayout.getCenter());

        // Instantiate FXMLLoader
        FXMLLoader loader = new FXMLLoader();

        // Loads the new Scene (FXML)
        loader.setLocation(getClass().getResource("/Fragebogen/View/" + sceneToLoad));

        // Load the pane, previously initialized in "setLocation"
        Pane pane = loader.load();

        // Set the new Scene to the center of the <BorderPane> XML
        rootLayout.setCenter(pane);
    }
}
