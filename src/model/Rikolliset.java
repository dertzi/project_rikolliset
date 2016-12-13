package model;

import java.util.ArrayList;

public class Rikolliset {
    
    private ArrayList<String> erikoisuudet;
    private int maine, raha, combatPower;
    private final int ALKU_RAHA = 15000, ALKU_MAINE = 0, ALKU_CP = 0;
    private ArrayList<Rikollinen> jäsenet;

    public Rikolliset() {
        this.erikoisuudet = new ArrayList<>();
        this.combatPower = ALKU_CP;
        this.maine = ALKU_MAINE;
        this.raha = ALKU_RAHA;
        this.jäsenet = new ArrayList<>();

        //Jäseniä ei luoda automaattisesti tässä. Jäsenet lisätään
        //lisääJäsen() metodin kautta ja jäseniä saadaan kaupasta ja/tai vankiloista
        //mahdollisesti lisätään joku tapahtuma joka saattaa lisätä jäseniä.
       
    }

    public int getCombatPower() {
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

    public ArrayList<String> getErikoisuudet() {
        return erikoisuudet;
    }
    
    public ArrayList<Rikollinen> getJäsenet() {
        return jäsenet;
    }

    public void setRaha(int määrä) {
        this.raha = määrä;
    }

    public void setMaine(int maine) {
        this.maine = maine;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

    public void lisääJäsen(Rikollinen jäsen) {
        jäsenet.add(jäsen);
        päivitäRikollistenTiedot();
    }

    public void poistaJäsen(Rikollinen jäsen) {
        jäsenet.remove(jäsen);
        päivitäRikollistenTiedot();
    }
    
    // funktio päivittää jengin erikoisuudet, maineen ja CPn ajan tasalle!
    public void päivitäRikollistenTiedot() {
        this.maine = 0;
        this.erikoisuudet.clear();
        for (Rikollinen rikollinen : jäsenet) {
            this.maine += rikollinen.getMaine();
            String rikollisenErikoisuus = rikollinen.getErikoisuus();
            if (!rikollisenErikoisuus.equals(rikollinen.getEI_ERIKOISUUTTA()) && !this.erikoisuudet.contains(rikollisenErikoisuus)) {
                this.erikoisuudet.add(rikollisenErikoisuus);
            }
        }
        this.combatPower = this.maine * 4 / 10;
    }
    
    public String perusTiedot() {
        return "Jäseniä: " + jäsenet.size() + " | Maine: " + maine + " | CP: " + combatPower + " | Rahaa: " + raha + "\n";
    }

    public void checkVankila() {

    }

    @Override
    public String toString() {
        String jäsenetMerkkijono = perusTiedot();
        for (int i = 0; i < jäsenet.size(); i++) {
            jäsenetMerkkijono += (i + 1) + ". " + jäsenet.get(i).getNimi() + " | Maine: " + jäsenet.get(i).getMaine() + "| " + jäsenet.get(i).getErikoisuus()+"\n";
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

