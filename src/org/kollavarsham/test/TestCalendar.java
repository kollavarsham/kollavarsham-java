package org.kollavarsham.test;

import static org.junit.Assert.*;
import org.kollavarsham.*;
import java.util.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalendar {
	
	calendar kvcal;
	celestial Celestial;
	math mymath;
	Calendar gregcal, nextcal;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		kvcal = new calendar();
		Celestial = celestial.getInstance();
		mymath = new math();
		gregcal = Calendar.getInstance();
		nextcal = Calendar.getInstance();
		
		Celestial.setPrimaryConstants();
	    Celestial.setSecondaryConstants();
	    Celestial.setPlanetaryConstants();
	}

	@After
	public void tearDown() throws Exception {
	}

	public Boolean cmpDates(Calendar one, Calendar two){
		if (one.getTime().toString().equals(two.getTime().toString())){
			return true;
		}
		System.out.println("one is " + one.getTime().toString());
		System.out.println("two is " + two.getTime().toString());
		return false;
	}
	
	public Boolean cmpDates(date kvdate, Calendar cal){
		if ((cal.get(Calendar.YEAR) == kvdate.getYear()) &&
		    (cal.get(Calendar.MONTH) == kvdate.getMonth()) &&
		    (cal.get(Calendar.DAY_OF_MONTH) == kvdate.getDay())){
			return true;
		}
		return false;
	}
	
	@Test
	public void testNextDate() {
		gregcal.set(2014, Calendar.JANUARY, 31);
		nextcal.set(2014, Calendar.FEBRUARY, 1);
		assertTrue("Dates Don't match", cmpDates(nextcal, kvcal.nextDate(gregcal)));
	}

	@Test
	public void testGregorianDateToJulianDay() {
		gregcal.set(2014, Calendar.FEBRUARY, 16 );
	    assertEquals(kvcal.gregorianDateToJulianDay(gregcal), 2456704.5, 0);
	    gregcal.set(2013, Calendar.DECEMBER, 30 );
	    assertEquals(kvcal.gregorianDateToJulianDay(gregcal), 2456656.5, 0);
	    gregcal.set(2013, Calendar.DECEMBER, 31 );
	    assertEquals(kvcal.gregorianDateToJulianDay(gregcal), 2456657.5, 0);
	}

	@Test
	public void testJulianInEngland() {
	    assertEquals(kvcal.julianInEngland(2299158.5), false);
	    assertEquals(kvcal.julianInEngland(2299159.5), false);
	    assertEquals(kvcal.julianInEngland(2299160.5), true);		
	}

	@Test
	public void testJulianDayToJulianDate() {
		//One month shift seen here when used the same date as in the js test
		gregcal.set(1582, Calendar.NOVEMBER, 02 );
	    assertTrue(cmpDates(kvcal.julianDayToJulianDate(2299158.5), gregcal));
	    gregcal.set(1582, Calendar.NOVEMBER, 03);
	    assertTrue(cmpDates(kvcal.julianDayToJulianDate(2299159.5), gregcal));
	    gregcal.set(1582, Calendar.NOVEMBER, 04);
	    assertTrue(cmpDates(kvcal.julianDayToJulianDate(2299160.5), gregcal));
	}

	@Test
	public void testJulianDayToGregorianDate() {
		gregcal.set(1582,  Calendar.OCTOBER, 13);
		assertTrue(cmpDates(kvcal.julianDayToGregorianDate(2299158.5), gregcal));
		gregcal.set(1582,  Calendar.OCTOBER, 14);
		assertTrue(cmpDates(kvcal.julianDayToGregorianDate(2299159.5), gregcal));
		gregcal.set(1752,  Calendar.SEPTEMBER, 13);
	    assertTrue(cmpDates(kvcal.julianDayToGregorianDate(2361220.5), gregcal));
	    gregcal.set(1752,  Calendar.SEPTEMBER, 14);
	    assertTrue(cmpDates(kvcal.julianDayToGregorianDate(2361221.5), gregcal));
	}

	@Test
	public void testJulianDayToModernDate() {
		//gregcal.set(1582,  Calendar.OCTOBER, 2);
        //assertEquals(kvcal.julianDayToModernDate(2299158.5), gregcal);
        gregcal.set(1752,  Calendar.SEPTEMBER, 13);
        assertTrue(cmpDates(kvcal.julianDayToModernDate(2361220.5), gregcal));
        //gregcal.set(1,  Calendar.FEBRUARY, 3);
        //assertEquals(kvcal.julianDayToModernDate(1721457.5), gregcal);
        gregcal.set(2013, Calendar.FEBRUARY, 28);
  	    assertTrue(cmpDates(kvcal.julianDayToModernDate(2456351.5), gregcal));
  	    gregcal.set(2012, Calendar.FEBRUARY, 28);
  	    assertTrue(cmpDates(kvcal.julianDayToModernDate(2455985.5), gregcal));
  	    gregcal.set(1950, Calendar.FEBRUARY, 1);
 	    assertTrue(cmpDates(kvcal.julianDayToModernDate(2433313.5), gregcal));
	}

	@Test
	public void testJulianDayToAhargana() {
	    assertEquals(kvcal.julianDayToAhargana(2299158.5), 1710693, 0);
	    assertEquals(kvcal.julianDayToAhargana(2299159.5), 1710694, 0);
	    assertEquals(kvcal.julianDayToAhargana(2299160.5), 1710695, 0);
	    assertEquals(kvcal.julianDayToAhargana(2299161.5), 1710696, 0);
	    assertEquals(kvcal.julianDayToAhargana(2361220.5), 1772755, 0);
	    assertEquals(kvcal.julianDayToAhargana(2361221.5), 1772756, 0);
	    assertEquals(kvcal.julianDayToAhargana(2361222.5), 1772757, 0);
	    assertEquals(kvcal.julianDayToAhargana(1721457.5), 1132992, 0);
	    assertEquals(kvcal.julianDayToAhargana(2456656.5), 1868191, 0);
	    assertEquals(kvcal.julianDayToAhargana(2456657.5), 1868192, 0);
	    assertEquals(kvcal.julianDayToAhargana(2455957.5), 1867492, 0);
	    assertEquals(kvcal.julianDayToAhargana(2456351.5), 1867886, 0);
	    assertEquals(kvcal.julianDayToAhargana(2455985.5), 1867520, 0);
	    assertEquals(kvcal.julianDayToAhargana(2433313.5), 1844848, 0);
	}

	@Test
	public void testAharganaToJulianDayDouble() {
		assertEquals(kvcal.aharganaToJulianDay(1710693), 2299158.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1710694), 2299159.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1710695), 2299160.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1710696), 2299161.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1772755), 2361220.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1772756), 2361221.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1772757), 2361222.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1132992), 1721457.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1868191), 2456656.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1868192), 2456657.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1867492), 2455957.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1867886), 2456351.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1867520), 2455985.5, 0);
	    assertEquals(kvcal.aharganaToJulianDay(1844848), 2433313.5, 0);
	}

	@Test
	public void testJulianDayToWeekday() {
		assertEquals(kvcal.julianDayToWeekday(2299158.5), "Wednesday");
	    assertEquals(kvcal.julianDayToWeekday(2299159.5), "Thursday");
	    assertEquals(kvcal.julianDayToWeekday(2299160.5), "Friday");
	    assertEquals(kvcal.julianDayToWeekday(2299161.5), "Saturday");
	    assertEquals(kvcal.julianDayToWeekday(2361220.5), "Wednesday");
	    assertEquals(kvcal.julianDayToWeekday(2361221.5), "Thursday");
	    assertEquals(kvcal.julianDayToWeekday(2361222.5), "Friday");
	    assertEquals(kvcal.julianDayToWeekday(1721457.5), "Friday");
	    assertEquals(kvcal.julianDayToWeekday(2456656.5), "Monday");
	    assertEquals(kvcal.julianDayToWeekday(2456657.5), "Tuesday");
	    assertEquals(kvcal.julianDayToWeekday(2455957.5), "Tuesday");
	    assertEquals(kvcal.julianDayToWeekday(2456351.5), "Thursday");
	    assertEquals(kvcal.julianDayToWeekday(2455985.5), "Tuesday");
	    assertEquals(kvcal.julianDayToWeekday(2433313.5), "Wednesday");
	}

	@Test
	public void testAharganaToKali() {
	    assertEquals(kvcal.aharganaToKali(1710693.0), 4683, 0);
	    assertEquals(kvcal.aharganaToKali(1710694.0), 4683, 0);
	    assertEquals(kvcal.aharganaToKali(1710695.0), 4683, 0);
	    assertEquals(kvcal.aharganaToKali(1710696.0), 4683, 0);
	    assertEquals(kvcal.aharganaToKali(1772755.0), 4853, 0);
	    assertEquals(kvcal.aharganaToKali(1772756.0), 4853, 0);
	    assertEquals(kvcal.aharganaToKali(1772757.0), 4853, 0);
	    assertEquals(kvcal.aharganaToKali(1132992.0), 3101, 0);
	    assertEquals(kvcal.aharganaToKali(1868191.0), 5114, 0);
	    assertEquals(kvcal.aharganaToKali(1868192.0), 5114, 0);
	    assertEquals(kvcal.aharganaToKali(1867492.0), 5112, 0);
	    assertEquals(kvcal.aharganaToKali(1867886.0), 5113, 0);
	    assertEquals(kvcal.aharganaToKali(1867520.0), 5112, 0);
	    assertEquals(kvcal.aharganaToKali(1844848.0), 5050, 0);
	}

	@Test
	public void testKaliToSaka() {
	    assertEquals(kvcal.kaliToSaka(4683.0), 1504, 0);
	    assertEquals(kvcal.kaliToSaka(4683.0), 1504, 0);
	    assertEquals(kvcal.kaliToSaka(4683.0), 1504, 0);
	    assertEquals(kvcal.kaliToSaka(4683.0), 1504, 0);
	    assertEquals(kvcal.kaliToSaka(4853.0), 1674, 0);
	    assertEquals(kvcal.kaliToSaka(4853.0), 1674, 0);
	    assertEquals(kvcal.kaliToSaka(4853.0), 1674, 0);
	    assertEquals(kvcal.kaliToSaka(3101.0), -78, 0);
	    assertEquals(kvcal.kaliToSaka(5114.0), 1935, 0);
	    assertEquals(kvcal.kaliToSaka(5114.0), 1935, 0);
	    assertEquals(kvcal.kaliToSaka(5112.0), 1933, 0);
	    assertEquals(kvcal.kaliToSaka(5113.0), 1934, 0);
	    assertEquals(kvcal.kaliToSaka(5112.0), 1933, 0);
	    assertEquals(kvcal.kaliToSaka(5050.0), 1871, 0);
	}

	@Test
	public void testGetAdhimasa() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMasaNum() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMasaName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSauraMasaMonthDay() {
	    assertEquals(kvcal.getSauraMasaMonthDay(2299158.5).month, 7, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2299159.5).month, 7, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2299160.5).month, 7, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2299161.5).month, 7, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2361220.5).month, 6, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2361221.5).month, 6, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2361222.5).month, 6, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(1721457.5).month, 11, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2456656.5).month, 9, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2456657.5).month, 9, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2455957.5).month, 10, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2456351.5).month, 11, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2455985.5).month, 11, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2433313.5).month, 10, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2299158.5).day, 6, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2299159.5).day, 7, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2299160.5).day, 8, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2299161.5).day, 9, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2361220.5).day, 4, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2361221.5).day, 5, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2361222.5).day, 6, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(1721457.5).day, 27, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2456656.5).day, 19, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2456657.5).day, 20, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2455957.5).day, 21, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2456351.5).day, 20, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2455985.5).day, 19, 0);
//	    assertEquals(kvcal.getSauraMasaMonthDay(2433313.5).day, 23, 0);
	}

	@Test
	public void testGetSauraMasaName() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsTodaySauraMasaFirst() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSamkranti() {
	    assertTrue(mymath.floatingPointEqual(kvcal.findSamkranti(1868206.0, 1868207.0), 1868206.71761142));
	    assertTrue(mymath.floatingPointEqual(kvcal.findSamkranti(1868236.0, 1868237.0), 1868236.15636098));
//	    assertTrue(mymath.floatingPointEqual(kvcal.findSamkranti(1868266.0, 1868267.0), 1868266.00000001));
//	    assertTrue(mymath.floatingPointEqual(kvcal.findSamkranti(1721431.0, 1721432.0), 1721431.9425787));
//	    assertTrue(mymath.floatingPointEqual(kvcal.findSamkranti(2299153.0, 2299154.0), 2299153.23922039));
	}

	@Test
	public void testSetSamkranti() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMalayalaMasaName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNaksatraName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMalayalaNaksatraName() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
