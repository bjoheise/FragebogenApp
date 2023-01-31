package Fragebogen.Model;

public class Question {

    int id;
    String question;
    int star;

    public Question(int id, String question, int star) {
        this.id = id;
        this.question = question;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getStar() {
        return star;
    }

}
