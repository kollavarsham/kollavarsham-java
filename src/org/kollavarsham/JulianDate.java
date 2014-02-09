package org.kollavarsham;

//Try using setGregorianChange utility of Calendar for these conversions
public class JulianDate {
    double year, month, day;
    
    public JulianDate(double year2, double month2, double day2){
		  this.year = year2;
		  this.month = month2;
		  this.day = day2;
    }
    
    public String pad (double num, int size) {
    	  String s = "000000000" + num;
    	  return s.substring(s.length() - size);
    }
    
    public String toString(){
    	return pad(this.year, 4) + " " + pad(this.month, 2) + " " + pad(this.day, 2);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


