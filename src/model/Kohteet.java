/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Hanne
 */
public class Kohteet {
    
    private String nimi, turvallisuus;
    private double cpDouble, random;
    private int cp, vaikeustaso;
    
    public Kohteet(int vaikeustaso) {
        this.vaikeustaso = vaikeustaso;
    }
    
    public Kohteet() {
        double vaikeusDouble = laskeRandom(1.0, 7.0);
        vaikeustaso = (int)vaikeusDouble;
        
    }
    
    public double getCp() {
        switch (vaikeustaso) {
            case 1:
                cpDouble = laskeRandom(1.0, 10.0);
                break;
            case 2:
                cpDouble = laskeRandom(11.0, 20.0);
                break;
            case 3:
                cpDouble = laskeRandom(21.0, 30.0);
                break;
            case 4:
                cpDouble = laskeRandom(31.0, 40.0);
                break;
            case 5:
                cpDouble = laskeRandom(41.0, 50.0);
                break;
            case 6:
                cpDouble = laskeRandom(51.0, 60.0);
                break;
            case 7:
                cpDouble = laskeRandom(61.0, 70.0);
                break;
        }
        cp = (int)cpDouble;
        return cp;
    }
    
    public String getNimi() {
        ArrayList<String> kohteenNimi = new ArrayList<String>();
        kohteenNimi.add("Marketti");
        kohteenNimi.add("Pankki");
        kohteenNimi.add("Vankila");
        
        String nimi = kohteenNimi.get(new Random().nextInt(kohteenNimi.size()));
        return nimi;
    }
    
    public String getRandomTurvallisuus() {
        ArrayList<String> mahdTurvallisuus = new ArrayList<String>();
        mahdTurvallisuus.add("Sähköinen turvajärjestelmä");
        mahdTurvallisuus.add("Yksityisvartijoita");
        mahdTurvallisuus.add("Erikoisvahvistettu kassakaappi");
        
        String RandomTurvallisuus = mahdTurvallisuus.get(new Random().nextInt(mahdTurvallisuus.size()));
        return RandomTurvallisuus;
    }
    
    public void getTurvallisuus(int määrä) {
        boolean turvaFound;
        String turva;
        ArrayList<String> kohteenTurvallisuus = new ArrayList<String>();
        for(int i = 1; i <= määrä; i++) {
            do {
                turva = getRandomTurvallisuus();
                turvaFound = kohteenTurvallisuus.contains(turva);
            } while (turvaFound = true);
            kohteenTurvallisuus.add(turva);        
        }
        for (int i = 0; i < kohteenTurvallisuus.size(); i++) {
            String arvo = kohteenTurvallisuus.get(i);
            System.out.println(arvo);
        }
    }

    
    public double laskeRandom(double min, double max) {        
        double minimi = min;
        double maksimi = max;
        random = Math.random()*(maksimi-minimi) + minimi;
        return random;
    }
    
    
    public String getStats() {
        return nimi+" | CP "+cp+" | Vaikeustaso "+vaikeustaso;
    }
            
}
