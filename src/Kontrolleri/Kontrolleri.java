package Kontrolleri;

import Käyttöliittymä.Käyttöliittymä;
import java.util.Random;
import model.Kohteet;
import model.Rikolliset;
import model.Kauppa;
import model.KohteetToiminnallisuus;
import model.Poliisit;
import model.Vankila;

public class Kontrolleri {

    public static void main(String[] args) {
        Käyttöliittymä UI = new Käyttöliittymä();
        Kohteet kohde = new Kohteet();
        Kauppa kauppa = new Kauppa();
        Rikolliset rikolliset = new Rikolliset();
        Poliisit poliisit = new Poliisit();
        int syöteInt;
        int poliisitauko = 0;
        Vankila vankila = new Vankila();
        boolean poliisitAktivoituu = true;
        Random random = new Random();

        /* Monivalintavalikko */
        final String valikko = "\nToiminta vaihtoehdot | 1. Kohteet "
                + "| 2. Rikollisjengin tiedot | 3. Kauppa | 4. Poliisit "
                + "| 0. Lopeta simulaatio";

        /* Simulaation aloitusteksti */
        UI.näytäln(" ,ggggggggggg,                                                                                ");
        UI.näytäln("dP\"\"\"88\"\"\"\"\"\"Y8,        ,dPYb,                  ,dPYb, ,dPYb,                            I8   ");
        UI.näytäln("Yb,  88      `8b        IP'`Yb                  IP'`Yb IP'`Yb                            I8   ");
        UI.näytäln("Yb,  88      `8b        IP'`Yb                  IP'`Yb IP'`Yb                            I8   ");
        UI.näytäln(" `\"  88      ,8P   gg   I8  8I                  I8  8I I8  8I  gg                     88888888");
        UI.näytäln("     88aaaad8P\"    \"\"   I8  8bgg,               I8  8' I8  8'  \"\"                        I8   ");
        UI.näytäln("     88\"\"\"\"Yb,     gg   I8 dP\" \"8    ,ggggg,    I8 dP  I8 dP   gg     ,g,      ,ggg,     I8   ");
        UI.näytäln("     88     \"8b    88   I8d8bggP\"   dP\"  \"Y8ggg I8dP   I8dP    88    ,8'8,    i8\" \"8i    I8   ");
        UI.näytäln("     88      `8i   88   I8P' \"Yb,  i8'    ,8I   I8P    I8P     88   ,8'  Yb   I8, ,8I   ,I8,  ");
        UI.näytäln("     88       Yb,_,88,_,d8    `Yb,,d8,   ,d8'  ,d8b,_ ,d8b,_ _,88,_,8'_   8)  `YbadP'  ,d88b, ");
        UI.näytäln("     88        Y88P\"\"Y888P      Y8P\"Y8888P\"    8P'\"Y888P'\"Y888P\"\"Y8P' \"YY8P8P888P\"Y88888P\"\"Y88");

        UI.näytäln("\n\nTervetuloa Rikolliset simulaatiopeliin,");
        UI.näytäln("\nTämä simulaatio simuloi rikollismaailman elämää."
                + "\nSimulaation käyttäjänä pääset ohjaamaan rikollisjengin ryöstöjä ja\n"
                + "hankkeita tielläsi alamaailman huipulle pahamaineisinpana rikollisorganisaationa.");

        UI.näytä("\nJatka painamalla enter...");
        UI.lueString();
        UI.clear();
        boolean lopetaSimulaatio = false;

        /* Peruslooppi */
        do {
            // TODO: Statsit näkyvät nyt. Tämän voisi päivittää myös näyttämään nykyiset erikoisuudet, jäsenien määrän jne.
            UI.näytäln("\n\nJengin tiedot:\nMaine: " + rikolliset.getMaine() + " | CP: " + rikolliset.getCombatPower() + " | Rahat: " + rikolliset.getRaha() + " | "
                    + "Jäseniä: " + rikolliset.getJäsenet().size() + " | Erikoisuudet: " + rikolliset.getErikoisuudet().toString() + "\n");
            if (!vankila.getRikolliset().isEmpty()) {
                UI.näytäln("Vankila: ");
                UI.näytäln(vankila);
            }
            UI.näytäln(valikko);
            UI.näytä("Valinta: ");
            syöteInt = UI.lueInt();
            UI.clear();

            switch (syöteInt) {
                // Tulostaa valikon pääkohteista
                case 1:
                    UI.näytäln("1. Pankit | 2. Marketit | 3. Vankilat | 4. Kaikki | 0. Poistu");
                    UI.näytä("Valinta: ");
                    syöteInt = UI.lueInt();
                    UI.clear();
                    switch (syöteInt) {
                        // Tulostaa pankki kohteet
                        case 1:

                            UI.näytäln("\n\nJengin tiedot:\nMaine: " + rikolliset.getMaine() + " | CP: " + rikolliset.getCombatPower() + " | Rahat: " + rikolliset.getRaha() + " | "
                                    + "Jäseniä: " + rikolliset.getJäsenet().size() + " | Erikoisuudet: " + rikolliset.getErikoisuudet().toString() + "\n");
                            UI.näytäln("\nPankit:");
                            UI.näytä(kohde.toString("pankit"));
                            UI.näytäln("0. Poistu");
                            UI.näytä("Valinta: ");
                            syöteInt = UI.lueInt();
                            UI.clear();

                            if (syöteInt == 0) {
                                UI.clear();
                                break;
                            }

                            if (syöteInt < 1 || syöteInt > kohde.getMAKSIMI_PER_KOHDE()) {
                                UI.clear();
                                UI.näytäln("Virheellinen valinta");
                            } else {
                                // Tässä hyökätään kohteeseen
                                UI.näytäln(hyökkäys(kohde.getPankit().get(syöteInt - 1), rikolliset));
                                vankila.vankilaTimer();
                                if (rikolliset.getMaine() > 1200 & poliisitauko == 0) {
                                    UI.näytäln(poliisit.ratsia(rikolliset, vankila));

                                }
                                if (poliisitauko > 0) {
                                    poliisitauko -= 1;
                                    UI.näytäln("Poliisilaitos on tauolla seuraavat " + poliisitauko + " vuoroa.\n");
                                }

                            }
                            break;
                        // Tulostaa marketti kohteet
                        case 2:
                            UI.näytäln("\n\nJengin tiedot:\nMaine: " + rikolliset.getMaine() + " | CP: " + rikolliset.getCombatPower() + " | Rahat: " + rikolliset.getRaha() + " | "
                                    + "Jäseniä: " + rikolliset.getJäsenet().size() + " | Erikoisuudet: " + rikolliset.getErikoisuudet().toString() + "\n");
                            UI.näytäln("\nMarketit:");
                            UI.näytä(kohde.toString("marketit"));

                            UI.näytäln("0. Poistu");
                            UI.näytä("Valinta: ");
                            syöteInt = UI.lueInt();
                            UI.clear();

                            if (syöteInt == 0) {
                                UI.clear();
                                break;
                            }

                            if (syöteInt < 1 || syöteInt > kohde.getMAKSIMI_PER_KOHDE()) {
                                UI.clear();
                                UI.näytäln("Virheellinen valinta");
                            } else {
                                // Tässä hyökätään kohteeseen
                                UI.näytäln(hyökkäys(kohde.getMarketit().get(syöteInt - 1), rikolliset));
                                vankila.vankilaTimer();
                                if (rikolliset.getMaine() > 1200 & poliisitauko == 0) {
                                    UI.näytäln(poliisit.ratsia(rikolliset, vankila));

                                }
                                if (poliisitauko > 0) {
                                    poliisitauko -= 1;
                                    UI.näytäln("Poliisilaitos on tauolla seuraavat " + poliisitauko + " vuoroa.\n");
                                }
                            }
                            break;
                        // Tulostaa vankila kohteet
                        case 3:
                            UI.näytäln("\n\nJengin tiedot:\nMaine: " + rikolliset.getMaine() + " | CP: " + rikolliset.getCombatPower() + " | Rahat: " + rikolliset.getRaha() + " | "
                                    + "Jäseniä: " + rikolliset.getJäsenet().size() + " | Erikoisuudet: " + rikolliset.getErikoisuudet().toString() + "\n");
                            UI.näytäln("\nVankilat:");
                            UI.näytä(kohde.toString("vankilat"));
                            UI.näytäln("0. Poistu");
                            UI.näytä("Valinta: ");
                            syöteInt = UI.lueInt();
                            UI.clear();

                            if (syöteInt == 0) {
                                UI.clear();
                                break;
                            }

                            if (syöteInt < 1 || syöteInt > kohde.getMAKSIMI_PER_KOHDE()) {
                                UI.clear();
                                UI.näytäln("Virheellinen valinta");
                            } else {
                                // Tässä hyökätään kohteeseen
                                UI.näytäln(hyökkäys(kohde.getVankilat().get(syöteInt - 1), rikolliset));
                                vankila.vankilaTimer();
                                if (rikolliset.getMaine() > 1200 & poliisitauko == 0) {
                                    UI.näytäln(poliisit.ratsia(rikolliset, vankila));

                                }
                                if (poliisitauko > 0) {
                                    poliisitauko -= 1;
                                    UI.näytäln("Poliisilaitos on tauolla seuraavat " + poliisitauko + " vuoroa.\n");
                                }
                            }
                            break;
                        case 4:
                            // Tulostaa kaikki kohteet
                            UI.näytäln("\n\nJengin tiedot:\nMaine: " + rikolliset.getMaine() + " | CP: " + rikolliset.getCombatPower() + " | Rahat: " + rikolliset.getRaha() + " | "
                                    + "Jäseniä: " + rikolliset.getJäsenet().size() + " | Erikoisuudet: " + rikolliset.getErikoisuudet().toString() + "\n");
                            UI.näytäln(kohde.toString("kaikki"));
                            break;
                        case 0:
                            UI.clear();
                            break;
                        default:
                            UI.clear();
                            UI.näytäln("Valintaa ei löytynyt");
                            break;
                    }
                    break;
                case 2:
                    // Tulostaa kaikki rikollisisjengin tiedot
                    UI.näytäln("\n" + rikolliset);
                    break;
                case 3:
                    // Kauppa päivittyy kun yksi rikollinen on ostettu.
                    UI.näytäln("Tervetuloa kauppaan!\nValikoimamme päivittyvät jokaisen oston jälkeen, joten mieti tarkkaan mitä tarvitset!\n\n");
                    UI.näytäln("# | Nimi | Erikoisuus | Maine | Hinta");
                    UI.näytäln(kauppa);

                    UI.näytäln("Jengin tiedot:\nMaine: " + rikolliset.getMaine() + " | CP: " + rikolliset.getCombatPower() + " | Rahat: " + rikolliset.getRaha());
                    UI.näytäln("\nKenet tahdot ostaa? (Poistu: 0)");
                    UI.näytä("Valinta: ");

                    int syöte = UI.lueInt();
                    UI.clear();
                    if (syöte == 0) {
                        break;
                    }
                    // Syötteen oikeellisuuden tarkistus
                    if (syöte < 1 || syöte > kauppa.getVALIKOIMAN_KOKO()) {
                        UI.näytäln("Virheellinen valinta!");
                    } else if (rikolliset.getRaha() >= kauppa.ostaRikollinen(syöte).getArvo()) {
                        rikolliset.lisääJäsen(kauppa.ostaRikollinen(syöte));
                        rikolliset.setRaha(rikolliset.getRaha() - kauppa.ostaRikollinen(syöte).getArvo());
                        kauppa.päivitäValikoima();
                        UI.näytäln("Uusi rikollinen liittyi jengiin!");
                    } else {
                        UI.näytäln("Ei riittävästi varaa!");
                    }

                    break;
                case 4:
                    // Tulostaa listan poliiseista
                    UI.näytäln(poliisit.toString(rikolliset));
                    UI.näytäln("0. Poistu\n1. Hyökkää poliisilaitokseen\n");
                    UI.näytä("Valinta: ");
                    int input = UI.lueInt();

                    if (input == 0) {
                        break;
                    }

                    if (input == 1) {
                        int arvo = 1 + random.nextInt(2);
                        if (arvo == 1) {
                            poliisitauko = 5;
                            UI.clear();
                            UI.näytäln("Hyökkäys oli onnistunut! Poliisilaitos on tauolla seuraavat " + poliisitauko + " vuoroa.\n");
                            break;
                        } else if (arvo == 2) {
                            int rahaVähennys = rikolliset.getRaha() / 4;
                            rikolliset.setRaha(rikolliset.getRaha() - rahaVähennys);
                            UI.clear();
                            UI.näytäln("Hyökkäys epäonnistui, rikollisjengisi menetti: -" + rahaVähennys + " rahaa.\n");
                            poliisitauko = 0;
                            break;
                        }
                    } else {
                        UI.näytäln("Virheellinen valinta!");
                    }

                    break;
                case 0:
                    lopetaSimulaatio = true;
                    break;
                // Demoa varten    
                case 1001:
                    UI.näytäln("\n[Demonstration mode]\n");
                    rikolliset.setRaha(1000000);
                    break;

            }
            // Vankila-ajastin; kun vankilassa on rikollisia, jokaisen loopin jälkeen jäljellä oleva
            // vankila-aika -=1;
            // Poliisien suorrittama ratsia, random tod.näk. arvoilla käydää läpi jokainen pelaajan
            // rikollinen, joka sitten päätyy vankilaan tai ei.

            if (rikolliset.getMaine() > 1200) {

                if (poliisitAktivoituu) {
                    UI.näytäln("Maineesi kasvaa vauhdilla! Poliisit alkavat tutkia toimintaasi!");
                    poliisitAktivoituu = false;
                }

            }
        } while (!lopetaSimulaatio);
    }

