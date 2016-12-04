/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontrolleri;

import java.util.Arrays;
import java.util.Scanner;
import Käyttöliittymä.Käyttöliittymä;
import model.Rikollinen;

/**
 *
 * @author andred
 */
public class Kontrolleri {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Käyttöliittymä UI = new Käyttöliittymä();
        for (int i = 0; i < 10; i++) {
            Rikollinen rikollinen_i = new Rikollinen();
        }

        final String[] valikko = {"Vaihtoehdot", "1. Kohteet", "2. Rikollisjengin jäsenet", "3. Rikollisjengin statsit",
            "4. Välinevarasto", "5. Placeholder", "6. Placeholder"};
        String arrayInString = Arrays.toString(valikko);
        String finalArray = arrayInString.replace(",", " | ");
        String finalArray1 = finalArray.replace("]", "");
        String finalArray2 = finalArray1.replace("[", "");

        UI.Näytä("Tervetuloa rikolliset simulaatiopeliin");
        UI.Näytä("\nTämä simulaatio on diibadaaba...");
        int i = 0;
        UI.Näytä("\nAloitetaanko simulaatio? (k/e)\n");
        String valinta = lukija.next();
        if (valinta.equals("k") | valinta.equals("K")) {
            UI.Näytä("Hienoa, lähdetään liikeelle.");

        } else {
            int j = 0;
            do {
                UI.Näytä("\nVirheellinen syöte");
                UI.Näytä("\nAloitetaanko simulaatio? (k/e)\n");
                String syöte = lukija.next();
                if (syöte.equals("k") | syöte.equals("K")) {
                    j = 1;
                }
            } while (j == 0);

        }
        do {
            UI.Näytä(finalArray2);
            UI.Näytä("Valinta: ");
            int valinta2 = lukija.nextInt();
            switch (valinta2) {
                case 1:
                    UI.Näytä("Tämä tulostaisi listan kohteista");
                    break;
                case 2:
                    UI.Näytä("Tämä tulostaisi pelaajan rikollisjengin jäsenet, "
                            + " ja jotain tietoa jäsenistä (Special abilities tjms)");
                    break;
                case 3:
                        break;
                case 4:
                    UI.Näytä("Tämä tulostaisi välinevaraston saldo (eli mitä on varastossa"
                            + " ja mihin hintaan");
                    break;
                case 0:
                    UI.Näytä("Jepa");
                    break;

            }
        } while (i == 0);
    }
}
