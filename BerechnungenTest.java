package Fragebogen;

import java.util.Scanner;

import static Fragebogen.Model.DatabaseModel.connect;

public class BerechnungenTest {

    static int sel = 0;
    static int kel = 0;
    static int bw = 0;
    int er = 0;
    int nki = 0;
    int aki = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        connect();
        berechnung();

    }

    public static void berechnung(){

        int antwort1, antwort2, antwort3;

        System.out.println("Ich kann gut zuhören. (j=1/n=0)");
        antwort1 = scanner.nextInt();
        System.out.println("Ich neige dazu, in Gruppen tonangebend sein zu wollen. (j=1/n=0)");
        antwort2 = scanner.nextInt();
        System.out.println("Es scheint, dass ich anderen bald einmal widerspreche. (j=1/n=0)");
        antwort3 = scanner.nextInt();

        if (antwort1==1){
            bw++;
        }
        if (antwort2==1){
            bw++;
            kel++;
        }
        if (antwort3==1){
            bw++;
            kel++;
        }

        sel=bw-kel;

        System.out.println("sel =" + sel);
        System.out.println("kel =" + kel);

    }


}
