package org.kollavarsham;

import java.lang.Math;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class math {

	double epsilon = 1^-10;
	double radianMultiplier = 180/Math.PI;
	
	public boolean isNumber(String str){
	 //the nodejs port one does an isFinite() check as well.
	 //The exclusion of that may cause issues
	  NumberFormat formatter = NumberFormat.getInstance();
	  ParsePosition pos = new ParsePosition(0);
	  formatter.parse(str, pos);
	  return str.length() == pos.getIndex();
	}
	
	public boolean isInt(String str){
		try {
			int x = Integer.parseInt(str);
		}catch (NumberFormatException nfe){
			return false;
		}
		//Will reach here only if parseInt was successful
		return true;
		//return this.isNumber(str) && (Integer.parseInt(str) % 1) == 0;
    }
	
	public double truncateDecimals(Double num, int digits){
      // Thanks Nick Knowlson! - http://stackoverflow.com/a/9232092/218882
      //     (The original from that answer has a bug though, where an integer was getting rounded to "".
      //      Caught it while getting calendar.gregorianDateToJulianDay to work. 2 hours... Phew!)
      String numS = num.toString();
      int decPos = numS.indexOf('.');
      Double result;
      if (decPos == -1){
    	result = num;
      } else {
        result = Double.parseDouble(numS.substring(0, 1 + decPos + digits));
      }
        return  !isNumber(result.toString()) ? 0 : result.doubleValue();
      }
	
	 public double truncate (Double num){
		 return this.truncateDecimals(num, 0);
	 }
     
	 public double floor (Double num){
		 return Math.floor(num);
	 }
	 
	 public double fractional(Double num){
		//might need to revisit for the precision
		//based on the junit results. (Not the delta .01 set in assertEquals)
	    double result = num % 1;
	    return result;
	 }
	 
	 public long round (Double num){
		 return Math.round(num);
	 }
	 
	public double getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public double getRadianMultiplier() {
		return radianMultiplier;
	}

	public void setRadianMultiplier(double radianMultiplier) {
		this.radianMultiplier = radianMultiplier;
	}
	
	public double square(double num){
		return Math.pow(num, 2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}

