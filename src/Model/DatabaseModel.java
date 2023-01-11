package Fragebogen.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseModel {
    static Connection conn = null;
    public static void connect() {

        try {
            // db parameters
            String url = "jdbc:sqlite:src/DB/FragebogenDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void readQuestions() throws SQLException {

        ObservableList<Question> questionList= FXCollections.observableArrayList();

            String abfrage = "SELECT * FROM Fragen";
            Statement statement = conn.createStatement();     //das Statement ist der Inhalt der Verknüpfung zur Datenbank aus "verbindung" und "connection";
            ResultSet resultSetVar = statement.executeQuery(abfrage);  //Ist das Ergebnis aus dem Statement und dem Inhalt von "abfrage";

            while (resultSetVar.next()) {
                Integer id = resultSetVar.getInt("ID-Frage");
                String frage = resultSetVar.getString("Frage");
                Integer star = resultSetVar.getInt("Sternchen");

                Question question = new Question(id,frage,star);
                questionList.add(question);

            }

    }
}
