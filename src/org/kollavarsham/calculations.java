package org.kollavarsham;

import java.util.Calendar;

/*
 * kollavarsham
 * http://kollavarsham.org
 *
 * Copyright (c) 2014 The Kollavarsham Team
 * Licensed under the MIT license.
 */

public class calculations {

    calendar myCalendar;
    celestial myCelestial;
	Double ahargana = 1.0;
	Double julianDay = 1.0; // {for Julian days}
	Double yearKali = 1.0;
	Double yearSaka = 1.0;
	Double yearVikrama = 1.0;
	Double masaNum = 1.0;
	String sauraMasa = "";
	Double sauraMasaNum = 1.0;
	Double sauraMasaDay = 1.0;
	
	public String malayalaMasa = ""; // HP
	public Double malayalaMasaNum = 1.0; // HP
	public Double MalayalamYear = 1.0;
	
	String weekdayName = "";
	Double mslong = 1.0; // {solar position}
	Double tslong = 1.0; // {solar position}
	Double mllong = 1.0; // {lunar position}
	Double tllong = 1.0; // {lunar position}
	Double clong = 1.0;
	Double nclong = 1.0;
	Double tithi = 1.0;
	Double eqtime = 1.0; // {for equation of time}
	String adhimasa = "";
	String masa = "";
	String naksatra = "";
	public String malayalaNaksatra = "";

    public calculations() {
        myCalendar = new calendar();
        myCelestial = celestial.getInstance();
    }

    public void _setConstants(Boolean bija) {
        // TODO: Add Tests if/when feasible
        myCelestial.setPrimaryConstants();
        if (bija) {
            myCelestial.applyBija();
        }
        myCelestial.setSecondaryConstants();
        myCelestial.setPlanetaryConstants();
    };
    
    public void setDesantara(Double longitude, Double defaultLongitude){
    	myCalendar.setDesantara(longitude, defaultLongitude);
    }

