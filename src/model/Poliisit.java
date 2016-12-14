/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author VStore
 */
public class Poliisit {

    private String nimi;
    private int combatPower;
    private ArrayList<Poliisi> poliisit = new ArrayList<>();
    private Random random;
    Vankila vankila = new Vankila();
    Rikolliset rikolliset;
    private final int poliisiMäärä = 10;

    public Poliisit() {
        for (int i = 0; i < poliisiMäärä; i++) {
            poliisit.add(new Poliisi());
        }
        this.nimi = "Poliisilaitos";
    }

    public String ratsia(Rikolliset rikolliset, Vankila vankila) {
        int vankilaAika = 5;
        this.random = new Random();
        Iterator<Rikollinen> it = rikolliset.getJäsenet().iterator();

        while (it.hasNext()) {
            Rikollinen rikollinen = it.next();
            int value = 0;
            value = random.nextInt(100)+1;
            if (value >= 97) {
                String merkkijono = "";
                int raha = rikolliset.getRaha();
                if (raha > 0){
                    int rahaVähennys = (raha/20) * (random.nextInt(2)+1);
                    if (raha-rahaVähennys < 0){
                        rikolliset.setRaha(0);
                    }else{
                        rikolliset.setRaha(raha-rahaVähennys);
                        merkkijono += "\nPoliisi sakotti rikollisjengiä : " + "- " + rahaVähennys+"\n";
                    }
                    
                }
                
                vankila.lisääRikollinen(rikollinen, vankilaAika);
                rikolliset.setMaine(rikolliset.getMaine() - rikollinen.getMaine());
                rikolliset.setCombatPower(rikolliset.getCombatPower() - rikolliset.getRikollinenCombatPower(rikollinen));
                it.remove();
                merkkijono += rikollinen.getNimi() + " joutui kaltereiden taakse poliisiratsian seurauksesta.";
                return merkkijono;
            }

        }

        if (!vankila.vapautuvatRikolliset().isEmpty()) {
            for (Iterator<Rikollinen> it2 = vankila.vapautuvatRikolliset().iterator(); it2.hasNext();) {
                Rikollinen rikollinen = it2.next();
                rikolliset.lisääJäsen(rikollinen);
                rikolliset.setCombatPower(rikolliset.getCombatPower() + rikolliset.getRikollinenCombatPower(rikollinen));
                vankila.resetVapautuvatRikolliset();
                
                return rikollinen.getNimi() + ", vapautui vankilasta.";
            }
        }
        return "";
    }

    public int getCombatPower() {
        return combatPower;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

    public String toString(Rikolliset rikolliset) {
        if (!rikolliset.getJäsenet().isEmpty()) {
            this.combatPower = rikolliset.getCombatPower() / 10 * 8;
        } else {
            this.combatPower = 0;
        }

        String merkkijono = "Poliisilaitoksen jäsenet:\n\n# | Nimi | Arvo \n\n";
        for (int i = 0; i < poliisit.size(); i++) {
            merkkijono += (i + 1) + ". " + poliisit.get(i).getNimi() + " | " + poliisit.get(i).getArvo() + " | " + "\n";
        }
        merkkijono += "\n\nPoliisilaitoksen CombatPower: " + combatPower + "\n\n";
        return merkkijono;
    }

}
