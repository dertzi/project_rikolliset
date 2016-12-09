/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author andred
 */
public class Kauppa {

    private ArrayList<Rikollinen> valikoima;
    private final int VALIKOIMAN_KOKO;

    // Kaupan luonti (konstruktori)
    public Kauppa() {
        valikoima = new ArrayList<>();
        VALIKOIMAN_KOKO = 5;
        
        // Luonnin yhteydessä valikoima täytetään.
        // Jos tämä ei toimi sen voi sitten copy/pastea tuolta alhaalta
        // tähän. Vaihtoehtoisesti Kaupan luonnin jälkeen päivitäValikoima()
        // voidaan kutsua heti.
        
        päivitäValikoima();
    }
    
    
    // Kaupan valikoiman päivitys
    public void päivitäValikoima() {
        valikoima.clear();
        for (int i = 0; i < VALIKOIMAN_KOKO; i++) {
            valikoima.add(new Rikollinen());
        }
    }
    
    //** Koko valikoima päivittyy heti oston jälkeen. Joutuu miettimään tarkemmin mitä ostaa.
    // VALIKOIMAN_KOKO on myös vakio niin siihen ei pitäisi kajota enään esittelyn jälkeen.
        // Rikollisjäsenen poisto kaupan valikoimasta session ajaksi (ei jää turhaan roikkumaan listalle)
    //    public void poistaJäsenValikoimasta(int indeksi){
    //        valikoima.remove(indeksi-1);
    //        VALIKOIMAN_KOKO -= 1;
    //    }
    
    // Tämän pitäisi olla tarpeeton! Katso mallikaupasta miten arvon saa tietää!
    // rikollisen hinta
    //public int jäsenArvo(int indeksi) {
    //    return valikoima.get(indeksi-1).getArvo();
    //}
    
    public Rikollinen ostaRikollinen(int indeksi) {
        return valikoima.get(indeksi - 1);
    }
    
    //** Tekee täysin saman kuin ostaRikollinen. yleisesti nimeämiskäytäntö on että
    //**  getterit (getJäsen/getArvo) palauttavat jonkun luokan ominaisuuden arvon. 
    // olion palautus
    //public Rikollinen getJäsen(int indeksi){
    //    return valikoima.get(indeksi-1);
    //}
    
    // Selitetään mitä tässä siis tapahtuu:
    // toString metodi palauttaa muodossa stringin muodossa:
    // "i. nimi: | erikoisuus | maine | hinta:: "
    // Yhdellä toString kutsulla tulostuu koko kaupan valikoima.
    // Eli sitä ei siis kontrollerissa tarvitse lähteä looppaamaan turhaan.
    // Tässä voi vielä korjata hakemalla erikseen getErikoisuus() [puuttuu vielä rikollinen luokasta]
    // ja getNimi. Näin voidaan asettaa tulostus muotoon "Nimi: | Erikoisuus: | Maine: | Hinta: "
    // Tosin olen henkilökohtaisesti sitä mieltä että olisi parempi tehdä se muodossa:
    // # | Nimi | Erikoisuus | Maine | Hinta
    // i | nimi | erikoisuus | maine | arvo
    // ja hoidettaisiin se printf metodilla. niin että ylin rivi olisi sarakkeiden nimet
    // ja sitten se tulostaa loput.
    
        @Override
        public String toString() {
        String valikoimaMerkkijono = "";
        for (int i = 0; i < VALIKOIMAN_KOKO; i++) {
            valikoimaMerkkijono += (i + 1) + ". " + valikoima.get(i) + " | Hinta: " + valikoima.get(i).getArvo() + "\n";
        }
        return valikoimaMerkkijono;
    }
    
    // En täysin ymmärrä miksi alkuperäinen muutettiin tähän muotoon, 
    // vai oliko se vaan kadonnut synccays ongelmien aikana. 
    // Merkkijonon palautus (kaupan valikoiman rikolliset)
    //public String toString(int i) {
    //    String valikoimaMerkkijono = (i+1) + ". " + valikoima.get(i).getNimi() + " | Hinta: " + valikoima.get(i).getArvo() + "\n";
    //    return valikoimaMerkkijono;
    //}
        
    /** Miksi muut luokat tarvitsevat tiedon valikoiman koosta?**/
    // palauttaa kaupan valikoiman koon
    //public int getValikoimanKoko(){
    //    return VALIKOIMAN_KOKO;
    //}
}
