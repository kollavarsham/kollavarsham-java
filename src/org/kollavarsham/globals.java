package org.kollavarsham;

/*
 * kollavarsham
 * http://kollavarsham.org
 *
 * Copyright (c) 2014 The Kollavarsham Team
 * Licensed under the MIT license.
 */

public class globals {
    public Double yugaCivilDays = 1.0;
    public Double yugaSynodicMonth = 1.0;
    public Double yugaAdhimasa = 1.0;
    public Double yugaTithi = 1.0;
    public Double yugaKsayadina = 1.0;

    public Double backClongAhar = -1.0;
    public Double backNclongAhar = -1.0;
    public Double backClong = -1.0;
    public Double backNclong = -1.0;

    //    type  paksas :(suklapaksa, krsnapaksa),
    public Double year = 1.0;
    public String paksa = "";

    // (suklapaksa, krsnapaksa),
    public Double ahar = 1.0; // {for ahargana}
    public Double ahargana = 1.0;
    public Double julianDay = 1.0; // {for Julian days}
    public Double yearKali = 1.0;
    public Double yearSaka = 1.0;
    public Double yearVikrama = 1.0;
    public Double masaNum = 1.0;
    public String sauraMasa = "";
    public Double sauraMasaNum = 1.0;
    public Double sauraMasaDay = 1.0;
    public String malayalaMasa = ""; // HP
    public Double malayalaMasaNum = 1.0; // HP
    public Double MalayalamYear = 1.0;
    public String weekdayName = "";
    public double tithiDay = 1.0;
    public Double mslong = 1.0; // {solar position}
    public Double tslong = 1.0; // {solar position}
    public Double mllong = 1.0; // {lunar position}
    public Double tllong = 1.0; // {lunar position}
    public Double clong = 1.0;
    public Double nclong = 1.0;
    public Double tithi = 1.0;
    public double ftithi = 1.0;
    public Double eqtime = 1.0; // {for equation of time}
    public Double sriseh = 1.0;
    public Double srisem = 1.0;
    public String suklaKrsna;
    public String adhimasa = "";
    public String masa = "";
    public String naksatra = "";
    public String malayalaNaksatra = "";

    public Double samkranti = 1.0;
    public Double samkrantiYear = 1.0;
    public Double samkrantiMonth = 1.0;
    public Double samkrantiDay = 1.0;
    public Double samkrantiHour = 1.0;
    public Double samkrantiMin = 1.0;

    public Double ayanadeg = 1.0;
    public double ayanamin = 1.0;
    public Double desantara = 0.0; // actually it is `(kollavarsham.settings.longitude - locations.Ujjain.longitude) / 360` =~ 0

    private static globals instance = null;

    protected globals() {
        // Exists only to defeat instantiation.
    }

    public static globals getInstance() {
        if (instance == null) {
            instance = new globals();
        }
        return instance;
    }
    
    public void setDesantara(Double longitude, Double ujjainLongitude) {
        this.desantara = (longitude - ujjainLongitude) / 360;
    }

}
