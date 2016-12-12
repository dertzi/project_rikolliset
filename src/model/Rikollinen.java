package model;

import java.util.Random;

public class Rikollinen {

    private int maine;
    private int arvo;
    private final String nimi;
    private final String erikoisuus;
    private final String[] nimet = {"Syeda", "Heba", "Nataliia", "Zoey", "Lalla", "Rena",
        "Piippa", "Zena", "Raune", "Soheila", "Semra", "Stanislava",
        "Catja", "Diona", "Eha", "Eleonor", "Lo", "Trina", "Neli",
        "Reem", "Shima", "Joela", "Vlada", "Jin", "Yasmiin", "Anais",
        "Lita", "Loreta", "Pricella", "Vendi", "Annely", "Liliane",
        "Kaste", "Neele", "Su", "Ragnborg", "Tessaliina", "Neva",
        "Seyyed", "Jasmo", "Luuka", "Nic", "Eyal", "Noeli", "Valdo",
        "Abdisalam", "Reo", "Berk", "Araz", "Ikenna", "Ebrahim", "Harro",
        "Hayden", "Walton", "Hille", "Imraan", "Nhu", "Boy", "Visar", "Iko",
        "Jarimatti", "Alon", "Florent", "Matte", "Timofey", "Yrjänä", "Faris"};
    private final String[] erikoisuudet = {"Valvontakamerat", "Yksityisvartijat", "Erikoisvahvistetut kassakaapit", "Laserjärjestelmät", "Koirat", "Lukot"};
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
        //this.erikoisuus = erikoisuudet[random.nextInt(erikoisuudet.length)];
        this.maine = random.nextInt(900) + 100;

        // 20% Todennäköisyys että rikollinen saa erikoisuuden
        if (random.nextInt(6) == 5) {
            this.erikoisuus = erikoisuudet[random.nextInt(erikoisuudet.length)];
        } else {
            this.erikoisuus = "Ei erikoisuutta";
        }

        // Rikollisen arvo on 2000 suurempi jos sillä on erikoisuus
        if (erikoisuus.equals("Ei erikoisuutta")) {
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

    @Override
    public String toString() {
        return nimi + " | " + erikoisuus + " | " + maine;
    }
}
