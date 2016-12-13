package Kontrolleri;

import Käyttöliittymä.Käyttöliittymä;
import model.Kohteet;
import model.Rikolliset;
import model.Kauppa;
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
            // Tulostaa vangit ja heidän jäljellä oleva lusittava aika
            // Jos siis vankilassa on väkeä.
            if (!vankila.getRikolliset().isEmpty()) {
                UI.näytäln("Vankila: ");
                UI.näytäln(vankila.toString());
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
                            UI.näytä("Hyökkää kohteeseen (1-"+ kohde.getMarketit().size() +"): ");
                            syöteInt = UI.lueInt();
                            UI.clear();

                            if (syöteInt == 0) {
                                break;
                            }

                            if (syöteInt < 1 || syöteInt > kohde.getMAKSIMI_PER_KOHDE()) {
                                UI.näytäln("Virheellinen valinta");
                                break;
                            } else {
                                // TÄSSÄ HYÖKÄTÄÄN KOHTEESEEN
                                // KUTSU kontrollerissa luotuun funktioon parametrina
                                // valittu kohde. Hyökkäys joko onnistuu tai epäonnistuu.
                                // funktiossa sitten toiminta että miten kohde ja jengi muuttuu jos
                                // hyökkäys onnistuu tai epäonnistuu.
                                // ESIM: hyökkää(kohde.pankit.get(i))?

                                // Hyökkäyksen toiminnallisuus:
                                // Eli kohteen turva lisää kohteen CPseen vaikka 20% pohja CPstä. Jos jengillä on
                                // sitä turvaa vastaava erikoisuus, se kumoaa sen turvallisuuden/CPn.
                                // Hyökkäyksessä verrataan jengin ja kohteen CPn suhdetta toisiinsa
                                // esim: Jengi cp: 1000 ja kaupan CP on 500 niin olkoon siinä tapauksessa
                                // todennäköisyys onnistua hyökkäyksessä (1000J_CP-500K_CP) / 25 = 20 eli 20% mahdollisuus onnistua?
                                // Jos hyökkäys epäonnistuu: Jokaisen jäsenen kohdalla 15% mahdollisuus "kuolla"
                                // Kohteen tilanne (CP/Rahat) pysyy samana.
                                // Jos hyökkäys onnistuu: Jokaisen jäsenen kohdalla 4% mahdollisuus "kuolla" ja
                                // 65%-100% osuus kohteen rahoista. Kohteen vaikeustaso nousee (lisää rahaa, cp, turvallisuutta)
                                
                                // Tarkista erikoisuudet:
                                // 
                                //kohde.getPankit().get(syöteInt - 1).getTurvallisuus();
                            }

                            break;
                        // Tulostaa marketti kohteet
                        case 2:
                            UI.näytäln("\nMarketit:");
                            UI.näytä(kohde.toString("marketit"));
                            UI.näytäln("0. Poistu");
                            UI.näytä("Hyökkää kohteeseen (1-"+ kohde.getMarketit().size() +"): ");
                            
                            if (syöteInt == 0) {
                                break;
                            }

                            if (syöteInt < 1 || syöteInt > kohde.getMAKSIMI_PER_KOHDE()) {
                                UI.näytäln("Virheellinen valinta");
                                break;
                            } else {}
                            break;
                        // Tulostaa vankila kohteet
                        case 3:
                            UI.näytäln("\nVankilat:");
                            UI.näytä(kohde.toString("vankilat"));
                            UI.näytäln("0. Poistu");
                            UI.näytä("Hyökkää kohteeseen (1-"+ kohde.getMarketit().size() +"): ");
                            
                            if (syöteInt == 0) {
                                break;
                            }

                            if (syöteInt < 1 || syöteInt > kohde.getMAKSIMI_PER_KOHDE()) {
                                UI.näytäln("Virheellinen valinta");
                                break;
                            } else {}
                            break;
                        case 4:
                            // Tulostaa kaikki kohteet
                            UI.näytäln(kohde.toString("kaikki"));
                            UI.näytä("Hyökkää kohteeseen (1-"+ kohde.getMarketit().size() +"): ");
                            
                            if (syöteInt == 0) {
                                break;
                            }

                            if (syöteInt < 1 || syöteInt > kohde.getMAKSIMI_PER_KOHDE()) {
                                UI.näytäln("Virheellinen valinta");
                                break;
                            } else {}
                        case 0:
                            break;
                        default:
                            UI.näytäln("Valintaa ei löytynyt");
                            break;
                    }
                    break;
                case 2:
                    // Tulostaa kaikki rikollisisjengin tiedot
                    UI.näytäln(rikolliset.toString());
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
            UI.näytäln(poliisit.ratsia(rikolliset, vankila));

        } while (!lopetaSimulaatio); 
    }
}
