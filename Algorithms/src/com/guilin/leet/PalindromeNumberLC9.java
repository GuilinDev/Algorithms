package com.guilin.leet;

public class PalindromeNumberLC9 {
	/*
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 */
	
	// Do this without extra space -- means we cannot convert this integer to string
	public static boolean isPalindrome(int x) {
        if (x < 0) {// negative integers are not palindrome
        	return false;
        }
        int flag = 1;
        int num = x;
        while (x >= 10) {
        	flag *= 10;
        	x /= 10;
        }
        while (num != 0) {
        	int left = num / flag;
        	int right = num % 10;
        	if (left != right) {
        		return false;
        	}
        	num = (num % flag) / 10; // remove first and last digits, if one or two digits from above, num will be 0 here
        	flag /= 100; // remove two digits each round
        }
        return true;
    }
}
