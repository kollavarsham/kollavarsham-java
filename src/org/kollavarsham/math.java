package org.kollavarsham;

import java.lang.Math;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class math {

    double epsilon = 1E-8;
    double radianMultiplier = 180.0 / Math.PI;

    public boolean isNumber(String str) {
        //the nodejs port one does an isFinite() check as well.
        //The exclusion of that may cause issues
        //System.out.println("String to isNumber : " + str);
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public boolean isInt(String str) {
        try {
            int x = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        //Will reach here only if parseInt was successful
        return true;
        //return this.isNumber(str) && (Integer.parseInt(str) % 1) == 0;
    }

    public Double truncateDecimals(double x, int numberofDecimals) {
        BigDecimal truncated;
        if (x > 0) {
            truncated = new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
        } else {
            truncated = new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
        return truncated.doubleValue();
    }

    public Double truncate(Double num) {
        return this.truncateDecimals(num, 0);
    }

    public double floor(Double num) {
        return Math.floor(num);
    }

    public double fractional(Double num) {
        //might need to revisit for the precision
        //based on the junit results. (Not the delta .01 set in assertEquals)
        double result = num % 1;
        return result;
    }

    public long round(Double num) {
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

    public double square(double num) {
        return Math.pow(num, 2.0);
    }

    public Boolean floatingPointEqual(Double n1, Double n2) {
        System.out.println("n1 is : " + n1 + ", n2 is :" + n2);
        Boolean areEqual = Math.abs(n1 - n2) < this.epsilon;
        return areEqual;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}

