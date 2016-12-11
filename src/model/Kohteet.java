package model;

import java.util.ArrayList;

public class Kohteet {

    private ArrayList<KohdeMarketti> marketit;
    private ArrayList<KohdePankki> pankit;
    private ArrayList<KohdeVankila> vankilat;
    private final int MAKSIMI_PER_KOHDE = 5;

    // kohteiden luominen (konstruktori)
    public Kohteet() {
        marketit = new ArrayList<>();
        pankit = new ArrayList<>();
        vankilat = new ArrayList<>();

        for (int i = 0; i < MAKSIMI_PER_KOHDE; i++) {
            marketit.add(new KohdeMarketti());
            pankit.add(new KohdePankki());
            vankilat.add(new KohdeVankila());
        }
        for (int k = 0; k < MAKSIMI_PER_KOHDE; k++) {
            marketit.get(k).setNimiMarketti();
            marketit.get(k).setCP();

            pankit.get(k).setNimiPankki();
            pankit.get(k).setCP();

            vankilat.get(k).setNimiVankila();
            vankilat.get(k).setCP();
        }
    }

    public int getMAKSIMI_PER_KOHDE() {
        return MAKSIMI_PER_KOHDE;
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
