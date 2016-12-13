package model;

import java.util.ArrayList;

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
        this.päivitäValikoima();
    }

    // Kaupan valikoiman päivitys
    public void päivitäValikoima() {
        valikoima.clear();
        for (int i = 0; i < VALIKOIMAN_KOKO; i++) {
            valikoima.add(new Rikollinen());
        }
    }

    public int getVALIKOIMAN_KOKO() {
        return VALIKOIMAN_KOKO;
    }

    public Rikollinen ostaRikollinen(int indeksi) {
        return valikoima.get(indeksi - 1);
    }

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
}
