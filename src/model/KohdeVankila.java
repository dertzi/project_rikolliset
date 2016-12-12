package model;

public class KohdeVankila extends KohteetToiminnallisuus {
    int vankienMäärä;

    public KohdeVankila(String nimi, int vaikeustaso) {
        super(nimi, vaikeustaso);
        vankienMäärä = 0; // Joku random 1-jotain välillä.
    }
    
    // Jos hyökkäys onnistuu, tehdään joku looppi että vankienMäärän verran tehdään todennäköisyys tarkistus
    // että kuinka monta rikollista jengi saa itelleen lisää. Siinä kohtaa sitte luodaan uudet rikolliset ja lähetetään
    // Rikkolliset oliolle. Vai pitäisikö ne luoda suoraan Rikolliset olion funktiolla lisää(new Rikollinen)??? :)

}
