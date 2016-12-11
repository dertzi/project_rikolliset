package model;

import java.util.ArrayList;

public class Kohteet {

    private ArrayList<KohdeMarketti> marketit;
    private ArrayList<KohdePankki> pankit;
    private ArrayList<KohdeVankila> vankilat;
    private final int MAKSIMI_PER_KOHDE = 5;

    // kohteiden luominen (konstruktori)
    public Kohteet() {
        marketit = new ArrayList<>();
        pankit = new ArrayList<>();
        vankilat = new ArrayList<>();

        for (int i = 0; i < MAKSIMI_PER_KOHDE; i++) {
            marketit.add(new KohdeMarketti());
            pankit.add(new KohdePankki());
            vankilat.add(new KohdeVankila());
        }
        for (int k = 0 ; k < MAKSIMI_PER_KOHDE; k++){
            marketit.get(k).setNimiMarketti();
            marketit.get(k).setCP();
            
            pankit.get(k).setNimiPankki();
            pankit.get(k).setCP();
            
            vankilat.get(k).setNimiVankila();
            vankilat.get(k).setCP();
        }
    }
    
    public int getMarkettiInt(){
        return marketit.size();
    }
    
    public int getPankkiInt(){
        return pankit.size();
    }
    
    public int getVankilaInt(){
        return vankilat.size();
    }
    
    public String getMarketti(int numero) {
        return marketit.get(numero).getStats();
    }
    
    public String getPankki(int numero){
        return pankit.get(numero).getStats();
    }
    
    public String getVankila(int numero){
        return vankilat.get(numero).getStats();
    }

    @Override
    public String toString() {
        return marketit.get(0).getNimi() + ", " + marketit.get(0).getRandomTurvallisuus();
    }

}
