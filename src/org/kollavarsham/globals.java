package org.kollavarsham;

import java.util.Calendar;
import java.util.Date;

public class globals {
	public final Boolean planet = true;
	public Double YugaCivilDays = 1.0;
	public Double YugaSynodicMonth = 1.0;
	public Double YugaAdhimasa = 1.0;
	public Double YugaTithi = 1.0;
	public Double YugaKsayadina = 1.0;
	public final Boolean lagna = true;

	public Double back_clong_ahar = -1.0;
	public Double back_nclong_ahar = -1.0;
	public Double back_clong = -1.0;
	public Double back_nclong = -1.0;
	
	public Calendar gregorianDate = null; // HP

    //    type  paksas :(suklapaksa, krsnapaksa),
	public Double year = 1.0;
	public final Boolean month = true;
	public String paksa;
	public Double tithiDay;

			  // (suklapaksa, krsnapaksa),
	public Boolean day = true;  // {for ahargana}
	public Double ahar = 1.0; // {for ahargana}
	public Double ahargana = 1.0;
	public  Boolean hours = true;
	public  Boolean minutes = true;
	public double JulianDay = 1.0; // {for Julian days}
	public double YearKali = 1.0;
	public double YearSaka = 1.0;
	public double YearVikrama = 1.0;
	public Double masaNum = 1.0;
	public String sauraMasa = "";
	public Double sauraMasaNum = 1.0;
	public Double sauraMasaDay = 1.0;
	public String malayalaMasa = ""; // HP
	public Double malayalaMasaNum = 1.0; // HP
	public Double MalayalamYear = 1.0;
	public String weekdayName = "";
	public double tithi_day = 1.0;
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
	public Boolean weekday_name = true;
	public String sukla_krsna;
	public String adhimasa = "";
	public String masa = "";
	public String naksatra = "";
	public String malayalaNaksatra = "";

			  // Jovian_Year_north : true,
			  // Jovian_Year_south : true,
	public Double samkranti = 1.0;
	public Double samkrantiYear = 1.0;
	public Double samkrantiMonth = 1.0;
	public Double samkrantiDay = 1.0;
	public Double samkrantiHour = 1.0;
	public Double samkrantiMin = 1.0;

	public Double ayanadeg = 1.0;
	public double ayanamin = 1.0;
	public Double desantara = 0.0; // actually it is `(kollavarsham.settings.longitude - locations.Ujjain.longitude) / 360` =~ 0
	
	public final Boolean counter = true;
	
	private static globals instance = null;
	   protected globals() {
	      // Exists only to defeat instantiation.
	   }
	   public static globals getInstance() {
	      if(instance == null) {
	         instance = new globals();
	      }
	      return instance;
	   }

}
