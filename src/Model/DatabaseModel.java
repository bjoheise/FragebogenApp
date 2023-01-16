package Fragebogen.Model;

import Fragebogen.Egogram;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.*;

public class DatabaseModel {
    static Connection conn;

    public static int id;
    public static String frage;
    public static int star;
    public static String frage1;
    public static int i = 1;
    public static Label labelQuestion;

    public static void connect() {

        try {
            // db parameters
            String url = "jdbc:sqlite:src/DB/FragebogenDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ObservableList<Question> questionList= FXCollections.observableArrayList();
    public static ObservableList<Question> readQuestions() throws SQLException {

        DatabaseModel.connect();


            String abfrage = "SELECT * FROM Fragen;";
            Statement statement = conn.createStatement();     //das Statement ist der Inhalt der Verknüpfung zur Datenbank aus "verbindung" und "connection";
            ResultSet resultSetVar = statement.executeQuery(abfrage);  //Ist das Ergebnis aus dem Statement und dem Inhalt von "abfrage";


            while (resultSetVar.next()) {
                id = resultSetVar.getInt("ID-Frage");
                frage = resultSetVar.getString("Frage");
                star = resultSetVar.getInt("Sternchen");

                Question question = new Question(id,frage,star);
                questionList.add(question);
                if (id==i) {
                    frage1=frage;
                }

            }
            return questionList;

    }




}
