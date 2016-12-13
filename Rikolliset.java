package model;

import java.util.ArrayList;

public class Rikolliset {

    private int maine, raha, combatPower;
    private final int ALKU_RAHA = 10000, ALKU_MAINE = 0, ALKU_CP = 0;
    private ArrayList<Rikollinen> jäsenet;

    public Rikolliset() {
        this.combatPower = ALKU_CP;
        this.maine = ALKU_MAINE;
        this.raha = ALKU_RAHA;
        this.jäsenet = new ArrayList<>();

        //Jäseniä ei luoda automaattisesti tässä. Jäsenet lisätään
        //lisääJäsen() metodin kautta ja jäseniä saadaan kaupasta ja/tai vankiloista
        //mahdollisesti lisätään joku tapahtuma joka saattaa lisätä jäseniä.
    }

    public int getCombatPower() {
        päivitäMaineJaCP();
        return combatPower;
    }
    
    public int getRikollinenCombatPower(Rikollinen rikollinen){
        int CombatPower = rikollinen.getMaine() * 3 / 10;
        return CombatPower;
    }

    public int getMaine() {
        return maine;
    }

    public int getRaha() {
        return raha;
    }

    public ArrayList<Rikollinen> getJäsenet() {
        return jäsenet;
    }

    public void setRaha(int määrä) {
        this.raha = määrä;
    }
    
    public void setMaine(int maine){
        this.maine = maine;
    }
    // Tätä funktiota tarvitaan vankila funktion avuksi.
    // jotta siis voidaan poistaa rikollisen antama combatPoweri
    // vankilaolo ajaksi.
    public void setCombatPower(int combatPower){
        this.combatPower = combatPower;
    }

    public void lisääJäsen(Rikollinen jäsen) {
        jäsenet.add(jäsen);
        päivitäMaineJaCP();
    }
    
    public void poistaJäsen(Rikollinen jäsen){
        jäsenet.remove(jäsen);
    }

    private void päivitäMaineJaCP() {
        this.maine = 0;
        for (Rikollinen rikollinen : jäsenet) {
            this.maine += rikollinen.getMaine();
        }
        this.combatPower = this.maine * 3 / 10;
    }
    
    public String perusTiedot() {
        return "Jäseniä: " + jäsenet.size() + " | Maine: " + maine + " | CP: " + combatPower + " | Rahaa: " + raha + "\n";
    }
    
    @Override
    public String toString() {
        String jäsenetMerkkijono = perusTiedot();
        for (int i = 0; i < jäsenet.size(); i++) {
            jäsenetMerkkijono += (i + 1) + ". " + jäsenet.get(i) + " | Hinta: " + jäsenet.get(i).getArvo() + "\n";
        }
        return jäsenetMerkkijono;
    }
}

// setCombatPower pitäisi olla tällä hetkellä hyödytön,
// CombatPower saa arvonsa päivitäMaineJaCP() metodista.
// CombatPower muuttuu vain jos jäsenet muuttuvat, mikä johtaa
// siihen että maine on myös muuttunut.
//public void setCombatPower(int combatPower) {
//    this.combatPower = combatPower;
//}
// Tämä ei kuulu rikkoliset luokkaan. Hoidetaan statsien haku Rikollinen luokan
// toSring funktiolla, getJäsen kutsulla(?). 
// Palauttaa merkkijonon rikollisen statseista
//    public String getRikolliset(int index) {
//        String nullString = "null";
//        if (jäsenet.get(index).getStats().contains(nullString)) {
//            String fixedString = jäsenet.get(index).getStats().replaceAll("null", "Ei erityisosaamista");
//            return fixedString;
//        } else {
//            return jäsenet.get(index).getStats();
//        }
//
//    }
// kontrollerien for loop ei tarvitse omaa funktiota koon hakemiseen.
// Saat getJäsenet().size()/length() tyylillä nuo tiedot irti ilman ylimääräistä
// funktion tarvetta. Parempi tapa hoitaa Jäsenten iteraatio on "for each" loopilla
// for (Rikolliset jäsen : jäsenet) <-- jotenki noin se menee nopeasti.
//    // Palauttaa rikollisten lukumäärän kontrollerin for-looppia varten
//
//    public int getRikollisetInt() {
//        return jäsenet.size();

