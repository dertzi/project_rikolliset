package Kontrolleri;

import Käyttöliittymä.Käyttöliittymä;
import model.Kohteet;
import model.Rikolliset;
import model.Kauppa;

public class Kontrolleri {

    public static void main(String[] args) {
        Käyttöliittymä UI = new Käyttöliittymä();
        Kohteet kohde = new Kohteet();
        Kauppa kauppa = new Kauppa();
        Rikolliset rikolliset = new Rikolliset();
        int syöteInt;
        String syöteString;

        /* Monivalintavalikko */
        final String valikko = "\nToiminta vaihtoehdot | 1. Kohteet "
                + "| 2. Rikollisjengin tiedot | 3. Kauppa | 4. Poliisit "
                + "| 5. Placeholder | 0. Lopeta simulaatio";

        /* Simulaation aloitusteksti */
        UI.näytäln("Tervetuloa |> RIKOLLISET <| simulaatiopeliin");
        UI.näytäln("\nTämä simulaatio simuloi rikollismaailman elämää." + "\nSimulaation käyttäjänä pääset ohjaamaan rikollisjengin ryöstöjä ja\n"
                + "hankkeita tielläsi alamaailman huipulle pahamaineisinpana rikollisorganisaation johtajana.");

        UI.näytä("\nJatka painamalla enter...");
        UI.lueString();
        UI.clear();
        boolean lopetaSimulaatio = false;

        /* Peruslooppi */
        do {
            // Tähän voisi vaikka tulla joitain perusstatseja, kuten jäsenien määrä tjms (iha printtinä)
            UI.näytäln(valikko);
            UI.näytä("Valinta: ");
            syöteInt = UI.lueInt();
            UI.clear();

            switch (syöteInt) {
                // Tulostaa valikon pääkohteista
                case 1:
                    UI.näytäln("1. Pankit | 2. Marketit | 3. Vankilat | 4. Kaikki | 0. Poistu kaupasta");
                    UI.näytä("Valinta: ");
                    syöteInt = UI.lueInt();
                    UI.clear();
                    switch (syöteInt) {
                        // Tulostaa pankki kohteet
                        case 1:
                            UI.näytäln("\nPankit:");
                            UI.näytäln(kohde.toString("pankit"));
                            UI.näytä("Valinta: ");
                            break;
                        // Tulostaa marketti kohteet
                        case 2:
                            UI.näytäln("\nMarketit:");
                            UI.näytäln(kohde.toString("marketit"));
                            UI.näytä("Valinta: ");
                            break;
                        // Tulostaa vankila kohteet
                        case 3:
                            UI.näytäln("\nVankilat:");
                            UI.näytäln(kohde.toString("vankilat"));
                            UI.näytä("Valinta: ");
                            break;
                        case 4:
                            // Tulostaa kaikki kohteet
                            UI.näytäln(kohde.toString("kaikki"));
                        case 0:
                            break;
                        default:
                            UI.näytäln("Valintaa ei löytynyt");
                            break;
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
