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
import model.Kauppa;

/**
 *
 * @author andred
 */
public class Kontrolleri {

    public static void main(String[] args) {
        Käyttöliittymä UI = new Käyttöliittymä();
        Kohteet kohde = new Kohteet();
        Rikolliset rikolliset = new Rikolliset();
        Kauppa kauppa = new Kauppa();
        Rikolliset jengi = new Rikolliset();

        /* Monivalintavalikko */
        final String[] valikko = {"\nToiminta vaihtoehdot", "1. Kohteet", "2. Rikollisisjengin jäsenet", "3. Kauppa",
            "4. Poliisit", "5. Placeholder", "6. Placeholder"};
        String arrayInString = Arrays.toString(valikko);
        String finalArray = arrayInString.replace(",", " | ");
        String finalArray1 = finalArray.replace("]", "");
        String finalArray2 = finalArray1.replace("[", "");

        /* Simulaation aloitusteksti */
        UI.Näytä("Tervetuloa |> RIKOLLISET <| simulaatiopeliin");
        UI.Näytä("\nTämä simulaatio simuloi rikollismaailman elämää." + "\nSimulaation käyttäjänä pääset ohjaamaan rikollisjengin ryöstöjä ja\n"
                + "hankkeita tielläsi alamaailman huipulle pahamaineisinpana rikollisorganisaation johtajana.");
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
            // Tähän voisi vaikka tulla joitain perusstatseja, kuten jäsenien määrä tjms (iha printtinä)
            UI.Näytä(finalArray2);
            UI.Näytä("Valinta: ");
            int valinta2 = UI.LueInt();
            switch (valinta2) {
                case 1:
                    // Tulostaa kaikki kohteet
                    UI.Näytä("\nKohteet:\n");
                    UI.Näytä("Marketit\n");
                    for (int j = 0; j < kohde.getMarkettiInt(); j++) {
                        UI.Näytä(j + ". " + kohde.getMarketti(j));
                    }
                    UI.Näytä("\nPankit\n");
                    for (int j = 0; j < kohde.getPankkiInt(); j++) {
                        UI.Näytä(j + ". " + kohde.getPankki(j));
                    }
                    UI.Näytä("\nVankilat\n");
                    for (int j = 0; j < kohde.getVankilaInt(); j++) {
                        UI.Näytä(j + ". " + kohde.getVankila(j));
                    }
                    break;
                case 2:
                    // Tulostaa kaikki "pelaajan" rikollisisjengin jäsenet
                    UI.Näytä("\nRikolliset:\n");
                    for (int j = 0; j < rikolliset.getRikollisetInt(); j++) {
                        UI.Näytä(rikolliset.getRikolliset(j));
                    }
                    break;
                case 3:
                    // Kauppa, päivittyy jokaisella kerralla uuteen valikoimaan random arvoilla
                    // myös poistaa rikollisen kaupan listalta, mikäli käyttäjä ostaa rikollisen
                    // kuitenkin päivittyy uusi lista kun käyttäjä lähtee kaupasta ja tulee takaisin
                    kauppa.päivitäValikoima();
                    int kauppaSessio = 0;
                    while (kauppaSessio == 0) {
                        for (int j = 0; j < kauppa.getValikoimanKoko(); j++) {
                            UI.Näytä(kauppa.toString(j));
                        }
                        UI.Näytä("[Syötteellä '0' pääsee ulos kaupasta]");
                        UI.Näytä("\nOsta rikollinen nro: ");
                        int syöte = UI.LueInt();
                        if (syöte < 1 || syöte > kauppa.getValikoimanKoko()) {
                            if (syöte == 0) {
                                kauppaSessio = 1;
                                UI.Näytä("\nLähdit kaupasta.\n");
                            } else {
                                UI.Näytä("\nVirheellinen syöttöarvo\n");
                            }
                        }
                        // Tarkistetaan, että käyttäjällä on tarpeeksi rahaa oston tekemiseen
                        if (kauppaSessio == 0 && jengi.getRaha() >= kauppa.jäsenArvo(syöte)) {
                            jengi.lisääJäsen(kauppa.getJäsen(syöte));
                            jengi.setRaha(jengi.getRaha() - kauppa.jäsenArvo(syöte));
                            kauppa.poistaJäsenValikoimasta(syöte);
                        } else if (kauppaSessio == 0 && jengi.getRaha() < kauppa.jäsenArvo(syöte)) {
                            UI.Näytä("Ei riittävästi varaa");
                        }
                        UI.Näytä("Maine: " + jengi.getMaine() + "\nRahat: " + jengi.getRaha() + "\n------------\n");
                    }
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
