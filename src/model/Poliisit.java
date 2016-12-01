/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author VStore
 */
public class Poliisit {

    private int combatPower;
    private ArrayList poliisit;

    Poliisit() {
        this.combatPower = 0;
        this.poliisit = new ArrayList();
    }

    public int getCombatPower() {
        return combatPower;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }
   
}
