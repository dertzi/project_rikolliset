/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymä;

import java.util.Scanner;


/**
 *
 * @author VStore
 */
public class Käyttöliittymä {
    Scanner lukija = new Scanner(System.in);
    
    // Perus printti
    public void Näytä(String printti){
        System.out.println(printti);
    }
    
    // String arvon lukija
    public String LueString(){
        return lukija.next();
    }
    
    // Int arvon lukija
    public int LueInt(){
        return lukija.nextInt();
    }
    

}
