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
    int CPcache;
    Rikolliset rikolliset;
    private final int poliisiMäärä = 10;

    public Poliisit() {
        for (int i = 0; i < poliisiMäärä; i++) {
            poliisit.add(new Poliisi());
        }
        this.nimi = "Poliisilaitos";
    }

    public String ratsia(Rikolliset rikolliset, Vankila vankila) {
        this.random = new Random();
        Iterator<Rikollinen> it = rikolliset.getJäsenet().iterator();

        while (it.hasNext()) {
            Rikollinen rikollinen = it.next();
            int value = random.nextInt(100);
            if (value >= 50) {
                CPcache = rikolliset.getCombatPower();
                vankila.lisääRikollinen(rikollinen);
                rikolliset.setMaine(rikolliset.getMaine() - rikollinen.getMaine());
                rikolliset.setCombatPower(rikolliset.getCombatPower()-rikolliset.getRikollinenCombatPower(rikollinen));
                it.remove();
                return rikollinen.getNimi() + " joutui kaltereiden taakse poliisiratsian seurauksesta.";
            }

        }

        if (!vankila.vapautuvatRikolliset().isEmpty()) {
            for (Iterator<Rikollinen> it2 = vankila.vapautuvatRikolliset().iterator(); it2.hasNext();) {
                Rikollinen rikollinen = it2.next();
                rikolliset.lisääJäsen(rikollinen);
                rikolliset.setCombatPower(rikolliset.getCombatPower()+rikolliset.getRikollinenCombatPower(rikollinen));
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
        if (!rikolliset.getJäsenet().isEmpty()){
            this.combatPower = rikolliset.getCombatPower() / 10 * 8;
        }else{
            this.combatPower = 0;
        }
        
        String merkkijono = "Poliisilaitoksen jäsenet:\n\n# | Nimi | Arvo | CombatPower \n\nPoliisilaitoksen CombatPower: "+combatPower+"\n\n";
        for (int i = 0 ; i < poliisit.size(); i++){
            merkkijono += (i + 1) + ". " + poliisit.get(i).getNimi() + " | " + poliisit.get(i).getArvo() + " | " + poliisit.get(i).getCombatPower() + "\n";
        }
        return merkkijono;
    }

}
