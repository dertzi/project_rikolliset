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
    private int VALIKOIMAN_KOKO;

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
    
    public void poistaJäsenValikoimasta(int indeksi){
        valikoima.remove(indeksi-1);
        VALIKOIMAN_KOKO -= 1;
    }

    public int jäsenArvo(int indeksi) {
        return valikoima.get(indeksi-1).getArvo();
    }
    
    public Rikollinen getJäsen(int indeksi){
        return valikoima.get(indeksi-1);
    }

    public String toString(int i) {
        String valikoimaMerkkijono = (i+1) + ". " + valikoima.get(i).getNimi() + " | Hinta: " + valikoima.get(i).getArvo() + "\n";
        return valikoimaMerkkijono;
    }
    
    public int getValikoimanKoko(){
        return VALIKOIMAN_KOKO;
    }
}
