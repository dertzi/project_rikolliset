package model;

import java.util.Random;

public class Rikollinen {
    private int maine;
    private int arvo;
    private final String nimi;
    private final String erikoisuus;
    private final String[] nimet = {"Jaakko", "Petteri", "Hannu", "Jalmari", "Paha-Poika", "Iso-Paha", "Nyrkki"};
    private final String[] erikoisuudet = {null, null, null, null, null, null,"Hakkeri", "Pommi expertti", "Muskelimies", "Taikuri", "Munkki", "BattlePappi"};
    private final Random random;
    
    public Rikollinen() {
        
        // Pitäisikö nimet laittaa tiedostoon ja lukea sieltä?
        // vai kovakoodata nimet tänne jättimäisenä listana?
        // Scannerilla voi lukea tiedostoja, mutta pitäisi laittaa toistoja
        // konstruktoriin ja vielä sijoittaa listaan. Toinen vaihtoehto olisi
        // List<String> lines = FileUtils.readLines(new File("/path/to/file.txt"), "utf-8");
        // käyttäen commons.io:ta joka on ulkoinen kirjasto joka pitäisi sitten ladata.
        
        this.random = new Random();
        this.nimi = nimet[random.nextInt(nimet.length)];
        this.erikoisuus = erikoisuudet[random.nextInt(erikoisuudet.length)];
        this.maine = random.nextInt(900) + 100;
        
        if (erikoisuus == null) {
        this.arvo = maine * 13;
        } else {
            this.arvo = maine * 13 + 2000;
        }
    }
    
    public String getNimi() {
        return nimi;
    }

    public String getErikoisuus() {
        return erikoisuus;
    }

    public int getMaine() {
        return maine;
    }

    public int getArvo() {
        return arvo;
    }
    
    public String getStats() {
        return nimi + " | " + erikoisuus + " | " + maine;
    } 
}

