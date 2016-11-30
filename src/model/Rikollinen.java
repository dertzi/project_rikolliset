package model;

import java.util.Random;

public class Rikollinen {
    private String nimi;
    private String erikoisuus;
    private int maine;
    private final String[] nimet = {"Jaakko", "Petteri", "Hannu", "Jalmari", "Paha-Poika", "Iso-Paha", "Nyrkki"};
    private final String[] erikoisuudet = {null, null, null, null, null, null, "Hakkeri", "Pommi expertti", "Muskelimies", "Taikuri", "Munkki", "BattlePappi"};
    private final Random random;
    
    public Rikollinen() {
        random = new Random();
        this.nimi = nimet[random.nextInt(nimet.length - 1)];
        this.erikoisuus = erikoisuudet[random.nextInt(erikoisuudet.length - 1)];
        this.maine = random.nextInt(900) + 100;
    }
    
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getErikoisuus() {
        return erikoisuus;
    }

    public void setErikoisuus(String erikoisuus) {
        this.erikoisuus = erikoisuus;
    }

    public int getMaine() {
        return maine;
    }

    public void setMaine(int maine) {
        this.maine = maine;
    }

    @Override
    public String toString() {
        return nimi + " | " + erikoisuus + " | " + maine;
    } 
}

