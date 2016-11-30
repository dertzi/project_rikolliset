/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import java.util.Scanner;

/**
 *
 * @author andred
 */
public class Käyttöliittymä {
    
public static void main(String[] args){
    Scanner lukija = new Scanner(System.in);
    controller.Ohjain ohjain = new controller.Ohjain();
    
    System.out.println("Tervetuloa rikolliset simulaatiopeliin");
    System.out.println("\nTämä simulaatio on diibadaaba...");
    int i=0;
    do{
        System.out.println("\nAloitetaanko simulaatio? (k/e)\n");
        String valinta = lukija.next();
        if(valinta.equals("k")| valinta.equals("K")){
            System.out.println("Hienoa, lähdetään liikeelle.");
            ohjain.aloitusvalikko();
        }
        
    }while(i==0);
}
}