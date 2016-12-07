/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;

import java.util.Scanner;
import model.Rikollinen;


/**
 *
 * @author VStore
 */
public class Käyttöliittymä {
    Scanner lukija = new Scanner(System.in);

    public void Näytä(String printti){
        System.out.println(printti);
    }
    
    public String LueString(){
        return lukija.next();
    }
    
    public int LueInt(){
        return lukija.nextInt();
    }
    
    public void getRikolliset(Rikollinen rikollinen){
        Näytä(rikollinen.toString());
    }

}
