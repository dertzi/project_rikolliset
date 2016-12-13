package Kontrolleri;

import Käyttöliittymä.Käyttöliittymä;
import java.util.Arrays;
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
        Vankila vankila = new Vankila();
        boolean poliisitAktivoituu = true;

        /* Monivalintavalikko */
        final String valikko = "\nToiminta vaihtoehdot | 1. Kohteet "
                + "| 2. Rikollisjengin tiedot | 3. Kauppa | 4. Poliisit "
                + "| 0. Lopeta simulaatio";

        /* Simulaation aloitusteksti */
        UI.näytäln("Tervetuloa |> RIKOLLISET <| simulaatiopeliin");
        UI.näytäln("\nTämä simulaatio simuloi rikollismaailman elämää."
                + "\nSimulaation käyttäjänä pääset ohjaamaan rikollisjengin ryöstöjä ja\n"
                + "hankkeita tielläsi alamaailman huipulle pahamaineisinpana rikollisorganisaation johtajana.");

        UI.näytä("\nJatka painamalla enter...");
        UI.lueString();
        UI.clear();
        boolean lopetaSimulaatio = false;

        /* Peruslooppi */
        do {
            // TODO: Statsit näkyvät nyt. Tämän voisi päivittää myös näyttämään nykyiset erikoisuudet, jäsenien määrän jne.
            UI.näytäln("\n\nJengin tiedot:\nMaine: " + rikolliset.getMaine() + " | CP: " + rikolliset.getCombatPower() + " | Rahat: " + rikolliset.getRaha() + "\n");
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
                            UI.näytäln("\nPankit:");
                            UI.näytä(kohde.toString("pankit"));
                            UI.näytäln("0. Poistu");
                            UI.näytä("Valinta: ");
                            syöteInt = UI.lueInt();
                            UI.clear();

                            if (syöteInt == 0) {
                                break;
                            }

                            if (syöteInt < 1 || syöteInt > kohde.getMAKSIMI_PER_KOHDE()) {
                                UI.näytäln("Virheellinen valinta");
                            } else {
                                // Tässä hyökätään kohteeseen
                                UI.näytäln(hyökkäys(kohde.getPankit().get(syöteInt - 1), rikolliset));
                            }
                            break;
                        // Tulostaa marketti kohteet
                        case 2:
                            UI.näytäln("\nMarketit:");
                            UI.näytä(kohde.toString("marketit"));

                            UI.näytäln("0. Poistu");
                            UI.näytä("Valinta: ");
                            syöteInt = UI.lueInt();
                            UI.clear();

                            if (syöteInt == 0) {
                                break;
                            }

                            if (syöteInt < 1 || syöteInt > kohde.getMAKSIMI_PER_KOHDE()) {
                                UI.näytäln("Virheellinen valinta");
                            } else {
                                // Tässä hyökätään kohteeseen
                                UI.näytäln(hyökkäys(kohde.getMarketit().get(syöteInt - 1), rikolliset));
                            }
                            break;
                        // Tulostaa vankila kohteet
                        case 3:
                            UI.näytäln("\nVankilat:");
                            UI.näytä(kohde.toString("vankilat"));
                            UI.näytäln("0. Poistu");
                            UI.näytä("Valinta: ");
                            syöteInt = UI.lueInt();
                            UI.clear();

                            if (syöteInt == 0) {
                                break;
                            }

                            if (syöteInt < 1 || syöteInt > kohde.getMAKSIMI_PER_KOHDE()) {
                                UI.näytäln("Virheellinen valinta");
                            } else {
                                // Tässä hyökätään kohteeseen
                                UI.näytäln(hyökkäys(kohde.getVankilat().get(syöteInt - 1), rikolliset));
                            }
                            break;
                        case 4:
                            // Tulostaa kaikki kohteet
                            UI.näytäln(kohde.toString("kaikki"));
                            break;
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
                    break;
                case 0:
                    lopetaSimulaatio = true;
                    break;

            }
            // Vankila-ajastin; kun vankilassa on rikollisia, jokaisen loopin jälkeen jäljellä oleva
            // vankila-aika -=1;
            vankila.vankilaTimer();
            // Poliisien suorrittama ratsia, random tod.näk. arvoilla käydää läpi jokainen pelaajan
            // rikollinen, joka sitten päätyy vankilaan tai ei.
            if (rikolliset.getMaine() > 1200) {
                
                if (poliisitAktivoituu) {
                    UI.näytäln("Maineesi kasvaa vauhdilla! Poliisit alkavat tutkia toimintaasi!");
                    poliisitAktivoituu = false;
                }
                
                if (rikolliset.getMaine() > 3200) {
                    UI.näytäln(poliisit.ratsia(rikolliset, vankila));
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
                        merkkijono+="\n\nMenetit seuraavat henkilöt paetessa:\n";
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
