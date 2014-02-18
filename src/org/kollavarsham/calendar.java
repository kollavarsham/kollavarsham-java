package org.kollavarsham;

import java.util.Calendar;
import java.util.Date;

public class calendar{

	//This may not be required. Better to use CALENDAR.JANUARY etc...
	public enum months {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, 
		SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
	
   math mymath = new math();
	//This function might not be required, We can use Calendar.roll()
	public Calendar nextDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.set(date.getYear(), date.getMonth(), date.getDate());
		calendar.roll(Calendar.DAY_OF_MONTH, 1);
		return calendar;
    }
	
	//Calendar.instance generally returns a Gregorian Calender. Gregorian calendar is but one 
	//implementation. There are other implementations and it's likely that Julian is one of them
	public double gregorianDateToJulianDay(Date date){
        //  TODO:
        // Annotate all the magic numbers below !
        // There is some explanation here - http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html

        double year = date.getYear(),
            month = date.getMonth() + 1,
            day = date.getDate();

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
	
	public date julianDayToJulianDate(double julianDay) {
    	    double j, k, l, n, i, J, I, year, month, day;

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

    	    return new date(year, month, day);
    	  }
	public Date julianDayToGregorianDate(double julianDay){
		
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

		Date result = new Date(year.intValue(), month.intValue() - 1, day.intValue());
//		This might not be necessary in java Date.
//		if (year > 0 && year <= 99) {
//			result.setFullYear(year.intValue());
//		}
		return  result;
	}
	
	public Object julianDayToModernDate (double julianDay){
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}