    private static String hyökkäys(KohteetToiminnallisuus kohde, Rikolliset rikolliset) {
        int kohdeCP = kohde.getCombatPower();
        // Vertaa rikollisten erikoisuudet, kohteiden turvallisuuteen:
        String[] kohteidenTurvallisuudet = kohde.getTurvallisuus();
        int eiVastaavaaErikoisuutta = 0;
        for (int i = 0; i < kohteidenTurvallisuudet.length; i++) {
            if (!(kohteidenTurvallisuudet[i] == null) && !rikolliset.getErikoisuudet().contains(kohteidenTurvallisuudet[i])) {
                ++eiVastaavaaErikoisuutta;
            }
        }
        // Jos rikollisilla ei ole erikoisuutta kohteen turvallisuutta vastaan
        // kohteen CP kasvaa 200:lla per puuttuva erikoisuus
        kohdeCP += 200 * eiVastaavaaErikoisuutta;

        // Tässä todetaan voittaja / häviäjä
        String merkkijono;
        if (rikolliset.getCombatPower() <= kohdeCP) {
            // Jos rikolliset ovat heikkoja tai yhtä vahvoja
            // kuin kohde, niin hyökkäys epäonnistuu. Miksi tasurissa? Puolustajan etu!
            merkkijono = "Hävisit!\n";
            merkkijono += "Kohteessa oli seuraavat turvat suojaamassa:\n| ";
            for (int i = 0; i < kohde.getTurvallisuus().length; i++) {
                if (kohde.getTurvallisuus()[i] != null) {
                    merkkijono += kohde.getTurvallisuus()[i] + " | ";
                }
            }

            boolean printOnce = true;
            for (int i = 0; i < rikolliset.getJäsenet().size(); i++) {
                if (Math.random() <= 0.12) {
                    if (printOnce) {
                        merkkijono += "\n\nMenetit seuraavat henkilöt paetessa:\n";
                        printOnce = false;
                    }

                    merkkijono += rikolliset.getJäsenet().get(i) + "\n";
                    rikolliset.poistaJäsen(rikolliset.getJäsenet().get(i));
                }
            }
        } else {
            // VOITTO TILANNE
            merkkijono = "Voitit!\nVarastettu rahamäärä: " + kohde.getRaha();
            rikolliset.setRaha(rikolliset.getRaha() + kohde.getRaha());
            kohde.nostaVaikeutta();

        }
        return merkkijono;
    }
}
