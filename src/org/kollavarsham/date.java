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
// TODO This portion may be required only at the end of the port. Will leave it for now
/* 
 * /****************** Kollavarsham Date ******************************

 * @class KollavarshamDate
 * @param [year=1] {Number} The Kollavarsham year
 * @param [month=1] {Number} The Kollavarsham month
 * @param [day=1] {Number} The Kollavarsham day
 * @constructor
 
var KollavarshamDate = function (year, month, day) {

  this.year = year || 1;
  this.month = month || 1;
  this.day = day || 1;

  this.globals = null;
};


 * Converts the Kollavarsham Date to a nicely formatted string with year, month and date
 * @method toString
 * @for KollavarshamDate
 * @return {string}

KollavarshamDate.prototype.toString = function () {
  return pad(this.year, 4) + ' ' + pad(this.month, 2) + ' ' + pad(this.day, 2);
};


 * Returns the output string (that is probably relevant only from the CLI perspective)
 * @method print
 * @returns {string}
 
KollavarshamDate.prototype.print = function () {
  if (this.globals) {
    var result = 'Saka : ' + pad(this.globals.YearSaka, 4) + '\t' + pad(this.globals.tithiDay, 2) + ' ' +
        this.globals.masa + ' (' + pad(this.globals.masaNum, 2) + ') ' + '\t[' + this.globals.paksa + ']\n';

    result += 'Saura: ' + pad(this.globals.YearSaka, 4) + '\t' + pad(this.globals.sauraMasaDay, 2) + ' ' +
        this.globals.sauraMasa + ' (' + pad(this.globals.sauraMasaNum, 2) + ') ' + '\t' + this.globals.naksatra + '\n';

    result += 'ME   : ' + pad(this.globals.MalayalamYear, 4) + '\t' + pad(this.globals.sauraMasaDay, 2) + ' ' +
        this.globals.malayalaMasa + ' (' + pad(this.globals.malayalaMasaNum, 2) + ') ' + '\t' + this.globals.malayalaNaksatra + '\n';

    return result;
  }
  return this.toString();
};

module.exports.KollavarshamDate = KollavarshamDate;
 */

