package model;

import java.util.Random;

public class KohteetToiminnallisuus {

    Random random;
    String nimi;
    private String[] turvallisuus = {null, null, null, null, null, null};
    private int combatPower, vaikeustaso, raha;
    private final String[] turvallisuudet = {"Valvontakamerat", "Yksityisvartijat", "Erikoisvahvistetut kassakaapit", "Laserjärjestelmät", "Koirat", "Lukot"};

    public KohteetToiminnallisuus(String nimi, int vaikeustaso) {
        this.random = new Random();
        this.nimi = nimi;
        this.vaikeustaso = vaikeustaso + 1;
        this.combatPower = (((this.vaikeustaso * this.vaikeustaso) + 4) / 2) * (75 + this.random.nextInt(35));
        this.raha = (((5000 * this.vaikeustaso) + 897) / 2) * (this.random.nextInt(2) + 1);

        for (int i = 0; i < this.vaikeustaso - 1; i++) {
            int randomValue;
            do {
                randomValue = this.random.nextInt(this.turvallisuudet.length);
            } while (this.turvallisuudet[randomValue] == null);
            this.turvallisuus[i] = this.turvallisuudet[randomValue];
            this.turvallisuudet[randomValue] = null;
        }
    }

    public int getRaha() {
        return raha;
    }

    public void nostaVaikeutta() {
        ++this.vaikeustaso;
        this.combatPower = (((this.vaikeustaso * this.vaikeustaso) + 4) / 2) * (75 + this.random.nextInt(35));
        this.raha = (((3000 * this.vaikeustaso) + 897) / 2) * (this.random.nextInt(2)+1);
        if (this.vaikeustaso < 8) {
            for (int i = 0; i < this.vaikeustaso - 1; i++) {
                int randomValue;
                do {
                    randomValue = this.random.nextInt(this.turvallisuudet.length);
                } while (this.turvallisuudet[randomValue] == null);
                if (this.turvallisuus[i] == null) {
                    this.turvallisuus[i] = this.turvallisuudet[randomValue];
                    this.turvallisuudet[randomValue] = null;
                }
            }
        }
    }
    
    public void setNewRaha(){
        this.raha = (((5000 * this.vaikeustaso) + 897) / 2) * (this.random.nextInt(2) + 1);
    }

    public int getCombatPower() {
        return combatPower;
    }

    public String getNimi() {
        return nimi;
    }

    public String[] getTurvallisuus() {
        return turvallisuus;
    }

    @Override
    public String toString() {
        return nimi + " | CP " + combatPower + " | Vaikeustaso " + vaikeustaso;
    }
}
