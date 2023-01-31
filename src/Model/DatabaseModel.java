package Fragebogen.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseModel {
    static Connection conn;
    public static int id;
    public static String question;
    public static int star;

    public static ObservableList<Question> questionList = FXCollections.observableArrayList();

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

        String sqlQuery = "SELECT * FROM Fragen;";
        Statement statement = conn.createStatement();
        ResultSet resultSetVar = statement.executeQuery(sqlQuery);

        while (resultSetVar.next()) {

            id = resultSetVar.getInt("ID-Frage");
            question = resultSetVar.getString("Frage");
            star = resultSetVar.getInt("Sternchen");

            Question question = new Question(id, DatabaseModel.question, star);
            questionList.add(question);

        }

        return questionList;

    }

}
