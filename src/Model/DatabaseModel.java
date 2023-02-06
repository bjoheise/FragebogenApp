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
            Class.forName("org.sqlite.JDBC");
            // db parameters
            //String url = "jdbc:sqlite/resources/database/FragebogenDB.db";
            // create a connection to the database
            //conn = DriverManager.getConnection(url);
            conn = DriverManager.getConnection("jdbc:sqlite::resource:" + DatabaseModel.class.getResource("/database/FragebogenDB.db").toString());
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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
