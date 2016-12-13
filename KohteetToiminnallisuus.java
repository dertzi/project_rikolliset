package model;

import java.util.Random;

public class KohteetToiminnallisuus {
    // Luokat ; kohdeMarketti, kohdePankki, ja kohdeVankila perivät
    // tämän luokan pohjan ie. x extends y.
    
    
    Random random;
    String nimi;
    private String[] turvallisuus;
    private int combatPower, vaikeustaso;
    private final String[] turvallisuudet = {"Valvontakamerat", "Yksityisvartijat", "Erikoisvahvistetut kassakaapit", "Laserjärjestelmät", "Koirat", "Lukot"};

    // Perus konstruktori
    public KohteetToiminnallisuus(String nimi, int vaikeustaso) {
        this.random = new Random();
        this.turvallisuus = new String[6];
        this.nimi = nimi;
        this.vaikeustaso = vaikeustaso + 1;
        this.combatPower = (((this.vaikeustaso * this.vaikeustaso) + 4) / 2) * (75 + random.nextInt(35));
        
        for (int i = 0; i < this.vaikeustaso - 1; i++) {
            int randomValue;
            do {
                randomValue = random.nextInt(turvallisuudet.length);
            } while (turvallisuudet[randomValue] == null);
            turvallisuus[i] = turvallisuudet[randomValue];
            turvallisuudet[randomValue] = null;
        }
    }
    
    

    public double getCombatPower() {
        return combatPower;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        return nimi + " | CP " + combatPower + " | Vaikeustaso " + vaikeustaso;
    }
}