package org.kollavarsham;

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
	globals myGlobals;
	math myMath;

	calculations(){
		myCalendar = new calendar();
		myCelestial = celestial.getInstance();
		myGlobals = globals.getInstance();
		myMath = new math();
	}

	public void _setConstants (Boolean bija) {
		// TODO: Add Tests if/when feasible
		myCelestial.setPrimaryConstants();
		if (bija) {
			myCelestial.applyBija();
		}
		myCelestial.setSecondaryConstants();
		myCelestial.setPlanetaryConstants();
	};

	public void main(Boolean bija, Double latitude){
		// TODO: Add Tests if/when feasible
		_setConstants(bija);
		// This is how it is done in Perl - we use the new gregorianDate global
		//globals.JulianDay = calendar.gregorianDateToJulianDay(new Date(globals.year, globals.month - 1, globals.day));
		myGlobals.JulianDay = myCalendar.gregorianDateToJulianDay(myGlobals.gregorianDate);
		myGlobals.ahar = myCalendar.julianDayToAhargana(myGlobals.JulianDay);
		myGlobals.JulianDay = myMath.truncate(myGlobals.JulianDay + 0.5);
		myGlobals.ahargana = myMath.truncate(myGlobals.ahar + 0.5);
		myGlobals.weekdayName = myCalendar.julianDayToWeekday(myGlobals.JulianDay);
		myCelestial.setAyanamsa(myGlobals.ahargana);

		// at 6 o'clock
		myGlobals.ahar += 0.25;

		// desantara
		myGlobals.ahar -= myGlobals.desantara;

		// time of sunrise at local latitude
		myGlobals.eqtime = myCelestial.getDaylightEquation(myGlobals.year, latitude);
		myGlobals.ahar -= myGlobals.eqtime;
		myCelestial.setSunriseTime(myGlobals.eqtime);

		// Lunar apogee and node at sunrise
		myCelestial.PlanetMeanPosition.put("Candrocca", myCelestial.getMeanLongitude(myGlobals.ahar, (Double) myCelestial.YugaRotation.get("Candrocca")) + 90);
		myCelestial.PlanetMeanPosition.put("Candrocca", myCelestial.zero360( (Double) myCelestial.PlanetMeanPosition.get("Candrocca")));

		myCelestial.PlanetMeanPosition.put("Rahu", myCelestial.getMeanLongitude(myGlobals.ahar, (Double) myCelestial.YugaRotation.get("Rahu")) + 180);
		myCelestial.PlanetMeanPosition.put("Rahu", myCelestial.zero360((Double) myCelestial.PlanetMeanPosition.get("Rahu")));

		// mean and true sun at sunrise
		myGlobals.mslong = myCelestial.getMeanLongitude(myGlobals.ahar, (Double) myCelestial.YugaRotation.get("sun"));
		myCelestial.PlanetMeanPosition.put("sun", myGlobals.mslong);
		myGlobals.tslong = myCelestial.zero360(myGlobals.mslong -
				myCelestial.getMandaEquation((myGlobals.mslong - (Double) myCelestial.PlanetApogee.get("sun")), "sun"));
		myCelestial.PlanetMeanPosition.put("sun", myGlobals.tslong);

		// mean and true moon at sunrise
		myGlobals.mllong = myCelestial.getMeanLongitude(myGlobals.ahar, (Double) myCelestial.YugaRotation.get("moon"));
		myCelestial.YugaRotation.put("moon", myGlobals.mllong);
		myCelestial.PlanetApogee.put("moon", myCelestial.PlanetMeanPosition.get("Candrocca"));
		myGlobals.tllong = myCelestial.zero360(myGlobals.mllong -
				myCelestial.getMandaEquation(( myGlobals.mllong - (Double) myCelestial.PlanetApogee.get("moon")), "moon"));
		myCelestial.PlanetTruePosition.put("moon", myGlobals.tllong);

		// finding tithi and longitude of conjunction
		myGlobals.tithi = myCelestial.getTithi(myGlobals.tllong, myGlobals.tslong);
		myCelestial.setTithiSet(myGlobals.tithi);
		myCelestial.setSuklaKrsna();

		// last conjunction
		myGlobals.clong = myCelestial.getClong(myGlobals.ahar, myGlobals.tithi);

		// next conjunction
		myGlobals.nclong = myCelestial.getNclong(myGlobals.ahar, myGlobals.tithi);

		myGlobals.adhimasa = myCalendar.getAdhimasa(myGlobals.clong, myGlobals.nclong);
		myGlobals.masaNum = myCalendar.getMasaNum(myGlobals.tslong, myGlobals.clong);
		myGlobals.masa = myCalendar.getMasaName(myGlobals.masaNum);

		calendar.SauraMasaMonthDay sauraMasaMonthDay = myCalendar.getSauraMasaMonthDay(myGlobals.ahar);
		myGlobals.sauraMasaNum = sauraMasaMonthDay.month;
		myGlobals.sauraMasaDay = sauraMasaMonthDay.day;
		myGlobals.sauraMasa = myCalendar.getSauraMasaName(myGlobals.sauraMasaNum);

		myGlobals.malayalaMasaNum = (myGlobals.sauraMasaNum - 4 + 12 ) % 12;
		myGlobals.malayalaMasa = myCalendar.getMalayalaMasaName(myGlobals.malayalaMasaNum);

		myGlobals.naksatra = myCalendar.getNaksatraName(myGlobals.tllong);
		myGlobals.malayalaNaksatra = myCalendar.getMalayalaNaksatraName(myGlobals.tllong);

		// kali and Saka era
		myGlobals.YearKali = myCalendar.aharganaToKali(myGlobals.ahar + ( 4 - myGlobals.masaNum ) * 30);
		myGlobals.YearSaka = myCalendar.kaliToSaka(myGlobals.YearKali);
		myGlobals.YearVikrama = myGlobals.YearSaka + 135;
		
		// Sewell p.45 - https://archive.org/stream/indiancalendarwi00sewerich#page/45/mode/1up
		myGlobals.MalayalamYear = myGlobals.YearSaka - 747 +
				myMath.truncate((myGlobals.sauraMasaNum - myGlobals.malayalaMasaNum + 12) / 12);
		//myGlobals.MEYear = myGlobals.;
	}

	public void planetary() {
		String[] planets = {"mercury", "venus", "mars", "jupiter", "saturn"};
		for (int i = 0; i < planets.length; i++) {
			myCelestial.PlanetMeanPosition.put(planets[i], myCelestial.getMeanLongitude(myGlobals.ahar, (Double) myCelestial.PlanetRotation.get(planets[i])));
			myCelestial.PlanetTruePosition.put(planets[i], myCelestial.getTrueLongitude(myGlobals.ahar, myGlobals.mslong, planets[i]));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}