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
    // Muutin parametrin tyypiksi "Object" Stringin tilalle.
    // näin pystymme tulostamaan kaikki tyypit (String/kauppa/int/jne jnejne)
    public void näytä(Object printti) {
        System.out.println(printti);
    }
    
    // String arvon lukija
    public String lueString(){
        return lukija.next();
    }
    
    // Int arvon lukija
    public int lueInt(){
        return lukija.nextInt();
    }
    

}
