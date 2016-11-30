/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author andred
 */
public class Kauppa {
    private ArrayList valikoima;
    private final int VALIKOIMAN_KOKO;
    
    public Kauppa() {
       valikoima = new ArrayList();
       VALIKOIMAN_KOKO = 5;
    }
    
    public void päivitäValikoima() {
        for (int i = 0; i < VALIKOIMAN_KOKO; i++) {
            valikoima.add(new Rikollinen());
        }
    }
    
    
}
