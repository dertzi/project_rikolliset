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
    private ArrayList<Rikollinen> valikoima;
    private final int VALIKOIMAN_KOKO;
    
    public Kauppa() {
       valikoima = new ArrayList<>();
       VALIKOIMAN_KOKO = 5;
       
    }
    
    public void päivitäValikoima() {
        valikoima.clear();
        for (int i = 0; i < VALIKOIMAN_KOKO; i++) {
            valikoima.add(new Rikollinen());
        }
    }
    
    public Rikollinen ostaJäsen(int indeksi) {
        return valikoima.get(indeksi);
    }
    
    @Override
    public String toString() {
        String valikoimaMerkkijono = "";
        for (int i = 0; i < VALIKOIMAN_KOKO; i++) {
            valikoimaMerkkijono += (i + 1) + ". " + valikoima.get(i) + " | Hinta: " + valikoima.get(i).getArvo() + "\n";
        }
        return valikoimaMerkkijono;
    }
}
