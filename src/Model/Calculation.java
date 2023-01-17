package Fragebogen.Model;

import java.util.Scanner;
import Fragebogen.Controller.Client.QuestionSceneClientController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;

public class Calculation {

     public static int sel = 0;
     public static int kel = 0;
     public static int bw = 0;
    int er = 0;
    int nki = 0;
    int aki = 0;
    static Scanner scanner = new Scanner(System.in);

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

    // ALGORTHYTHM TEIL 1/3
    public void berechnung() {

        int antwort1, antwort2, antwort3;

        System.out.println("Ich kann gut zuhören. (j=1/n=0)");
        antwort1 = scanner.nextInt();
        System.out.println("Ich neige dazu, in Gruppen tonangebend sein zu wollen. (j=1/n=0)");
        antwort2 = scanner.nextInt();
        System.out.println("Es scheint, dass ich anderen bald einmal widerspreche. (j=1/n=0)");
        antwort3 = scanner.nextInt();

        if (antwort1 == 1) {
            bw++;
        }
        if (antwort2 == 1) {
            bw++;
            kel++;
        }
        if (antwort3 == 1) {
            bw++;
            kel++;
        }

        sel = bw - kel;

        System.out.println("sel =" + sel);
        System.out.println("kel =" + kel);

    }


    public static void algorhythm(ObservableList<Question> questionList, RadioButton yesRadioButton, RadioButton noRadioButton, int counter){


        if(counter > questionList.size()) {
            return;
        }
        int star = questionList.get(counter).getStar();

        if(yesRadioButton.isSelected()){
            Calculation.bw++;

            if(star == 1){
                Calculation.kel++;
            }
            System.out.println("bw:" + Calculation.bw + " kel:" + Calculation.kel);
            Calculation.sel = Calculation.bw -Calculation.kel;
            System.out.println("sel:" + Calculation.sel);
        }

    }







}
