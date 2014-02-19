package org.kollavarsham;

import java.util.HashMap;
import java.util.Map;

/*
 * kollavarsham
 * http://kollavarsham.org
 *
 * Copyright (c) 2014 The Kollavarsham Team
 * Licensed under the MIT license.
 */

public class locations {
	Map theLocations;
	globals myGlobals;

	class location{
		public Double latitude;
		public Double longitude;

		location(Double latitude, Double longitude){
			this.latitude = latitude;
			this.longitude = longitude;
		}
	}

	locations(){
		myGlobals = globals.getInstance();
		theLocations = new HashMap<String, location>();

		theLocations.put("Agra", new location(27.2, 78.0));
		theLocations.put("Ahmedabad", new location(23.0, 72.6));
		theLocations.put("Ajmer", new location(26.5, 74.6));

		theLocations.put("Aligarh", new location(27.9, 78.1));
		theLocations.put("Amritsar", new location(31.6, 74.9));
		theLocations.put("Bangalore", new location(13.0, 77.6));

		theLocations.put("Bhuvaneswar", new location(20.2, 85.8));
		theLocations.put("Bombay", new location(19.0, 72.8));
		theLocations.put("Calcutta", new location(22.6, 88.4));
		theLocations.put("Cochin", new location(10.0, 76.2));

		theLocations.put("Colombo", new location(6.9, 79.9));
		theLocations.put("Dacca", new location(23.7, 90.4));
		theLocations.put("Delhi", new location(28.6, 77.2));
		theLocations.put("Hyderabad", new location(17.4, 78.5));

		theLocations.put("Jaipur", new location(26.9, 75.8));
		theLocations.put("Kathmandu", new location(27.7, 85.2));
		theLocations.put("Lahor", new location(31.6, 74.3));
		theLocations.put("Madras", new location(13.1, 80.3));

		theLocations.put("Mathura", new location(27.5, 77.7));
		theLocations.put("Mysore", new location(12.3, 76.6));
		theLocations.put("Patna", new location(25.6, 85.1));
		theLocations.put("Pune", new location(18.5, 73.9));

		theLocations.put("Srinagar", new location(34.1, 74.8));
		theLocations.put("Trivandrum", new location(8.5, 77.0));
		theLocations.put("Varanasi", new location(25.3, 83.0));
		theLocations.put("Ujjain", new location(23.2, 75.8));

	}	
	public void setDesantara(Double longitude){
		myGlobals.desantara = (Double) ((longitude - ((location) theLocations.get("Ujjain")).longitude) / 360);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}