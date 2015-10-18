package com.guilin.leet;

public class Leet014LongestCommonPrefix {
	/*
	 * Write a function to find the longest common prefix string amongst an array of strings.
	 */
	
	// compare pairs of two strings' common prefix 
	public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) { // need to handle only-one element array
            return strs[0];
        }
        String prefix = "";
        int minPrefix = Integer.MAX_VALUE;
        for (int i = 1; i < strs.length; i++) {
            int maxPrefix = 0;
            int m = strs[i - 1].length(), n = strs[i].length();
            
            for (int j = 0; j < Math.min(Math.min(m, n), minPrefix); j++) { //Math.min(m, n) -- only needs to check the shorter one; minPrefix -- if longer than minPrefix, that's should not be common prefix
                if (strs[i - 1].charAt(j) == strs[i].charAt(j)) {
                    maxPrefix++;
                } else {
                    break;
                }
            }
            if (maxPrefix < minPrefix) {
                minPrefix = maxPrefix;
                prefix = strs[i - 1].substring(0, minPrefix);
            }
        }
        return prefix;
    }
}
