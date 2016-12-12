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
    private final String[] nimet = {"Dennis","Johnny","Scottie","Todd","Stuart","Antione","Ismael","Abram","Hugh","Marlon","Ned","Vincent"
    ,"Alberto","Jan","Elvis","Levi","Vito","Frances","Christian","Carrol","Burton","Irvin","Thurman","Desmond","Pat","Darryl","Clifton","Clyde",
    "Lelah","Marivel","Camelia","Antonietta","Elsy","Leone","Shawnna","Rachele","Carolynn","Natisha","Yolando","Joselyn","Gabriela","Kamilah","Alissa",
    "Loise","Emma","Zella","Tomeka","Kristeen"};
    private final Random random;

    Poliisi() {
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
