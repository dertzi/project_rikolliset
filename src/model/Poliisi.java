/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author VStore
 */
public class Poliisi {

    // Tämä luokka melko vajavainen vielä, pitää kattoa myöhemmin
    private String nimi;
    private final String[] nimet = {"Timo", "Joni", "Kasper", "Pekka", "Jouni", "Kalle", "Pentti"};
    private final Random random;

    public Poliisi() {
        random = new Random();
        this.nimi = nimet[random.nextInt(nimet.length - 1)];
    }
    public void setNimi(String nimi){
        this.nimi = nimi;
    }
    public String getNimi(){
        return nimi;
    }
    @Override
    public String toString(){
        return nimi;
    }
}
