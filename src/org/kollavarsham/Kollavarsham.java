/*
 * kollavarsham
 * http://kollavarsham.org
 *
 * Copyright (c) 2014 Floyd Pink & akutty
 * Licensed under the MIT license.
 */

package org.kollavarsham;

import java.util.Date;

//This is the main class for the Kollavarsham API
//Extending this from java.util.Date to reuse certain functionalities from that.
//That will make available all the APIs of the 'modern' Date API

public class Kollavarsham extends Date {
	public enum outputFormat {verbose, list};
	class KollavarshamSettings {
		//These are the defaults
	    Boolean bija = false;
	    short mode = 0;
	    double latitude = 23.2;
	    double longitude = 75.8;
	    outputFormat output = outputFormat.verbose;
	    
		public Boolean getBija() {
			return bija;
		}
		public void setBija(Boolean bija) {
			this.bija = bija;
		}
		public short getMode() {
			return mode;
		}
		public void setMode(short mode) {
			this.mode = mode;
		}
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		public outputFormat getOutput() {
			return output;
		}
		public void setOutput(outputFormat output) {
			this.output = output;
		}
	}
	KollavarshamSettings settings;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kollavarsham malayalamYear = new Kollavarsham();
		System.out.println("The date is " + malayalamYear.getTime());

	}

}

