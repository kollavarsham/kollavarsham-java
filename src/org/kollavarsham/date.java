package org.kollavarsham;

//Try using setGregorianChange utility of Calendar for these conversions
public class date {
    Double year, month, day;
    
    public date(double year2, double month2, double day2){
		  this.year = year2;
		  this.month = month2;
		  this.day = day2;
    }
    
    public String pad (Integer num, int size) {
    	  String s = "000000000".concat(num.toString());
    	  return s.substring(s.length() - size);
    }
    
    public double getYear() {
		return year;
	}

	public void setYear(double year) {
		this.year = year;
	}

	public double getMonth() {
		return month;
	}

	public void setMonth(double month) {
		this.month = month;
	}

	public double getDay() {
		return day;
	}

	public void setDay(double day) {
		this.day = day;
	}

	public String toString(){
    	return pad(this.year.intValue(), 4) + " " + 
	              pad(this.month.intValue(), 2) + " " + pad(this.day.intValue(), 2);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


