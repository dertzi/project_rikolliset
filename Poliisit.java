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

    private int combatPower;
    private ArrayList poliisit;
    private Random random;
    Vankila vankila = new Vankila();
    int CPcache;

    public Poliisit() {
        this.combatPower = 0;
        this.poliisit = new ArrayList<>();
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
                rikolliset.setMaine(rikolliset.getMaine()-rikollinen.getMaine());
                rikolliset.setCombatPower(0);
                it.remove();
                return rikollinen.getNimi() + " joutui kaltereiden taakse poliisiratsian seurauksesta.";
            }

        }
        
        if (!vankila.vapautuvatRikolliset().isEmpty()){
            for (Iterator<Rikollinen> it2 = vankila.vapautuvatRikolliset().iterator(); it2.hasNext();) {
                Rikollinen rikollinen = it2.next();
                rikolliset.lisääJäsen(rikollinen);
                rikolliset.setCombatPower(CPcache);
                vankila.resetVapautuvatRikolliset();
                return rikollinen.getNimi() + ", vapautui vankilasta";
            }
        }
        
        //if (!vankila.getRikolliset().isEmpty()) {
        //    String merkkijono = "Vankilassa olevat rikolliset: \n";
        //    merkkijono += vankila.toString();
        //    return merkkijono;
        //}

        return "";
    }

    public int getCombatPower() {
        return combatPower;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

}
