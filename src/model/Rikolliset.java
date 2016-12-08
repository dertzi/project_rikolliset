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

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

    public void setRaha(int raha) {
        this.raha = raha;
    }

    // Palauttaa merkkijonon rikollisen statseista
    public String getRikolliset(int index) {
        String nullString = "null";
        if (jäsenet.get(index).getStats().contains(nullString)) {
            String fixedString = jäsenet.get(index).getStats().replaceAll("null", "Ei erityisosaamista");
            return fixedString;
        } else {
            return jäsenet.get(index).getStats();
        }

    }
    // Palauttaa rikollisten lukumäärän kontrollerin for-looppia varten

    public int getRikollisetInt() {
        return jäsenet.size();
    }

    public int getCombatPower() {
        return combatPower;
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
