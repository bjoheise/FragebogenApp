package Fragebogen.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Fragebogen.Controller.Client.QuestionSceneClientController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import static Fragebogen.Model.DatabaseModel.id;

public class Calculation {

    public static int sel = 0;
    public static int kel = 0;
    public static int bw = 0;
    public static int er = 0;
    public static int nki = 0;
    public static int aki = 0;
    public static int jw = 0;
    public static int scalekel = 0;
    public static int scalesel = 0;
    public static int scaleer = 0;
    public static int scalenki = 0;
    public static int scaleaki = 0;
    static Scanner scanner = new Scanner(System.in);

    public static ObservableList<String> answerList= FXCollections.observableArrayList();

    public Calculation(int er, int nki, int aki) {
        this.er = er;
        this.nki = nki;
        this.aki = aki;
    }

    public static int getSel() {
        return sel;
    }

    public static void setSel(int sel) {
        Calculation.sel = sel;
    }

    public static int getKel() {
        return kel;
    }

    public static void setKel(int kel) {
        Calculation.kel = kel;
    }

    public static int getBw() {
        return bw;
    }

    public static void setBw(int bw) {
        Calculation.bw = bw;
    }

    public int getEr() {
        return er;
    }

    public void setEr(int er) {
        this.er = er;
    }

    public int getNki() {
        return nki;
    }

    public void setNki(int nki) {
        this.nki = nki;
    }

    public int getAki() {
        return aki;
    }

    public void setAki(int aki) {
        this.aki = aki;
    }

    /** ALGORTHYTHM TEIL 1+2+3 **/

    public static void algorhythm(ObservableList<Question> questionList, RadioButton yesRadioButton, RadioButton noRadioButton, int counter) {


        if (counter > questionList.size()) {
            return;
        }

        int star = questionList.get(counter).getStar();

        if (counter < 60) {

            if (yesRadioButton.isSelected()) {
                Calculation.bw++;

                if (star == 1) {
                    Calculation.kel++;
                }
                System.out.println("bw:" + Calculation.bw + " kel:" + Calculation.kel);
                Calculation.sel = Calculation.bw - Calculation.kel;
                System.out.println("sel:" + Calculation.sel);
            }
        } else if (counter < 104) {
            if (yesRadioButton.isSelected()) {
                Calculation.er++;
                System.out.println("er:" + Calculation.er);
            }
        } else {
            if (yesRadioButton.isSelected()) {
                Calculation.jw++;

                if (star == 1) {
                    Calculation.nki++;
                }
                System.out.println("jw:" + Calculation.jw + " nki:" + Calculation.nki);
                Calculation.aki = Calculation.jw - Calculation.nki;
                System.out.println("aki:" + Calculation.aki);
            }
        }

    }

