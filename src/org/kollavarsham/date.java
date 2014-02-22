package org.kollavarsham;

//Try using setGregorianChange utility of Calendar for these conversions
public class date {
	Double year, month, day;
	globals myGlobals;
	public date(double year2, double month2, double day2){
		this.year = year2;
		this.month = month2;
		this.day = day2;
		myGlobals = globals.getInstance();
	}

	public String pad (Double num, int size) {
		Integer numValue = num.intValue();
		String s = "000000000".concat(numValue.toString());
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
		return pad(this.year, 4) + " " + 
				pad(this.month, 2) + " " + pad(this.day, 2);
	}

	public void KollavarshamDate (Double year, Double month, Double day) {

		this.year = year;
		this.month = month;
		this.day = day;

		this.myGlobals = null; //Not very happy about this
	};

	public String print() {
		if (this.myGlobals != null) {
			String result = "Saka : " + pad(this.myGlobals.YearSaka, 4) + "\t" + pad(this.myGlobals.tithiDay, 2) + " " +
					this.myGlobals.masa + " (" + pad(this.myGlobals.masaNum, 2) + ") " + "\t[" + this.myGlobals.paksa + "]\n";

			result += "Saura: " + pad(this.myGlobals.YearSaka, 4) + "\t" + pad(this.myGlobals.sauraMasaDay, 2) + " " +
					this.myGlobals.sauraMasa + " (" + pad(this.myGlobals.sauraMasaNum, 2) + ") " + "\t" + this.myGlobals.naksatra + "\n";

			result += "ME   : " + pad(this.myGlobals.MalayalamYear, 4) + "\t" + pad(this.myGlobals.sauraMasaDay, 2) + " " +
					this.myGlobals.malayalaMasa + " (" + pad(this.myGlobals.malayalaMasaNum, 2) + ") " + "\t" + this.myGlobals.malayalaNaksatra + "\n";

			return result;
		}
		return this.toString();
	};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}