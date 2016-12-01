/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;
import controller.Ohjain;

/**
 *
 * @author andred
 */
public class Käyttöliittymä {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        controller.Ohjain ohjain = new controller.Ohjain();

        System.out.println("Tervetuloa rikolliset simulaatiopeliin");
        System.out.println("\nTämä simulaatio on diibadaaba...");
        int i = 0;
        System.out.println("\nAloitetaanko simulaatio? (k/e)\n");
        String valinta = lukija.next();
        if (valinta.equals("k") | valinta.equals("K")) {
            System.out.println("Hienoa, lähdetään liikeelle.");

        } else {
            int j = 0;
            do {
                System.out.println("\nVirheellinen syöte");
                System.out.println("\nAloitetaanko simulaatio? (k/e)\n");
                String syöte = lukija.next();
                if (syöte.equals("k") | syöte.equals("K")) {
                    j = 1;
                }
            } while (j == 0);

        }
        do {
            System.out.println(ohjain.aloitusvalikko());
            System.out.println("Valinta: ");
            int valinta2 = lukija.nextInt();
            switch (valinta2) {
                case 1:
                    System.out.println("Tämä tulostaisi listan kohteista");
                    break;
                case 2:
                    System.out.println("Tämä tulostaisi pelaajan rikollisjengin jäsenet, "
                            + " ja jotain tietoa jäsenistä (Special abilities tjms)");
                    break;
                case 3:
                    System.out.println("Tämä tulostaisi kaikki statsit rikollisjengin jäsenistä");
                    break;
                case 4:
                    System.out.println("Tämä tulostaisi välinevaraston saldo (eli mitä on varastossa"
                            + " ja mihin hintaan");
                    break;
                case 0:
                    System.out.println(ohjain.listPoliisit());
                    break;

            }
        } while (i == 0);
    }
}
