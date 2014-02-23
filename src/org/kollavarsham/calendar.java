package org.kollavarsham;

import java.util.Calendar;
import java.util.Date;

public class calendar{

	public class SauraMasaMonthDay{
		public Double month;
		public Double day;
		public SauraMasaMonthDay(Double month2, Double day2) {
			// TODO Auto-generated constructor stub
			this.month = month2;
			this.day = day2;
		}
		public SauraMasaMonthDay() {
			// TODO Auto-generated constructor stub
			this.month=1.0;
			this.day=1.0;
		}

	}
	//This may not be required. Better to use CALENDAR.JANUARY etc...
	public enum monthsEnum {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, 
		SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};

		public monthsEnum months;

		public String[] masaNames = {"Caitra", "Vaisakha", "Jyaistha", "Asadha", 
				"Sravana", "Bhadrapada", "Asvina", "Karttika", "Margasirsa","Pausa", "Magha", "Phalguna"};

		public String[] sauraMasaNames = {"Mesa", "Vrsa", "Mithuna", "Karkata", "Simha", 
				"Kanya", "Tula", "Vrscika", "Dhanus", "Makara", "Kumbha", "Mina"};

		public String[] malayalaMasaNames = {"Chingam", "Kanni", "Thulam", "Vrischikam",
				"Dhanu", "Makaram", "Kumbham", "Meenam", "Medam", "Idavam", "Mithunam", "Karkitakam"};

		public String[] naksatras = {"Asvini", "Bharani", "Krttika", "Rohini", "Mrgasira", "Ardra", "Punarvasu",
				"Pusya", "Aslesa", "Magha", "P-phalguni", "U-phalguni", "Hasta", "Citra", "Svati", "Visakha",
				"Anuradha", "Jyestha", "Mula", "P-asadha","U-asadha", "Sravana", "Dhanistha", "Satabhisaj",
				"P-bhadrapada", "U-bhadrapada", "Revati", "Asvini"};

		public String[] malayalaNaksatras = {"Ashwathi", "Bharani", "Karthika", "Rohini", "Makiryam", "Thiruvathira",
				"Punartham", "Pooyam", "Aayilyam", "Makam", "Pooram", "Uthram", "Atham", "Chithra", "Chothi",
				"Vishakham", "Anizham", "Thrikketta", "Moolam", "Pooradam", "Uthradam", "Thiruvonam", "Avittam",
				"Chathayam", "Poororuttathi", "Uthrattathi", "Revathi", "Ashwathi"};

		math mymath;
		celestial myCelestial;
		globals myGlobals;

