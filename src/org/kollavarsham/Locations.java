package org.kollavarsham;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * kollavarsham
 * http://kollavarsham.org
 *
 * Copyright (c) 2014 The Kollavarsham Team
 * Licensed under the MIT license.
 */

public class Locations {

    class Location {
    	
		Double latitude;
        Double longitude;
        
        public Double getLatitude() {
			return latitude;
		}

		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		public Double getLongitude() {
			return longitude;
		}

		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

        Location(Double latitude, Double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
    
    static Map<String, Location> theLocations;

    public Locations() {
        theLocations = new HashMap<String, Location>();

        theLocations.put("Agra", new Location(27.2, 78.0));
        theLocations.put("Ahmedabad", new Location(23.0, 72.6));
        theLocations.put("Ajmer", new Location(26.5, 74.6));

        theLocations.put("Aligarh", new Location(27.9, 78.1));
        theLocations.put("Amritsar", new Location(31.6, 74.9));
        theLocations.put("Bangalore", new Location(13.0, 77.6));

        theLocations.put("Bhuvaneswar", new Location(20.2, 85.8));
        theLocations.put("Bombay", new Location(19.0, 72.8));
        theLocations.put("Calcutta", new Location(22.6, 88.4));
        theLocations.put("Cochin", new Location(10.0, 76.2));

        theLocations.put("Colombo", new Location(6.9, 79.9));
        theLocations.put("Dacca", new Location(23.7, 90.4));
        theLocations.put("Delhi", new Location(28.6, 77.2));
        theLocations.put("Hyderabad", new Location(17.4, 78.5));

        theLocations.put("Jaipur", new Location(26.9, 75.8));
        theLocations.put("Kathmandu", new Location(27.7, 85.2));
        theLocations.put("Lahor", new Location(31.6, 74.3));
        theLocations.put("Madras", new Location(13.1, 80.3));

        theLocations.put("Mathura", new Location(27.5, 77.7));
        theLocations.put("Mysore", new Location(12.3, 76.6));
        theLocations.put("Patna", new Location(25.6, 85.1));
        theLocations.put("Pune", new Location(18.5, 73.9));

        theLocations.put("Srinagar", new Location(34.1, 74.8));
        theLocations.put("Trivandrum", new Location(8.5, 77.0));
        theLocations.put("Varanasi", new Location(25.3, 83.0));
        theLocations.put("Ujjain", new Location(23.2, 75.8));

    }
    
    public Location getLocationCoordinates(String location){
    	if (theLocations.containsKey(location)){
    		return theLocations.get(location);
    	}else{
    		return theLocations.get("Ujjain");
    	}
    }
    
    public Set<String> showLocations(){
    	return theLocations.keySet();
    }

}