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

    // Kaupan luonti (konstruktori)
    public Kauppa() {
        valikoima = new ArrayList<>();
        VALIKOIMAN_KOKO = 5;

    }
    
    // Kaupan valikoiman päivitys
    public void päivitäValikoima() {
        valikoima.clear();
        for (int i = 0; i < VALIKOIMAN_KOKO; i++) {
            valikoima.add(new Rikollinen());
        }
    }
    
    // Rikollisjäsenen poisto kaupan valikoimasta session ajaksi (ei jää turhaan roikkumaan listalle)
    public void poistaJäsenValikoimasta(int indeksi){
        valikoima.remove(indeksi-1);
        VALIKOIMAN_KOKO -= 1;
    }
    
    // rikollisen hinta
    public int jäsenArvo(int indeksi) {
        return valikoima.get(indeksi-1).getArvo();
    }
    
    // olion palautus
    public Rikollinen getJäsen(int indeksi){
        return valikoima.get(indeksi-1);
    }

    // Merkkijonon palautus (kaupan valikoiman rikolliset)
    public String toString(int i) {
        String valikoimaMerkkijono = (i+1) + ". " + valikoima.get(i).getNimi() + " | Hinta: " + valikoima.get(i).getArvo() + "\n";
        return valikoimaMerkkijono;
    }

    // palauttaa kaupan valikoiman koon
    public int getValikoimanKoko(){
        return VALIKOIMAN_KOKO;
    }
}