		public calendar(){
			mymath = new math();
			myCelestial = celestial.getInstance();
			myGlobals = globals.getInstance();
		}
		//This function might not be required, We can use Calendar.roll()
		public Calendar nextDate(Calendar cal){
			Calendar calendar = Calendar.getInstance();
			calendar.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 
					cal.get(Calendar.DAY_OF_MONTH));
			calendar.roll(Calendar.DAY_OF_YEAR, 1);
			return calendar;
		}

		//Calendar.instance generally returns a Gregorian Calender. Gregorian calendar is but one 
		//implementation. There are other implementations and it's likely that Julian is one of them
		public double gregorianDateToJulianDay(Calendar calendar){
			//  TODO:
			// Annotate all the magic numbers below !
			// There is some explanation here - http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html

			double year = calendar.get(Calendar.YEAR),
					month = calendar.get(Calendar.MONTH) + 1,
					day = calendar.get(Calendar.DAY_OF_MONTH);

			if (month < 3) {
				year -= 1;
				month += 12;
			}

			double julianDay = mymath.truncate(365.25 * year) + 
					mymath.truncate(30.59 * (month - 2)) + day + 1721086.5;

			if (year < 0) {
				julianDay -= 1;
				if (year % 4 == 0 && 3 <= month) {
					julianDay += 1;
				}
			}

			if (2299160 < julianDay) {
				julianDay += (mymath.truncate(year / 400) - mymath.truncate(year / 100) + 2);
			}

			return julianDay;
		}

		public Boolean julianInEngland(double julianDay){	
			// Gregorian calendar was first introduced in most of Europe in 1582,
			// but it wasn't adopted in England (and so in US and Canada) until 1752
			//
			// - http://www.timeanddate.com/calendar/julian-gregorian-switch.html
			//
			// This function returns true between
			//      October 14th, 1582 and September 14th, 1752, both dates exclusive
			return 2299160 < julianDay && julianDay <= 2361221;
		}

		public Calendar julianDayToJulianDate(double julianDay) {
			Double j, k, l, n, i, J, I, year, month, day;

			j = mymath.truncate(julianDay) + 1402;
			k = mymath.truncate((j - 1) / 1461);
			l = j - 1461 * k;
			n = mymath.truncate((l - 1) / 365) - mymath.truncate(l / 1461);
			i = l - 365 * n + 30;
			J = mymath.truncate(80 * i / 2447);
			I = mymath.truncate(J / 11);

			day = i - mymath.truncate(2447 * J / 80);
			month = J + 2 - 12 * I;
			year = 4 * k + n + I - 4716;

			Calendar result = Calendar.getInstance();
			result.set(year.intValue(),  month.intValue(), day.intValue());
			return result;
		}
		public Calendar julianDayToGregorianDate(double julianDay){

			double a, b, c, e, f, g, h;
			Double year, month, day;

			a = julianDay + 68569;
			b = mymath.truncate(a / 36524.25);
			c = a - mymath.truncate(36524.25 * b + 0.75);
			e = mymath.truncate((c + 1) / 365.2425);
			f = c - mymath.truncate(365.25 * e) + 31;
			g = mymath.truncate(f / 30.59);
			h = mymath.truncate(g / 11);

			day = mymath.truncate(f - mymath.truncate(30.59 * g) + (julianDay - mymath.truncate(julianDay)));
			month = mymath.truncate(g - 12 * h + 2);
			year = mymath.truncate(100 * (b - 49) + e + h);

			Calendar result = Calendar.getInstance();

			result.set(year.intValue(), month.intValue() - 1, day.intValue());
			//		This might not be necessary in java Date.
			//		if (year > 0 && year <= 99) {
			//			result.setFullYear(year.intValue());
			//		}
			return  result;
		}

		public Calendar julianDayToModernDate (double julianDay){
			//return type of object is a hack. I am not sure as of now, I have only eliminated the conpile issue
			return julianDay < 2299239 ? this.julianDayToJulianDate(julianDay) : this.julianDayToGregorianDate(julianDay);
		}

		public double julianDayToAhargana(double julianDay){
			return julianDay - 588465.50;
		}

		public double aharganaToJulianDay(double ahargana){
			return 588465.50 + ahargana;
		}

		public String julianDayToWeekday(double julianDay){
			String[] weekday = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
			return weekday[(mymath.truncate(julianDay + 0.5)).intValue() % 7];
		}

		public double aharganaToJulianDay (Double ahargana) {
			return 588465.50 + ahargana;
		}

		public double aharganaToKali (Double ahargana) {
			return mymath.truncate(ahargana * (Double) myCelestial.YugaRotation.get("sun") / myGlobals.YugaCivilDays);
		}

		public double kaliToSaka (Double yearKali) {
			return yearKali - 3179;
		}

		public String  getAdhimasa (Double clong, Double nclong) {
			return mymath.floatingPointEqual(mymath.truncate(clong / 30), mymath.truncate(nclong / 30)) ? "Adhika-" : "";
		}

		public Double getMasaNum(Double tslong, Double clong) {
			Double masaNum = mymath.truncate(tslong / 30) % 12;
			if (masaNum == mymath.truncate(clong / 30) % 12) {
				masaNum += 1;
			}
			masaNum = (masaNum + 12) % 12;
			return masaNum;
		}

		public String getMasaName(Double masaNum) {
			return this.masaNames[masaNum.intValue()];
		}

		public SauraMasaMonthDay getSauraMasaMonthDay (Double ahargana) {
			// If today is the first day then 1
			// Otherwise yesterday's + 1
			Double month, day;
			ahargana = mymath.truncate(ahargana);
			SauraMasaMonthDay sauraMasaMonthDay = new SauraMasaMonthDay();
			if (this.isTodaySauraMasaFirst(ahargana)) {
				day = 1.0;
				Double tsLongTomorrow = myCelestial.getTslong(ahargana + 1);
				month = mymath.truncate(tsLongTomorrow / 30) % 12;
				month = (month + 12) % 12;
			} else {
				sauraMasaMonthDay = this.getSauraMasaMonthDay(ahargana - 1);
				month = sauraMasaMonthDay.month;
				day = sauraMasaMonthDay.day + 1;
			}
			SauraMasaMonthDay sMonthDay = new SauraMasaMonthDay(month, day);
			return sMonthDay;
		}

		public String getSauraMasaName (Double number) {
			return this.sauraMasaNames[number.intValue()];
		}

		public Boolean isTodaySauraMasaFirst (Double ahargana) {
			/*
						    //    Definition of the first day
						    //    samkranti is between today's 0:00 and 24:00
						    //    ==
						    //    at 0:00 before 30x, at 24:00 after 30x
			 */
			Double tslongToday = myCelestial.getTslong(ahargana - myGlobals.desantara);
			Double tslongTomorrow = myCelestial.getTslong(ahargana - myGlobals.desantara + 1);

			tslongToday -= mymath.truncate(tslongToday / 30) * 30;
			tslongTomorrow -= mymath.truncate(tslongTomorrow / 30) * 30;

			if (25 < tslongToday && tslongTomorrow < 5) {
				this.setSamkranti(ahargana);
				return true;
			}

			return false;
		}

		public Double findSamkranti(Double leftAhargana, Double rightAhargana) {
			/* The below block seems to be redundant   */
			/* --- START REDUNDANT ------------------- */
			Double leftTslong = myCelestial.getTslong(leftAhargana);
			Double rightTslong = myCelestial.getTslong(rightAhargana);

			leftTslong -= mymath.truncate(leftTslong / 30) * 30;
			rightTslong -= mymath.truncate(rightTslong / 30) * 30;
			/* --- END   REDUNDANT ------------------- */

			Double width = (rightAhargana - leftAhargana) / 2;
			Double centreAhargana = (rightAhargana + leftAhargana) / 2;

			if (width < mymath.epsilon) {
				return centreAhargana;
			} else {
				Double centreTslong = myCelestial.getTslong(centreAhargana);
				centreTslong -= mymath.truncate(centreTslong / 30) * 30;
				if (centreTslong < 5) {
					return this.findSamkranti(leftAhargana, centreAhargana);
				} else {
					return this.findSamkranti(centreAhargana, rightAhargana);
				}
			}
		}
		public void setSamkranti(Double ahargana) {
			myGlobals.samkranti = this.findSamkranti(ahargana, ahargana + 1) + myGlobals.desantara;
			Object samkrantiModernDate = this.julianDayToModernDate(this.aharganaToJulianDay(myGlobals.samkranti));
			if (samkrantiModernDate.getClass().getSimpleName() == "date") {
				myGlobals.samkrantiYear = ((date) samkrantiModernDate).getYear();
				myGlobals.samkrantiMonth = ((date) samkrantiModernDate).getMonth();
				myGlobals.samkrantiDay = ((date) samkrantiModernDate).getDay();
			} else {
				myGlobals.samkrantiYear = (double) ((Calendar) samkrantiModernDate).get(Calendar.YEAR);
				myGlobals.samkrantiMonth = (double) ((Calendar) samkrantiModernDate).get(Calendar.MONTH) + 1;
				myGlobals.samkrantiDay = (double) ((Calendar) samkrantiModernDate).get(Calendar.DAY_OF_MONTH);
			}
			Double fractionalDay = mymath.fractional(myGlobals.samkranti) * 24;
			myGlobals.samkrantiHour = mymath.truncate(fractionalDay);
			myGlobals.samkrantiMin = mymath.truncate(60 * mymath.fractional(fractionalDay));
		}
		public String getMalayalaMasaName (Double number) {
			return this.malayalaMasaNames[number.intValue()];
		}
		public String getNaksatraName (Double tllong) {
			return this.naksatras[(mymath.truncate(tllong * 27 / 360)).intValue()];
		}
		public String getMalayalaNaksatraName (Double tllong) {
			return this.malayalaNaksatras[(mymath.truncate(tllong * 27 / 360)).intValue()];
		}
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

}