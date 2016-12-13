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
    private String arvo;
    private int combatPower;
    private final String[] nimet = {"Dennis","Johnny","Scottie","Todd","Stuart","Antione","Ismael","Abram","Hugh","Marlon","Ned","Vincent"
    ,"Alberto","Jan","Elvis","Levi","Vito","Frances","Christian","Carrol","Burton","Irvin","Thurman","Desmond","Pat","Darryl","Clifton","Clyde",
    "Lelah","Marivel","Camelia","Antonietta","Elsy","Leone","Shawnna","Rachele","Carolynn","Natisha","Yolando","Joselyn","Gabriela","Kamilah","Alissa",
    "Loise","Emma","Zella","Tomeka","Kristeen"};
    
    private final String[] arvoAste1 = {"Poliisiylijohtaja","Poliisijohtaja","Keskusrikospoliisin päällikkö","Suojelupoliisin päällikkö","Poliisiammattikorkeakoulun rehtori",
    "Poliisipäällikkö","Poliisiylitarkastaja"};
    private final String[] arvoAste2 = {"Keskusrikospoliisin apulaispäällikkö","Suojelupoliisin apulaispäällikkö","Apulaispoliisipäällikkö","Poliisilakimies"};
    private final String[] arvoAste3 = {"Poliisitarkastaja","Osastopäällikkö","Rikosylitarkastaja","Rikostarkastaja","Ylikomisario","Rikosylikomisario","Ylitarkastaja",
    "Komisario","Rikoskomisario","Tarkastaja"};
    private final String[] arvoAste4 = {"Ylikonstaapeli","Rikosylikonstaapeli","Ylietsivä","Vanhempi konstaapeli","Etsivä"};
    private final String[] arvoAste5 = {"Nuorempi konstaapeli"};
    private final Random random;

    Poliisi() {
        random = new Random();
        this.nimi = nimet[random.nextInt(nimet.length - 1)];
        int randomArvo = random.nextInt(5);
        switch(randomArvo){
            case 0:
                this.arvo = arvoAste1[random.nextInt(arvoAste1.length-1)];
                break;
            case 1:
                this.arvo = arvoAste1[random.nextInt(arvoAste1.length-1)];
                break;
            case 2:
                this.arvo = arvoAste2[random.nextInt(arvoAste2.length-1)];
                break;
            case 3:
                this.arvo = arvoAste3[random.nextInt(arvoAste3.length-1)];
                break;
            case 4:
                this.arvo = arvoAste4[random.nextInt(arvoAste4.length-1)];
                break;
            case 5:
                this.arvo = arvoAste5[random.nextInt(arvoAste5.length-1)];
                break;
        }
    }
    public void setNimi(String nimi){
        this.nimi = nimi;
    }
    public String getNimi(){
        return nimi;
    }
    
    public String getArvo(){
        return arvo;
    }
    
    public int getCombatPower(){
        return combatPower;
    }
    
    public void setCombatPower(int CP){
        this.combatPower = CP;
    }
            
    @Override
    public String toString(){
        return nimi;
    }
}
