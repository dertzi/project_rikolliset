package model;

import java.util.ArrayList;

public class Rikolliset {

    private int combatPower;
    private int maine;
    private int raha;
    private final int ALKU_RAHA = 10000;
    private ArrayList<Rikollinen> jäsenet;
    private final int RikollistenMäärä = 10;

    public Rikolliset() {
        this.combatPower = 0;
        this.maine = 0;
        this.jäsenet = new ArrayList<>();
        this.raha = ALKU_RAHA;

        // Rikollisten luonti, 'RikollistenMäärä' määrää lukumäärän.
        for (int j = 0; j < RikollistenMäärä; j++) {
            jäsenet.add(new Rikollinen());
        }
    }

    // Palauttaa merkkijonon rikollisen statseista
    public String getRikolliset(int index) {
        return jäsenet.get(index).getStats();
    }
    
    // Palauttaa rikollisten lukumäärän kontrollerin for-looppia varten
    public int getRikollisetInt(){
        return jäsenet.size();
    }

    public int getCombatPower() {
        return combatPower;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

    public int getMaine() {
        return maine;
    }

    public int getRaha() {
        return raha;
    }

    public void lisääJäsen(Rikollinen jäsen) {
        jäsenet.add(jäsen);

    }
}
