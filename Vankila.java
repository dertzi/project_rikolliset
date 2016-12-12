/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joel
 */
public class Vankila {

    private int combatPower;
    private final String nimi = "Vankila";
    private final ArrayList rikolliset;
    private ArrayList<Rikollinen> vapautuvatRikolliset = new ArrayList<>();
    private HashMap<Rikollinen, Integer> rikollisetHM = new HashMap<>();

    public Vankila() {
        this.rikolliset = new ArrayList<>();
        this.combatPower = 0;
    }

    public void vankilaTimer() {
        if (!rikolliset.isEmpty()) {
            for (Map.Entry<Rikollinen, Integer> entry : rikollisetHM.entrySet()) {
                int vankilaAika = entry.getValue()-1;
                entry.setValue(vankilaAika);
                if (entry.getValue() == 0) {
                    vapautuvatRikolliset.add(entry.getKey());
                    rikolliset.remove(entry.getKey());
                    rikollisetHM.remove(entry, entry);
                }
            }
        }
    }
    

    public void lisääRikollinen(Rikollinen rikollinen, int aika) {
        if (!rikolliset.contains(rikollinen)) {
            rikolliset.add(rikollinen);
            rikollisetHM.put(rikollinen, aika);
        }

    }

    public void resetVapautuvatRikolliset() {
        vapautuvatRikolliset.clear();
    }

    public ArrayList<Rikollinen> getRikolliset() {
        return rikolliset;
    }

    public ArrayList<Rikollinen> vapautuvatRikolliset() {
        return vapautuvatRikolliset;
    }

    @Override
    public String toString() {
        String merkkijono = "";
        for (int i = 0; i < rikolliset.size(); i++) {
            merkkijono += (i + 1) + ". " + rikolliset.get(i) + " | jäljellä oleva vankila aika: (" + rikollisetHM.get(rikolliset.get(i)) + ")" + "\n";
        }
        return merkkijono;
    }
}
