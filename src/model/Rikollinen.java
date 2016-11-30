package model;

import java.util.Random;

public class Rikollinen {
    private int maine;
    private final String nimi;
    private final String erikoisuus;
    private final String[] nimet = {"Jaakko", "Petteri", "Hannu", "Jalmari", "Paha-Poika", "Iso-Paha", "Nyrkki"};
    private final String[] erikoisuudet = {null, null, null, null, null, null, "Hakkeri", "Pommi expertti", "Muskelimies", "Taikuri", "Munkki", "BattlePappi"};
    private final Random random;
    
    public Rikollinen() {
        random = new Random();
        this.nimi = nimet[random.nextInt(nimet.length)];
        this.erikoisuus = erikoisuudet[random.nextInt(erikoisuudet.length)];
        this.maine = random.nextInt(900) + 100;
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

    @Override
    public String toString() {
        return nimi + " | " + erikoisuus + " | " + maine;
    } 
}

