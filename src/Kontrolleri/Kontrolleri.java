package Kontrolleri;

import java.util.Arrays;
import Käyttöliittymä.Käyttöliittymä;
import model.Kohteet;
import model.Rikolliset;
import model.Kauppa;
import model.Rikollinen;

public class Kontrolleri {

    public static void main(String[] args) {
        Käyttöliittymä UI = new Käyttöliittymä();
        Kohteet kohde = new Kohteet();
        Kauppa kauppa = new Kauppa();
        Rikolliset rikolliset = new Rikolliset();
        int syöteInt;
        String syöteString;

        /* Monivalintavalikko */
        // Tarviiko tämän olla näin monimutkainen? :D
        // Miksi simppeli String ei kelpaa?
        final String[] valikko = {"\nToiminta vaihtoehdot", "1. Kohteet", "2. Rikollisjengin tiedot", "3. Kauppa",
            "4. Poliisit", "5. Placeholder", "0. Lopeta simulaatio\n"};
        String arrayInString = Arrays.toString(valikko);
        String finalArray = arrayInString.replace(",", " | ");
        String finalArray1 = finalArray.replace("]", "");
        String finalArray2 = finalArray1.replace("[", "");

        /* Simulaation aloitusteksti */
        UI.näytäln("Tervetuloa |> RIKOLLISET <| simulaatiopeliin");
        UI.näytäln("\nTämä simulaatio simuloi rikollismaailman elämää." + "\nSimulaation käyttäjänä pääset ohjaamaan rikollisjengin ryöstöjä ja\n"
                + "hankkeita tielläsi alamaailman huipulle pahamaineisinpana rikollisorganisaation johtajana.");

        UI.näytäln("\nJatka painamalla enter...");
        UI.lueString();

//        String valinta = UI.lueString();
//
//        if (valinta.equals("k") | valinta.equals("K")) {
//            UI.näytäln("Hienoa, lähdetään liikeelle.\n");
//
//        } else {
//            /* Simulaation aloitus kysymys */
//            int j = 0;
//            do {
//                UI.näytäln("\nVirheellinen syöte");
//                UI.näytäln("\nAloitetaanko simulaatio? (k/e)\n");
//                String syöte = UI.lueString();
//                if (syöte.equals("k") | syöte.equals("K")) {
//                    j = 1;
//                }
//            } while (j == 0);
//
//        }
        // FIX: muutetaan tämä booleaniks ja katsotaan jatketaanko luuppia jos true/false
        boolean lopetaSimulaatio = false;

        /* Peruslooppi */
        do {
            // Tähän voisi vaikka tulla joitain perusstatseja, kuten jäsenien määrä tjms (iha printtinä)
            UI.näytäln(finalArray2);
            UI.näytä("Valinta: ");

            syöteInt = UI.lueInt();
            switch (syöteInt) {
                // Tulostaa valikon pääkohteista
                case 1:
                    UI.näytäln("1. Pankit | 2. Marketit | 3. Vankilat");
                    UI.näytä("Valinta: ");
                    syöteInt = UI.lueInt();
                    switch (syöteInt) {
                        // Tulostaa marketti kohteet
                        case 1:
                            UI.näytäln("Marketit\n");
                            for (int i = 0; i < kohde.getMarkettiInt(); i++) {
                                UI.näytäln((i + 1) + ". " + kohde.getMarketti(i));
                            }
                            UI.näytä("Valinta: ");
                            break;
                        // Tulostaa pankki kohteet
                        case 2:
                            UI.näytäln("\nPankit\n");
                            for (int i = 0; i < kohde.getPankkiInt(); i++) {
                                UI.näytäln((i + 1) + ". " + kohde.getPankki(i));
                            }
                            break;
                        // Tulostaa vankila kohteet
                        case 3:
                            UI.näytäln("\nVankilat\n");
                            for (int i = 0; i < kohde.getVankilaInt(); i++) {
                                UI.näytäln((i + 1) + ". " + kohde.getVankila(i));
                            }
                            break;
                        case 0:
                            break;
                        default:
                            UI.näytäln("Kohdetta ei löytynyt.");
                            break;
                    }
                    // Tulostaa kaikki kohteet
                    UI.näytäln("\nKohteet:\n");
                    UI.näytäln("Marketit\n");
                    for (int i = 0; i < kohde.getMarkettiInt(); i++) {
                        UI.näytäln((i + 1) + ". " + kohde.getMarketti(i));
                    }
                    UI.näytäln("\nPankit\n");
                    for (int i = 0; i < kohde.getPankkiInt(); i++) {
                        UI.näytäln((i + 1) + ". " + kohde.getPankki(i));
                    }
                    UI.näytäln("\nVankilat\n");
                    for (int i = 0; i < kohde.getVankilaInt(); i++) {
                        UI.näytäln((i + 1) + ". " + kohde.getVankila(i));
                    }
                    break;
                case 2:
                    // Tulostaa kaikki rikollisisjengin tiedot
                    UI.näytäln(rikolliset);
                    break;
                case 3:
                    // Kauppa päivittyy kun yksi rikollinen on ostettu.
                    UI.näytäln(kauppa);
                    UI.näytäln("Kenet tahdot ostaa? (Poistu: 0)");
                    UI.näytä("Valinta: ");

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

                    // TEST tulostus
                    System.out.println("Maine: " + rikolliset.getMaine() + "\nCP: " + rikolliset.getCombatPower() + "\nRahat: " + rikolliset.getRaha() + "\n------------\n");
                    break;
                case 4:
                    UI.näytäln("Placeholder");
                    break;
                case 0:
                    lopetaSimulaatio = true;
                    break;

            }
        } while (!lopetaSimulaatio);
    }
}
