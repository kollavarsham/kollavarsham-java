package org.kollavarsham;

/*
 * kollavarsham
 * http://kollavarsham.org
 *
 * Copyright (c) 2014 The Kollavarsham Team
 * Licensed under the MIT license.
 */

import java.lang.Math;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParsePosition;

public final class KollavarshamMath {

    public static final double epsilon = 1E-8;
    public static final double radianMultiplier = 180.0 / Math.PI;

    public static boolean isNumber(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public static boolean isInt(String str) {
        try {
            int x = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static Double truncateDecimals(double x, int numberofDecimals) {
        BigDecimal truncated;
        if (x > 0) {
            truncated = new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
        } else {
            truncated = new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
        return truncated.doubleValue();
    }

    public static Double truncate(Double num) {
        return truncateDecimals(num, 0);
    }

    public static double floor(Double num) {
        return Math.floor(num);
    }

    public static double fractional(Double num) {
        //might need to revisit for the precision
        //based on the junit results. (Not the delta .01 set in assertEquals)
        double result = num % 1;
        return result;
    }

    public static long round(Double num) {
        return Math.round(num);
    }

    public double getRadianMultiplier() {
        return radianMultiplier;
    }

    public static double square(double num) {
        return Math.pow(num, 2.0);
    }

    public static Boolean floatingPointEqual(Double n1, Double n2) {
        Boolean areEqual = Math.abs(n1 - n2) < epsilon;
        return areEqual;
    }

}

