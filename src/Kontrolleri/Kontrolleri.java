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
        Kauppa kauppa = new Kauppa();
        Rikolliset rikolliset = new Rikolliset();

        /* Monivalintavalikko */
        // Tarviiko tämän olla näin monimutkainen? :D
        // Miksi simppeli String ei kelpaa?
        final String[] valikko = {"\nToiminta vaihtoehdot", "1. Kohteet", "2. Rikollisisjengin jäsenet", "3. Kauppa",
            "4. Poliisit", "5. Placeholder", "6. Lopeta simulaatio\n"};
        String arrayInString = Arrays.toString(valikko);
        String finalArray = arrayInString.replace(",", " | ");
        String finalArray1 = finalArray.replace("]", "");
        String finalArray2 = finalArray1.replace("[", "");

        /* Simulaation aloitusteksti */
        UI.näytäln("Tervetuloa |> RIKOLLISET <| simulaatiopeliin");
        UI.näytäln("\nTämä simulaatio simuloi rikollismaailman elämää." + "\nSimulaation käyttäjänä pääset ohjaamaan rikollisjengin ryöstöjä ja\n"
                + "hankkeita tielläsi alamaailman huipulle pahamaineisinpana rikollisorganisaation johtajana.");

        // FIX: muutetaan tämä booleaniks ja katsotaan jatketaanko luuppia jos true/false
        int i = 0;

        // FIX: kyllä/ei tilanne turha? "paina enter aloittaaksesi".
        // hoidetaan pelin lopettaminen valikon kautta.
        UI.näytäln("\nAloitetaanko simulaatio? (k/e)");
        String valinta = UI.lueString();

        if (valinta.equals("k") | valinta.equals("K")) {
            UI.näytäln("Hienoa, lähdetään liikeelle.\n");

        } else {
            /* Simulaation aloitus kysymys */
            int j = 0;
            do {
                UI.näytäln("\nVirheellinen syöte");
                UI.näytäln("\nAloitetaanko simulaatio? (k/e)\n");
                String syöte = UI.lueString();
                if (syöte.equals("k") | syöte.equals("K")) {
                    j = 1;
                }
            } while (j == 0);

        }

        /* Peruslooppi */
        do {
            // Tähän voisi vaikka tulla joitain perusstatseja, kuten jäsenien määrä tjms (iha printtinä)
            UI.näytäln(finalArray2);
            UI.näytä("Valinta: ");

            int valinta2 = UI.lueInt();
            switch (valinta2) {
                case 1:
                    // Tulostaa kaikki kohteet
                    UI.näytäln("\nKohteet:\n");
                    UI.näytäln("Marketit\n");
                    for (int j = 0; j < kohde.getMarkettiInt(); j++) {
                        UI.näytäln(j + ". " + kohde.getMarketti(j));
                    }
                    UI.näytäln("\nPankit\n");
                    for (int j = 0; j < kohde.getPankkiInt(); j++) {
                        UI.näytäln(j + ". " + kohde.getPankki(j));
                    }
                    UI.näytäln("\nVankilat\n");
                    for (int j = 0; j < kohde.getVankilaInt(); j++) {
                        UI.näytäln(j + ". " + kohde.getVankila(j));
                    }
                    break;
                case 2:
                    // Tulostaa kaikki "pelaajan" rikollisisjengin jäsenet
//                    UI.Näytä("\nRikolliset:\n");
//                    for (int j = 0; j < rikolliset.getRikollisetInt(); j++) {
//                        UI.Näytä(rikolliset.getRikolliset(j));
//                    }
                    break;
                case 3:
                    // TODO: Lisää tarkistus maksimi arvolle (index out of range!)
                    // Kauppa päivittyy kun yksi rikollinen on ostettu.
                    UI.näytäln(kauppa);
                    UI.näytäln("Kenet tahdot ostaa? (Poistu: 0)");
                    UI.näytä("Valinta: ");
                    // FIX: Tähän tarvitsee virheen tarkistuksen siltä varalta että syöttää korkean arvon tai muuta kuin kokonaislukuja!
                    int syöte = UI.lueInt();
                    if (syöte == 0) {
                        break;
                    }
                    
                    if (syöte < 1 && syöte > kauppa.getVALIKOIMAN_KOKO()) {
                        UI.näytäln("Virheellinen valinta!");
                    } else if (rikolliset.getRaha() >= kauppa.ostaRikollinen(syöte).getArvo()) {
                        rikolliset.lisääJäsen(kauppa.ostaRikollinen(syöte));
                        rikolliset.setRaha(rikolliset.getRaha() - kauppa.ostaRikollinen(syöte).getArvo());
                        kauppa.päivitäValikoima();
                    } else {
                        UI.näytäln("Ei riittävästi varaa");
                    }
                    
                    // Testi tulostus
                    System.out.println("Maine: " + rikolliset.getMaine() + "\nCP: " + rikolliset.getCombatPower() + "\nRahat: " + rikolliset.getRaha() + "\n------------\n");
                    // Kauppa, päivittyy jokaisella kerralla uuteen valikoimaan random arvoilla
                    // myös poistaa rikollisen kaupan listalta, mikäli käyttäjä ostaa rikollisen <--- miksi poistaa rikollinen listalta jos se tyhjennetään kuitenkin?
                    // kuitenkin päivittyy uusi lista kun käyttäjä lähtee kaupasta ja tulee takaisin
//                    kauppa.päivitäValikoima();
//                    int kauppaSessio = 0;
//                    while (kauppaSessio == 0) {
//                        for (int j = 0; j < kauppa.getValikoimanKoko(); j++) {
//                            UI.Näytä(kauppa.toString(j));
//                        }
//                        UI.Näytä("[Syötteellä '0' pääsee ulos kaupasta]");
//                        UI.Näytä("\nOsta rikollinen nro: ");
//                        int syöte = UI.LueInt();
//                        if (syöte < 1 || syöte > kauppa.getValikoimanKoko()) {
//                            if (syöte == 0) {
//                                kauppaSessio = 1;
//                                UI.Näytä("\nLähdit kaupasta.\n");
//                            } else {
//                                UI.Näytä("\nVirheellinen syöttöarvo\n");
//                            }
//                        }
                    break;
                case 4:
                    UI.näytäln("Placeholder");
                    break;
                case 0:
                    UI.näytäln("For testing purposes.");
                    break;

            }
        } while (i == 0);
    }
}
