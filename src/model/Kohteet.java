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
public class Kohteet {

    private ArrayList<KohdeMarketti> marketit;
    private ArrayList<KohdePankki> pankit;
    private ArrayList<KohdeVankila> vankilat;
    private final int MAKSIMI_PER_KOHDE = 5;
    
    public Kohteet() {
        marketit = new ArrayList<>();
        pankit  = new ArrayList<>();
        vankilat  = new ArrayList<>();
        
        for (int i = 0; i < MAKSIMI_PER_KOHDE; i++) {
            marketit.add(new KohdeMarketti());
            pankit.add(new KohdePankki());
            vankilat.add(new KohdeVankila());
        }
    }

    @Override
    public String toString() {
        return marketit.get(0).getNimi() + ", " + marketit.get(0).getRandomTurvallisuus();
    }
    
}
