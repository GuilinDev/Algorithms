package com.guilin.leet;

public class Leet007ReverseInteger {
	/*
	 * Reverse digits of an integer.

		Example1: x = 123, return 321
		Example2: x = -123, return -321
	 */
	public int reverse(int x) {
		int result = 0, num = x;
		while (num != 0) {
			if (Math.abs(result) > Integer.MAX_VALUE / 10) { // in case of overflow
				return 0;
			}
			// each round times 10 for the result, and add the last digit of num
			result = result * 10 + num % 10; 
			num /= 10;
		}
		return result;
	}
}
