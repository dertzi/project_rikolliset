package model;

import java.util.ArrayList;

public class Rikkolliset {

    private int maine, raha, combatPower;
    private final int ALKU_RAHA = 10000, ALKU_MAINE = 0, ALKU_CP = 0;
    private ArrayList<Rikollinen> jäsenet;

    public Rikkolliset() {
        this.combatPower = ALKU_CP;
        this.maine = ALKU_MAINE;
        this.raha = ALKU_RAHA;
        this.jäsenet = new ArrayList<>();
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

    public void setRaha(int määrä) {
        this.raha = määrä;
    }

    public void lisääJäsen(Rikollinen jäsen) {
        jäsenet.add(jäsen);
        päivitäMaine();
    }
    

    private void päivitäMaine() {
        this.maine = 0;
        for (Rikollinen rikollinen : jäsenet) {
            this.maine += rikollinen.getMaine();
        }
    }
}
