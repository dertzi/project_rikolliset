package model;

import java.util.ArrayList;

public class Rikkolliset {
    private int combatPower;
    private int maine;
    private ArrayList jäsenet;

    public Rikkolliset() {
        this.combatPower = 0;
        this.maine = 0;
        this.jäsenet = new ArrayList();
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

    public void setMaine(int maine) {
        this.maine = maine;
    }
    
}