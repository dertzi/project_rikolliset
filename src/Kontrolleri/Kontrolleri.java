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
            "4. Poliisit", "5. Placeholder", "6. Lopeta simulaatio"};
        String arrayInString = Arrays.toString(valikko);
        String finalArray = arrayInString.replace(",", " | ");
        String finalArray1 = finalArray.replace("]", "");
        String finalArray2 = finalArray1.replace("[", "");

        /* Simulaation aloitusteksti */
        UI.Näytä("Tervetuloa |> RIKOLLISET <| simulaatiopeliin");
        UI.Näytä("\nTämä simulaatio simuloi rikollismaailman elämää." + "\nSimulaation käyttäjänä pääset ohjaamaan rikollisjengin ryöstöjä ja\n"
                + "hankkeita tielläsi alamaailman huipulle pahamaineisinpana rikollisorganisaation johtajana.");
        
        // FIX: muutetaan tämä booleaniks ja katsotaan jatketaanko luuppia jos true/false
        int i = 0;
         
        // FIX: kyllä/ei tilanne turha? "paina enter aloittaaksesi".
        // hoidetaan pelin lopettaminen valikon kautta.
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
            // FIX: LueInt metodilla ei ole syötteen virheentarkistusta.
            // Joko LueInt pitää korjata tai sitten käytetään vain lueString ja
            // arvoina "1", "2" jne. Tällä tavalla ei tarvitse pelätä että ohjelma
            // kaatuu virheelliseen syötteeseen. switch default palauttaa siis "virheellinen syöttö".
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
//                    UI.Näytä("\nRikolliset:\n");
//                    for (int j = 0; j < rikolliset.getRikollisetInt(); j++) {
//                        UI.Näytä(rikolliset.getRikolliset(j));
//                    }
                    break;
                case 3:
                    // Kauppa, päivittyy jokaisella kerralla uuteen valikoimaan random arvoilla
                    // myös poistaa rikollisen kaupan listalta, mikäli käyttäjä ostaa rikollisen
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
                        // Tarkistetaan, että käyttäjällä on tarpeeksi rahaa oston tekemiseen
//                        if (kauppaSessio == 0 && rikolliset.getRaha() >= kauppa.jäsenArvo(syöte)) {
//                            rikolliset.lisääJäsen(kauppa.getJäsen(syöte));
//                            rikolliset.setRaha(rikolliset.getRaha() - kauppa.jäsenArvo(syöte));
//                            kauppa.poistaJäsenValikoimasta(syöte);
//                        } else if (kauppaSessio == 0 && rikolliset.getRaha() < kauppa.jäsenArvo(syöte)) {
//                            UI.Näytä("Ei riittävästi varaa");
//                        }
//                        UI.Näytä("Maine: " + rikolliset.getMaine() + "\nRahat: " + rikolliset.getRaha() + "\n------------\n");
//                    }
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
// Tässä MALLIKAUPPA! tämän pitäisi toimia täysin. Hyvin yksinkertainen. Vaatii muutaman tarkistuksen lisää
// Koska korjasin kaikki edellisen viikon puuteet takaisin ja poistin ylimääräiset koodit, nykyinen kauppa ei enää toimi!
// Katso tästä mallia miten luot kaupan kontrolleriin tai sitten voin hoitaa sen itse.
/**
        Rikolliset jengi = new Rikolliset();
        Kauppa kauppa = new Kauppa();
        Scanner lukija = new Scanner(System.in);

        while (true) {
            System.out.println(kauppa);
            System.out.print("Osta rikollinen nro: ");
            int syöte = lukija.nextInt();
            if (jengi.getRaha() >= kauppa.ostaRikollinen(syöte).getArvo()) {
                jengi.lisääJäsen(kauppa.ostaRikollinen(syöte));
                jengi.setRaha(jengi.getRaha() - kauppa.ostaRikollinen(syöte).getArvo());
                kauppa.päivitäValikoima();
            } else {
                System.out.println("Ei riittävästi varaa");
            }
            System.out.println("Maine: " + jengi.getMaine() + "\nCP: " + jengi.getCombatPower() + "\nRahat: " + jengi.getRaha() + "\n------------\n");
        }

 */