/*
 * kollavarsham
 * http://kollavarsham.org
 *
 * Copyright (c) 2014 The Kollavarsham Team
 * Licensed under the MIT license.
 */

package org.kollavarsham;

import java.util.Calendar;

//This is the main class for the Kollavarsham API
//Extending this from java.util.Date to reuse certain functionalities from that.
//That will make available all the APIs of the 'modern' Date API

public class Kollavarsham{
	/**
	 * 
	 */

	globals myGlobals;
	calculations Calculations;

	public static final int MALAYALAM_YEAR = 1;
	public static final int MALAYALAM_MONTH_NUM = 2;
	public static final int MALAYALAM_DAY_OF_MONTH = 3;

	Boolean bija = false;
	double latitude = 23.2;
	double longitude = 75.8;

	String MalayalamNakshatram;
	Double MalayalamYear;
	String MalayalamMonth;
	Calendar modernDate;


	public Kollavarsham() {
		myGlobals = globals.getInstance();
		Calculations = new calculations();
		modernDate = Calendar.getInstance();
	}

	public void setModernDate(Calendar modernDate) {
		this.modernDate = modernDate;
	}

	public void setOptions(Boolean bija, Double latitude, Double longitude){
		this.bija = bija;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public void FromGregorian(){
		Calculations._setConstants(this.bija);
		Calculations.FromGregorian(this.bija, this.latitude, this.modernDate);
		MalayalamNakshatram = myGlobals.malayalaNaksatra;
		MalayalamYear = myGlobals.MalayalamYear;
		MalayalamMonth = myGlobals.malayalaMasa;	
	}

	public String getMalayalamNakshatram() {
		return MalayalamNakshatram;
	}

	public Double getMalayalamYear() {
		return MalayalamYear;
	}

	public String getMalayalamMonthNum() {
		return MalayalamMonth;
	}

/**
 * @param args
 */
public static void main(String[] args) {
	// Test Only
	Kollavarsham malayalamYear = new Kollavarsham();
	Calendar modernDate = Calendar.getInstance();
	modernDate.set(1985, Calendar.NOVEMBER, 20);
	malayalamYear.setModernDate(modernDate);
	malayalamYear.setOptions(true, 23.2, 75.8);
	malayalamYear.FromGregorian();
	System.out.println("Converted to Malayalam Calendar with the following details:");
	System.out.println("Malayalam Year  :" + malayalamYear.getMalayalamYear());
	System.out.println("Malayalam Month :" + malayalamYear.getMalayalamMonthNum());
	System.out.println("Nakshatram : " + malayalamYear.getMalayalamNakshatram());
}

}

