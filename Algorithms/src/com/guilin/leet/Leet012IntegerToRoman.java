package com.guilin.leet;

public class Leet012IntegerToRoman {
	/*
	 * Given an integer, convert it to a roman numeral.

		Input is guaranteed to be within the range from 1 to 3999.
	 */
	private static final int[] values = {
        1000, 900, 500, 400,
        100, 90, 50, 40,
        10, 9, 5, 4,
        1
    };

    private static final String[] symbol = {
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV",
        "I"
    };
    public String intToRoman(int num) {
    
    int n = num, i = 0;
    StringBuilder roman = new StringBuilder();
    while (n > 0) {
        while (n/values[i] > 0) {
            roman.append(symbol[i]);
            n -= values[i];
        }
        i++;
    }
    return roman.toString();
}
}
