/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontrolleri;

import java.util.Arrays;
import Käyttöliittymä.Käyttöliittymä;
import model.Kohteet;
import model.Rikolliset;

/**
 *
 * @author andred
 */
public class Kontrolleri {

    public static void main(String[] args) {
        Käyttöliittymä UI = new Käyttöliittymä();
        Kohteet kohde = new Kohteet();
        Rikolliset rikolliset = new Rikolliset();

        /* Monivalintavalikko */
        final String[] valikko = {"\nToiminta vaihtoehdot", "1. Kohteet", "2. Rikolliset", "3. Kauppa",
            "4. Placeholder", "5. Placeholder", "6. Placeholder"};
        String arrayInString = Arrays.toString(valikko);
        String finalArray = arrayInString.replace(",", " | ");
        String finalArray1 = finalArray.replace("]", "");
        String finalArray2 = finalArray1.replace("[", "");

        /* Simulaation aloitusteksti */
        UI.Näytä("Tervetuloa rikolliset simulaatiopeliin");
        UI.Näytä("\nTämä simulaatio simuloi rikollismaailman elämää." + "\nSimulaation käyttäjänä pääset ohjaamaan rikollisjengin ryöstöjä ja\n"
                + "hankkeita tielläsi alamaailman huipulle pahamaineisimpana rikollisorganisaation johtajana.");
        int i = 0;
        UI.Näytä("\nAloitetaanko simulaatio? (k/e)");
        String valinta = UI.LueString();
        if (valinta.equals("k") | valinta.equals("K")) {
            UI.Näytä("Hienoa, lähdetään liikeelle.\n");

        } else {
            /* Simulaation aloitus kysymys */
            int j = 0;
            do {
                UI.Näytä("\nVirheellinen syöte");
                UI.Näytä("\nAloitetaanko simulaatio? (k/e)\n");
                String syöte = UI.LueString();
                if (syöte.equals("k") | syöte.equals("K")) {
                    j = 1;
                }
            } while (j == 0);

        }
        /* Peruslooppi */
        do {
            UI.Näytä(finalArray2);
            UI.Näytä("Valinta: ");
            int valinta2 = UI.LueInt();
            switch (valinta2) {
                case 1:
                    // Tulostaa kaikki kohteet
                    UI.Näytä("\nKohteet:\n");
                    UI.Näytä("Marketit\n");
                    for (int j = 0; j < kohde.getMarkettiInt(); j++) {
                        UI.Näytä(kohde.getMarketti(j));
                    }
                    UI.Näytä("\nPankit\n");
                    for (int j = 0; j < kohde.getPankkiInt(); j++) {
                        UI.Näytä(kohde.getPankki(j));
                    }
                    UI.Näytä("\nVankilat\n");
                    for (int j = 0; j < kohde.getVankilaInt(); j++) {
                        UI.Näytä(kohde.getVankila(j));
                    }
                    break;
                case 2:
                    // Tulostaa kaikki rikolliset
                    UI.Näytä("\nRikolliset:\n");
                    String nullString = "null";
                    for (int j = 0; j < rikolliset.getRikollisetInt(); j++) {
                        if (rikolliset.getRikolliset(j).contains(nullString)) {
                            String fixedString = rikolliset.getRikolliset(j).replaceAll("null", "Ei erityisosaamista");
                            UI.Näytä(fixedString);
                        } else {
                            UI.Näytä(rikolliset.getRikolliset(j));
                        }
                    }
                    break;
                case 3:
                    UI.Näytä("Placeholder");
                    break;
                case 4:
                    UI.Näytä("Placeholder");
                    break;
                case 0:
                    UI.Näytä("For testing purposes.");
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