    /**
     * Umwandlung der Rohwerte in Skalenwerte
     *
     * @return
     **/
    public static ArrayList<Integer> skala() {

        ArrayList<Integer> scaleValues = new ArrayList<>();

        switch (kel) {
            case 1:
                scalekel = 0;
                break;
            case 2:
                scalekel = 0;
                break;
            case 3:
                scalekel = 5;
                break;
            case 4:
                scalekel = 8;
                break;
            case 5:
                scalekel = 10;
                break;
            case 6:
                scalekel = 15;
                break;
            case 7:
                scalekel = 20;
                break;
            case 8:
                scalekel = 25;
                break;
            case 9:
                scalekel = 30;
                break;
            case 10:
                scalekel = 35;
                break;
            case 11:
                scalekel = 40;
                break;
            case 12:
                scalekel = 50;
                break;
            case 13:
                scalekel = 55;
                break;
            case 14:
                scalekel = 60;
                break;
            case 15:
                scalekel = 65;
                break;
            case 16:
                scalekel = 70;
                break;
            case 17:
                scalekel = 75;
                break;
            case 18:
                scalekel = 80;
                break;
            case 19:
                scalekel = 85;
                break;
            case 20:
                scalekel = 90;
                break;
            case 21:
                scalekel = 95;
                break;
            default:
                scalekel = 100;
                break;
        }
        switch (sel) {
            case 1:
                scalesel = 0;
                break;
            case 2:
                scalesel = 0;
                break;
            case 3:
                scalesel = 2;
                break;
            case 4:
                scalesel = 3;
                break;
            case 5:
                scalesel = 5;
                break;
            case 6:
                scalesel = 8;
                break;
            case 7:
                scalesel = 10;
                break;
            case 8:
                scalesel = 13;
                break;
            case 9:
                scalesel = 17;
                break;
            case 10:
                scalesel = 20;
                break;
            case 11:
                scalesel = 25;
                break;
            case 12:
                scalesel = 30;
                break;
            case 13:
                scalesel = 35;
                break;
            case 14:
                scalesel = 40;
                break;
            case 15:
                scalesel = 45;
                break;
            case 16:
                scalesel = 50;
                break;
            case 17:
                scalesel = 55;
                break;
            case 18:
                scalesel = 60;
                break;
            case 19:
                scalesel = 65;
                break;
            case 20:
                scalesel = 70;
                break;
            case 21:
                scalesel = 75;
                break;
            case 22:
                scalesel = 80;
                break;
            case 23:
                scalesel = 83;
                break;
            case 24:
                scalesel = 87;
                break;
            case 25:
                scalesel = 90;
                break;
            case 26:
                scalesel = 92;
                break;
            case 27:
                scalesel = 93;
                break;
            case 28:
                scalesel = 95;
                break;
            default:
                scalesel = 100;
                break;
        }
        switch (er) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                scaleer = 0;
                break;
            case 14:
                scaleer = 5;
                break;
            case 15:
                scaleer = 8;
                break;
            case 16:
                scaleer = 10;
                break;
            case 17:
                scaleer = 15;
                break;
            case 18:
                scaleer = 20;
                break;
            case 19:
                scaleer = 23;
                break;
            case 20:
                scaleer = 27;
                break;
            case 21:
                scaleer = 30;
                break;
            case 22:
                scaleer = 35;
                break;
            case 23:
                scaleer = 40;
                break;
            case 24:
                scaleer = 43;
                break;
            case 25:
                scaleer = 47;
                break;
            case 26:
                scaleer = 50;
                break;
            case 27:
                scaleer = 53;
                break;
            case 28:
                scaleer = 57;
                break;
            case 29:
                scaleer = 60;
                break;
            case 30:
                scaleer = 65;
                break;
            case 31:
                scaleer = 70;
                break;
            case 32:
                scaleer = 75;
                break;
            case 33:
                scaleer = 80;
                break;
            case 34:
                scaleer = 83;
                break;
            case 35:
                scaleer = 87;
                break;
            case 36:
                scaleer = 90;
                break;
            case 37:
                scaleer = 93;
                break;
            case 38:
                scaleer = 95;
                break;
            default:
                scaleer = 100;
                break;
        }
        switch (nki) {
            case 1:
                scalenki = 0;
                break;
            case 2:
                scalenki = 5;
                break;
            case 3:
                scalenki = 10;
                break;
            case 4:
                scalenki = 15;
                break;
            case 5:
                scalenki = 20;
                break;
            case 6:
                scalenki = 25;
                break;
            case 7:
                scalenki = 30;
                break;
            case 8:
                scalenki = 40;
                break;
            case 9:
                scalenki = 50;
                break;
            case 10:
                scalenki = 60;
                break;
            case 11:
                scalenki = 65;
                break;
            case 12:
                scalenki = 70;
                break;
            case 13:
                scalenki = 80;
                break;
            case 14:
                scalenki = 85;
                break;
            case 15:
                scalenki = 90;
                break;
            case 16:
                scalenki = 93;
                break;
            case 17:
                scalenki = 95;
                break;
            default:
                scalenki = 100;
                break;
        }
        switch (aki) {
            case 1:
                scaleaki = 0;
                break;
            case 2:
                scaleaki = 5;
                break;
            case 3:
                scaleaki = 10;
                break;
            case 4:
                scaleaki = 15;
                break;
            case 5:
                scaleaki = 20;
                break;
            case 6:
                scaleaki = 25;
                break;
            case 7:
                scaleaki = 30;
                break;
            case 8:
                scaleaki = 40;
                break;
            case 9:
                scaleaki = 50;
                break;
            case 10:
                scaleaki = 60;
                break;
            case 11:
                scaleaki = 65;
                break;
            case 12:
                scaleaki = 70;
                break;
            case 13:
                scaleaki = 80;
                break;
            case 14:
                scaleaki = 85;
                break;
            case 15:
                scaleaki = 90;
                break;
            case 16:
                scaleaki = 93;
                break;
            case 17:
                scaleaki = 95;
                break;
            default:
                scaleaki = 100;
                break;
        }

        scaleValues.add(scalekel);
        scaleValues.add(scalesel);
        scaleValues.add(scaleer);
        scaleValues.add(scalenki);
        scaleValues.add(scaleaki);

        return scaleValues;

    }

    public static ObservableList<String> writeAnswers(ObservableList<Question> questionList, RadioButton yesRadioButton, RadioButton noRadioButton, int counter) throws SQLException {

        // Get questions (readDatabase()
        //DatabaseModel.readQuestions();

        // if yes = getQuestion + " " + Anwer=ja
        if (yesRadioButton.isSelected()) {
            String answer = (questionList.get(counter).getFrage() + " - ja");
            System.out.println(answer);
            answerList.add(answer);

            // else getQuestion + " " + Anwer=nein
        } else {
            String answer = (questionList.get(counter).getFrage() + " - nein");
            System.out.println(answer);
            answerList.add(answer);

        }
        return answerList;
    }

}