    public void FromGregorian(Boolean bija, Double latitude, Calendar gregorianDate) {
        //Java port
        //Settings will come from the global instance of this application where we would have provided the set APIs for it
        //For now I am going to use the hardcoded values for the settings bija and latitude that is going to be used in this method
        bija = false;
        latitude = 23.2;
        // TODO: Add Tests if/when feasible
        _setConstants(bija);
        // This is how it is done in Perl - we use the new gregorianDate global
        //globals.JulianDay = calendar.gregorianDateToJulianDay(new Date(globals.year, globals.month - 1, globals.day));
        this.julianDay = myCalendar.gregorianDateToJulianDay(gregorianDate);
        myCelestial.ahar = myCalendar.julianDayToAhargana(this.julianDay);
        this.julianDay = KollavarshamMath.truncate(this.julianDay + 0.5);
        this.ahargana = KollavarshamMath.truncate(myCelestial.ahar + 0.5);
        this.weekdayName = myCalendar.julianDayToWeekday(this.julianDay);
        myCelestial.year = (double) gregorianDate.get(Calendar.YEAR);
        myCelestial.setAyanamsa(this.ahargana);

        // at 6 o'clock
        myCelestial.ahar += 0.25;

        // desantara
        myCelestial.ahar -= myCalendar.desantara;

        // time of sunrise at local latitude
        this.eqtime = myCelestial.getDaylightEquation(myCelestial.year, latitude);
        myCelestial.ahar -= this.eqtime;
        myCelestial.setSunriseTime(this.eqtime);

        // Lunar apogee and node at sunrise
        myCelestial.PlanetMeanPosition.put("Candrocca", (Double) myCelestial.getMeanLongitude(myCelestial.ahar, (Double) myCelestial.YugaRotation.get("Candrocca")) + 90);
        myCelestial.PlanetMeanPosition.put("Candrocca", myCelestial.zero360((Double) myCelestial.PlanetMeanPosition.get("Candrocca")));

        myCelestial.PlanetMeanPosition.put("Rahu", myCelestial.getMeanLongitude(myCelestial.ahar, (Double) myCelestial.YugaRotation.get("Rahu")) + 180);
        myCelestial.PlanetMeanPosition.put("Rahu", myCelestial.zero360((Double) myCelestial.PlanetMeanPosition.get("Rahu")));

        // mean and true sun at sunrise
        this.mslong = myCelestial.getMeanLongitude(myCelestial.ahar, (Double) myCelestial.YugaRotation.get("sun"));
        myCelestial.PlanetMeanPosition.put("sun", this.mslong);
        this.tslong = myCelestial.zero360(this.mslong -
                myCelestial.getMandaEquation((this.mslong - (Double) myCelestial.PlanetApogee.get("sun")), "sun"));
        myCelestial.PlanetTruePosition.put("sun", this.tslong);

        // mean and true moon at sunrise
        this.mllong = myCelestial.getMeanLongitude(myCelestial.ahar, (Double) myCelestial.YugaRotation.get("moon"));
        myCelestial.PlanetMeanPosition.put("moon", this.mllong);
        myCelestial.PlanetApogee.put("moon", myCelestial.PlanetMeanPosition.get("Candrocca"));
        this.tllong = myCelestial.zero360(this.mllong -
                myCelestial.getMandaEquation((this.mllong - (Double) myCelestial.PlanetApogee.get("moon")), "moon"));
        myCelestial.PlanetTruePosition.put("moon", this.tllong);

        // finding tithi and longitude of conjunction
        this.tithi = myCelestial.getTithi(this.tllong, this.tslong);
        myCelestial.setTithiSet(this.tithi);
        myCelestial.setSuklaKrsna();

        // last conjunction
        this.clong = myCelestial.getClong(myCelestial.ahar, this.tithi);

        // next conjunction
        this.nclong = myCelestial.getNclong(myCelestial.ahar, this.tithi);

        this.adhimasa = myCalendar.getAdhimasa(this.clong, this.nclong);
        this.masaNum = myCalendar.getMasaNum(this.tslong, this.clong);
        this.masa = myCalendar.getMasaName(this.masaNum);

        calendar.SauraMasaMonthDay sauraMasaMonthDay = myCalendar.getSauraMasaMonthDay(myCelestial.ahar);
        this.sauraMasaNum = sauraMasaMonthDay.month;
        this.sauraMasaDay = sauraMasaMonthDay.day;
        this.sauraMasa = myCalendar.getSauraMasaName(this.sauraMasaNum);

        this.malayalaMasaNum = (this.sauraMasaNum - 4 + 12) % 12;
        this.malayalaMasa = myCalendar.getMalayalaMasaName(this.malayalaMasaNum);

        this.naksatra = myCalendar.getNaksatraName(this.tllong);
        this.malayalaNaksatra = myCalendar.getMalayalaNaksatraName(this.tllong);

        // kali and Saka era
        this.yearKali = myCalendar.aharganaToKali(myCelestial.ahar + (4 - this.masaNum) * 30);
        this.yearSaka = myCalendar.kaliToSaka(this.yearKali);
        this.yearVikrama = this.yearSaka + 135;

        // Sewell p.45 - https://archive.org/stream/indiancalendarwi00sewerich#page/45/mode/1up
        this.MalayalamYear = this.yearSaka - 747 +
                KollavarshamMath.truncate((this.sauraMasaNum - this.malayalaMasaNum + 12) / 12);

        String[] planets = {"mercury", "venus", "mars", "jupiter", "saturn"};
        for (int i = 0; i < planets.length; i++) {
            myCelestial.PlanetMeanPosition.put(planets[i], myCelestial.getMeanLongitude(myCelestial.ahar, (Double) myCelestial.PlanetRotation.get(planets[i])));
            myCelestial.PlanetTruePosition.put(planets[i], myCelestial.getTrueLongitude(myCelestial.ahar, this.mslong, planets[i]));

           }

    }

}