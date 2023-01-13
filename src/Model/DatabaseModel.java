package Fragebogen.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseModel {
    static Connection conn;

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

    public static ObservableList<Question> readQuestions() throws SQLException {

        ObservableList<Question> questionList= FXCollections.observableArrayList();

        int i =4;

            String abfrage = "SELECT * FROM Fragen;";
            Statement statement = conn.createStatement();     //das Statement ist der Inhalt der Verknüpfung zur Datenbank aus "verbindung" und "connection";
            ResultSet resultSetVar = statement.executeQuery(abfrage);  //Ist das Ergebnis aus dem Statement und dem Inhalt von "abfrage";


            while (resultSetVar.next()) {
                int id = resultSetVar.getInt("ID-Frage");
                String frage = resultSetVar.getString("Frage");
                int star = resultSetVar.getInt("Sternchen");

                Question question = new Question(id,frage,star);
                questionList.add(question);


                if (id==i) {
                    System.out.print(id);
                    System.out.print(" ");
                    System.out.print(frage);
                    System.out.print(" ");
                    System.out.println(star);
                }
                //i++;
            }
            return questionList;

    }
}
