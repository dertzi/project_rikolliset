/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Hanne
 */
public class KohteetToiminnallisuus {

    private String nimi, turvallisuus;
    private int cpInt, cp, vaikeustaso;
    private ArrayList<KohteetToiminnallisuus> kohdeLista = new ArrayList<>();

    public KohteetToiminnallisuus(int vaikeustaso) {
        this.vaikeustaso = vaikeustaso;
    }

    public KohteetToiminnallisuus() {
        int vaikeusInt = laskeRandom(1, 7);
        vaikeustaso = vaikeusInt;

    }

    public void setList(KohteetToiminnallisuus kohde) {
        kohdeLista.add(kohde);
    }

    public void setAll(String nimi, String turvallisuus, int cp, int vaikeustaso) {
        this.nimi = nimi;
        this.turvallisuus = turvallisuus;
        this.cp = cp;
        this.vaikeustaso = vaikeustaso;
    }
    // Käytetäänkö oikeita kauppojen, pankkien ja vankiloiden nimiä? Vai onko huonossa maussa?
    // metodit arpoo merkkijono listasta satunnaisen nimen itselleen
    public void setNimiMarketti() {
        String markettiNimet[] = {"K-market", "S-market", "Alepa", "Siwa", "Valintatalo", "R-kioski", "Lidl", "Apteekki", "Stockmann", "Tokmanni", "Prisma", "Citymarket",
        "Verkkokauppa","GameStop","Ikea","Motonet","Kultasepän liike","Stadium","Gigantti","Jysk","Hong kong","Arnolds","McDonalds","Hesburger","BurgerKing","Clas Ohlson",
        "Nissen","DNA kauppa","Elisa kauppa","Apple kauppa","Intersport","Sonera kauppa","Kotipizza","Teknikmagasinet"};
        nimi = markettiNimet[laskeRandom(0, markettiNimet.length - 1)];
    }

    public void setNimiPankki() {
        String pankkiNimet[] = {"S-pankki", "Danske Bank", "Suomen Pankki", "Helsingin Osakepankki", "Suomen yhdyspankki", "Luotto-Pankki", "Bigbank", "Interbank", "Mandatum",
             "Liittopankki", "Liikepankki", "Sofia Pankki", "Svenska Handelsbanken", "Trevise Pankki", "Turun Osakepankki", "Uudenmaan Osakepankki", "Wasa Aktie Bank", "Ålandsbanken",
            "Maakuntain Pankki", "Landtmannabanken", "Maakiinteistäpankki", "Savo-Karjalan Osake-Pankki", "Postipankki", "Atlas-Pankki", "Kansallis-Osake-Pankki"};
        nimi = pankkiNimet[laskeRandom(0, pankkiNimet.length - 1)];
    }

    public void setNimiVankila() {
        String vankilaNimet[] = {"Helsingin vankila", "Hämeenlinnan vankila", "Riihimäen vankila", "Kuopion vankila", "Mikkelin vankila", "Oulun vankila", "Jokelan vankila", "Keravan vankila",
            "Vanajan vankila", "Helsingin avovankila", "Vantaan vankila", "Kylmäkosken vankila", "Käyrän vankila", "Satakunnan vankila", "Turun vankila", "Vaasan vankila", "Vilppulan vankila",
            "Juuan vankila", "Laukaan vankila", "Pyhäselän vankila", "Sukevan vankila", "Ylitornion vankila"};
        nimi = vankilaNimet[laskeRandom(0, vankilaNimet.length - 1)];
    }

    public void setTurvallisuus(String turvallisuus) {
        this.turvallisuus = turvallisuus;
    }

    public void setCP() {
        switch (vaikeustaso) {
            case 1:
                cpInt = laskeRandom(1, 10);
                break;
            case 2:
                cpInt = laskeRandom(11, 20);
                break;
            case 3:
                cpInt = laskeRandom(21, 30);
                break;
            case 4:
                cpInt = laskeRandom(31, 40);
                break;
            case 5:
                cpInt = laskeRandom(41, 50);
                break;
            case 6:
                cpInt = laskeRandom(51, 60);
                break;
            case 7:
                cpInt = laskeRandom(61, 70);
                break;
        }
        cp = cpInt;
    }

    public ArrayList getList() {
        return kohdeLista;
    }

    public double getCp() {
        return cp;
    }

    public String getNimi() {
        return nimi;
    }

    public String getRandomTurvallisuus() {
        ArrayList<String> mahdTurvallisuus = new ArrayList<>();
        mahdTurvallisuus.add("Sähköinen turvajärjestelmä");
        mahdTurvallisuus.add("Yksityisvartijoita");
        mahdTurvallisuus.add("Erikoisvahvistettu kassakaappi");

        String RandomTurvallisuus = mahdTurvallisuus.get(new Random().nextInt(mahdTurvallisuus.size()));
        return RandomTurvallisuus;
    }

    public void getTurvallisuus(int määrä) {
        boolean turvaFound;
        String turva;
        ArrayList<String> kohteenTurvallisuus = new ArrayList<>();
        for (int i = 1; i <= määrä; i++) {
            do {
                turva = getRandomTurvallisuus();
                turvaFound = kohteenTurvallisuus.contains(turva);
            } while (turvaFound = true);
            kohteenTurvallisuus.add(turva);
        }
        for (int i = 0; i < kohteenTurvallisuus.size(); i++) {
            String arvo = kohteenTurvallisuus.get(i);
            System.out.println(arvo);
        }
    }

    public int laskeRandom(int min, int max) {
        int minimi = min;
        int maksimi = max;
        int randomVal = ThreadLocalRandom.current().nextInt(minimi, maksimi + 1);
        return randomVal;
    }

    @Override
    public String toString() {
        return nimi + " | CP " + cp + " | Vaikeustaso " + vaikeustaso;
    }

}
