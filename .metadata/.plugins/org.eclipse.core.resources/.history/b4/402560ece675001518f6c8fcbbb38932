package com.guilin.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternLC290 {
	/*
	 * Given a pattern and a string str, find if str follows the same pattern.

	*Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

	*Examples:
	*	pattern = "abba", str = "dog cat cat dog" should return true.
	*	pattern = "abba", str = "dog cat cat fish" should return false.
	*	pattern = "aaaa", str = "dog cat cat dog" should return false.
	*	pattern = "abba", str = "dog dog dog dog" should return false.
	*Notes:
	*	You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
	 */

	// Solution 1
	// Character - String pair
	public boolean wordPattern(String pattern, String str) {
		String [] words = str.split(" ");
		if (words.length != pattern.length()) {
			
		}
		
		Map<Character, String> map = new HashMap<Character, String>();
		Set <String> set = new HashSet<String>();
		int index = 0;
		for (String word : words) {
			String preAppearance = map.put(pattern.charAt(index), word); // get the previous value of one element in a map
			index++;
			// Return false if 1) previous value is null and current value is not; 2) previous value is not null, and not equal to current value
			if ((preAppearance == null) && (set.contains(word)) || ((preAppearance != null) && !(preAppearance.equals(word)))){
				return false;
			}
			set.add(word);
		}
		return true;
	}
	
	// Solution 2
	// Still go through pattern characters and words in Parallel
	public boolean wordPattern2(String pattern, String str) {
		String [] words = str.split(" ");
		if (words.length != pattern.length()) {
			return false;
		}
		Map <Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < words.length; i++) {
			char c = pattern.charAt(i);
			
			// parallel checking
			if (map.containsKey(c)) { // has previous value
				if (!map.get(c).equals(words[i])) { // but previous value not equal to current value
					return false;
				}
			} else { // no previous value
				if (map.containsValue(words[i])){ // but there is value for current
					return false;
				}
			}
			map.put(c, words[i]);
		}
		return true;
	}
}
