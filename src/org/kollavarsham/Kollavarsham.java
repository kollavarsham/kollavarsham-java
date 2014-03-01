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

public class Kollavarsham {
    /**
     *
     */

    globals myGlobals;
    calculations Calculations;
    Locations kollavarshamLocations;

    Boolean bija;
    double latitude;
    double longitude;

    String MalayalamNakshatram;
    Double MalayalamYear;
    String MalayalamMonth;
    Calendar modernDate;


    public Kollavarsham() {
        myGlobals = globals.getInstance();
        Calculations = new calculations();
        modernDate = Calendar.getInstance();
        kollavarshamLocations = new Locations();
        //default options
        this.bija = false;
        this.latitude = kollavarshamLocations.getLocationCoordinates("Ujjain").getLatitude();
        this.longitude = kollavarshamLocations.getLocationCoordinates("Ujjain").getLongitude();
        
    }

    public void setModernDate(Calendar modernDate) {
        this.modernDate = modernDate;
    }

    public void setOptions(Boolean bija, String location) {
        this.bija = bija;
        this.latitude = kollavarshamLocations.getLocationCoordinates(location).getLatitude();
        this.longitude = kollavarshamLocations.getLocationCoordinates(location).getLongitude();
        if (!location.equals("Ujjain")){
            myGlobals.setDesantara(this.longitude, 
            		kollavarshamLocations.getLocationCoordinates("Ujjain").getLongitude());
        }
    }

    public void FromGregorian() {
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
        modernDate.set(2014, Calendar.MARCH, 2);
        malayalamYear.setModernDate(modernDate);
        malayalamYear.setOptions(true, "Ujjain");
        malayalamYear.FromGregorian();
        System.out.println("Converted to Malayalam Calendar with the following details:");
        System.out.println("Malayalam Year  :" + malayalamYear.getMalayalamYear());
        System.out.println("Malayalam Month :" + malayalamYear.getMalayalamMonthNum());
        System.out.println("Nakshatram : " + malayalamYear.getMalayalamNakshatram());
    }

}

