package Fragebogen.Model;

public class Question {


    int id;
    String frage;
    int star;



    public Question(int id, String frage, int star) {
        this.id = id;
        this.frage = frage;
        this.star = star;
    }

    public int getId(int i) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

}
