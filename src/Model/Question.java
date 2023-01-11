package Fragebogen.Model;

import java.util.Scanner;

public class Question {

    static int sel = 0;
    static int kel = 0;
    static int bw = 0;
    int er = 0;
    int nki = 0;
    int aki = 0;
    static Scanner scanner = new Scanner(System.in);

    public Question(int er, int nki, int aki) {
        this.er = er;
        this.nki = nki;
        this.aki = aki;
    }

    public static int getSel() {
        return sel;
    }

    public static void setSel(int sel) {
        Question.sel = sel;
    }

    public static int getKel() {
        return kel;
    }

    public static void setKel(int kel) {
        Question.kel = kel;
    }

    public static int getBw() {
        return bw;
    }

    public static void setBw(int bw) {
        Question.bw = bw;
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

    public static void berechnung() {

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


        //System.exit(0);

    }

}
