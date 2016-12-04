/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;

import model.Rikollinen;


/**
 *
 * @author VStore
 */
public class Käyttöliittymä {

    public void Näytä(String printti){
        System.out.println(printti);
    }
    
    public void getRikolliset(Rikollinen rikollinen){
        Näytä(rikollinen.toString());
    }

}
