package Käyttöliittymä;

import java.util.Scanner;

public class Käyttöliittymä {

    Scanner lukija = new Scanner(System.in);

    // Perus printti
    // Muutin parametrin tyypiksi "Object" Stringin tilalle.
    // näin pystymme tulostamaan kaikki tyypit (String/kauppa/int/jne jnejne)
    public void näytä(Object printti) {
        System.out.print(printti);
    }
    
    public void näytäln(Object printti) {
        System.out.println(printti);
    }

    // String arvon lukija
    public String lueString() {
        return lukija.nextLine();
    }

    // Int arvon lukija
    public int lueInt() {
        while (!lukija.hasNextInt()) {
            näytäln("Virheellinen arvo, syötä kokonaisluku!");
            lukija.next();
            näytä("Valinta: ");
        }
        return lukija.nextInt();
    }
    
    //"Pyyhkii" konsoli ikkunan
    public void clear() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}
