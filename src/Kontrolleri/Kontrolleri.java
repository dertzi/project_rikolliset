/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontrolleri;

import java.util.Arrays;
import java.util.Scanner;
import Käyttöliittymä.Käyttöliittymä;
import model.Kohteet;
import model.KohdeMarketti;
import model.KohdePankki;
import model.KohdeVankila;

/**
 *
 * @author andred
 */
public class Kontrolleri {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Käyttöliittymä UI = new Käyttöliittymä();
        Kohteet kohde = new Kohteet();
        
        /* Kohteiden luonti */
        KohdeMarketti marketti_1 = new KohdeMarketti();
        KohdePankki pankki_1 = new KohdePankki();
        KohdeVankila vankila_1 = new KohdeVankila();
        
        marketti_1.setAll("K-market", "Vartija", 10, 10);
        pankki_1.setAll("Nordea", "Vartija x 2", 20, 20);
        vankila_1.setAll("Vankila", "Vartija x 10", 100, 100);
        
        marketti_1.setList(marketti_1);
        pankki_1.setList(pankki_1);
        vankila_1.setList(vankila_1);
        
        
        /* Monivalintavalikko */
        final String[] valikko = {"Vaihtoehdot", "1. Kohteet", "2. Rikollisjengin jäsenet", "3. Rikollisjengin statsit",
            "4. Välinevarasto", "5. Placeholder", "6. Placeholder"};
        String arrayInString = Arrays.toString(valikko);
        String finalArray = arrayInString.replace(",", " | ");
        String finalArray1 = finalArray.replace("]", "");
        String finalArray2 = finalArray1.replace("[", "");

        /* Simulaation aloitusteksti */
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
        /* Peruslooppi */
        do {
            UI.Näytä(finalArray2);
            UI.Näytä("Valinta: ");
            int valinta2 = lukija.nextInt();
            switch (valinta2) {
                case 1:
                    UI.Näytä("\nKohteet:\n");
                    UI.Näytä(kohde.toString());
                    break;
                case 2:
                    UI.Näytä("Tämä tulostaisi pelaajan rikollisjengin jäsenet, "
                            + " ja jotain tietoa jäsenistä (Special abilities tjms)");
                    break;
                case 3:
                    UI.Näytä("Placeholder");
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
//************************
// Tässä MALLIKOODI Kaupan toiminnalle! Tästä puuttuu kauppa tapahtuman keskeyttäminen!
// ***********************
//
//        Rikkolliset jengi = new Rikkolliset();
//        Kauppa kauppa = new Kauppa();
//        Scanner lukija = new Scanner(System.in);
//
//        while (true) {
//            System.out.println(kauppa);
//            System.out.print("Osta rikollinen nro: ");
//            int syöte = lukija.nextInt();
//            if (jengi.getRaha() >= kauppa.ostaRikollinen(syöte).getArvo()) {
//                jengi.lisääJäsen(kauppa.ostaRikollinen(syöte));
//                jengi.setRaha(jengi.getRaha() - kauppa.ostaRikollinen(syöte).getArvo());
//                kauppa.päivitäValikoima();
//            }
//            else {
//                System.out.println("Ei riittävästi varaa");
//            }
//            System.out.println("Maine: " + jengi.getMaine() + "\nRahat: " + jengi.getRaha() + "\n------------\n");
//        }