package model;

import java.util.ArrayList;
import java.util.Random;
public class Kohteet {

    private ArrayList<KohdeMarketti> marketit;
    private ArrayList<KohdePankki> pankit;
    private ArrayList<KohdeVankila> vankilat;
    private Random random;
    
    private String[] nimetMarketti = {"K-market", "S-market", "Alepa", "Siwa", "Valintatalo", "R-kioski", "Lidl", "Apteekki", "Stockmann", "Tokmanni", "Prisma", "Citymarket",
        "Verkkokauppa", "GameStop", "Ikea", "Motonet", "Kultasepän liike", "Stadium", "Gigantti", "Jysk", "Hong kong", "Arnolds", "McDonalds", "Hesburger", "BurgerKing", "Clas Ohlson",
        "Nissen", "DNA kauppa", "Elisa kauppa", "Apple kauppa", "Intersport", "Sonera kauppa", "Kotipizza", "Teknikmagasinet"};
    private String[] nimetPankit = {"S-pankki", "Danske Bank", "Suomen Pankki", "Helsingin Osakepankki", "Suomen yhdyspankki", "Luotto-Pankki", "Bigbank", "Interbank", "Mandatum",
        "Liittopankki", "Liikepankki", "Sofia Pankki", "Svenska Handelsbanken", "Trevise Pankki", "Turun Osakepankki", "Uudenmaan Osakepankki", "Wasa Aktie Bank", "Ålandsbanken",
        "Maakuntain Pankki", "Landtmannabanken", "Maakiinteistäpankki", "Savo-Karjalan Osake-Pankki", "Postipankki", "Atlas-Pankki", "Kansallis-Osake-Pankki"};    
    private String[] nimetVankilat = {"Helsingin vankila", "Hämeenlinnan vankila", "Riihimäen vankila", "Kuopion vankila", "Mikkelin vankila", "Oulun vankila", "Jokelan vankila", "Keravan vankila",
        "Vanajan vankila", "Helsingin avovankila", "Vantaan vankila", "Kylmäkosken vankila", "Käyrän vankila", "Satakunnan vankila", "Turun vankila", "Vaasan vankila", "Vilppulan vankila",
        "Juuan vankila", "Laukaan vankila", "Pyhäselän vankila", "Sukevan vankila", "Ylitornion vankila"};

    private final int MAKSIMI_PER_KOHDE = 5;

    // kohteiden luominen (konstruktori)
    public Kohteet() {
        random = new Random();
        marketit = new ArrayList<>();
        pankit = new ArrayList<>();
        vankilat = new ArrayList<>();

        for (int i = 0; i < MAKSIMI_PER_KOHDE; i++) {
            marketit.add(new KohdeMarketti(nimetMarketti[random.nextInt(nimetMarketti.length)], i));
            pankit.add(new KohdePankki(nimetPankit[random.nextInt(nimetPankit.length)], i));
            vankilat.add(new KohdeVankila(nimetVankilat[random.nextInt(nimetVankilat.length)], i));
        }
    }

    public int getMAKSIMI_PER_KOHDE() {
        return MAKSIMI_PER_KOHDE;
    }

    public ArrayList<KohdeMarketti> getMarketit() {
        return marketit;
    }

    public ArrayList<KohdePankki> getPankit() {
        return pankit;
    }

    public ArrayList<KohdeVankila> getVankilat() {
        return vankilat;
    }
    
    
    public String getMarketitString() {
        String merkkijono = "";
        for (int i = 0; i < marketit.size(); i++) {
            merkkijono += (i + 1) + ". " + marketit.get(i) + "\n";
        }
        return merkkijono;
    }

    public String getPankitString() {
        String merkkijono = "";
        for (int i = 0; i < pankit.size(); i++) {
            merkkijono += (i + 1) + ". " + pankit.get(i) + "\n";
        }
        return merkkijono;
    }

    public String getVankilatString() {
        String merkkijono = "";
        for (int i = 0; i < vankilat.size(); i++) {
            merkkijono += (i + 1) + ". " + vankilat.get(i) + "\n";
        }
        return merkkijono;
    }

    @Override
    public String toString() {
        return this.toString("kaikki");
    }

    public String toString(String kohde) {
        String merkkijono;
        switch (kohde) {
            case "marketit":
                merkkijono = getMarketitString() + "\n";
                break;
            case "pankit":
                merkkijono = getPankitString() + "\n";
                break;
            case "vankilat":
                merkkijono = getVankilatString() + "\n";
                break;
            case "kaikki":
                merkkijono = "\nMarketit:\n" + getMarketitString() + "\nPankit:\n" + getPankitString() +"\nVankilat:\n" + getVankilatString();
                break;
            default:
                merkkijono = "Koodaaja mokasi!";
        }
        return merkkijono;
    }
}
