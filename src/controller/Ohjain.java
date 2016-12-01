/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Arrays;
import model.Poliisi;

/**
 *
 * @author VStore
 */
public class Ohjain {

    public String aloitusvalikko() {
        final String[] valikko = {"Vaihtoehdot", "1. Kohteet", "2. Rikollisjengin jäsenet", "3. Rikollisjengin statsit",
            "4. Välinevarasto", "5. Placeholder", "6. Placeholder"};
        String arrayInString = Arrays.toString(valikko);
        String finalArray = arrayInString.replace(",", " | ");
        String finalArray1 = finalArray.replace("]", "");
        String finalArray2 = finalArray1.replace("[", "");
        return finalArray2;
    }

    public String listPoliisit() {
        Poliisi poliisi = new Poliisi();
        return poliisi.toString();
    }

}
