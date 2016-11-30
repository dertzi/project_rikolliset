package model;

import java.util.ArrayList;

public class Rikkolliset {

    private int combatPower;
    private int maine;
    private int raha;
    private final int ALKU_RAHA = 10000;
    private ArrayList jäsenet;

    public Rikkolliset() {
        this.combatPower = 0;
        this.maine = 0;
        this.jäsenet = new ArrayList();
        this.raha = ALKU_RAHA;
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
