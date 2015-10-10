package com.guilin.lint;

import java.util.Arrays;

public class TwoStringsAreAnagram_Lint_158 {
	/*
	 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
	 * 
	 * Example
	 * Given s="abcd", t="dcab", return true.
	 * 
	 * Challenge
	 * O(n) time, O(1) extra space
	 * 
	 */
	
	/**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
	
	//Solution 1
	//Convert two strings into char arrays, sort, convert back and compare
    public boolean anagram1(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        return sortCharacter(s).equals(sortCharacter(t));
    }
    
    private static String sortCharacter(String str){
        char[] charArray = str.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
    
    //Solution2
    //take each character of one String into Char Array, compare to another String, 
    //if contains, delete that character (in StringBuffer or StringBuilder)
    //Otherwise, return false
    public boolean anagram2(String s, String t) {
        
        if (s.length() != t.length()){
            return false;
        }
      
        StringBuilder sb = new StringBuilder(s);
        char[] charArray = t.toLowerCase().toCharArray();
        
        for (Character ch : charArray){
            int index = String.valueOf(sb).toLowerCase().indexOf(ch);
            
            if (index == -1){
                return false;
            }
            sb.delete(index, index + 1);
        }
        
        return true;
    }
}
