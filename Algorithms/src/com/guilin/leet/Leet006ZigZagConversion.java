package com.guilin.leet;

public class Leet006ZigZagConversion {
	/*
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

		P   A   H   N
		A P L S I I G
		Y   I   R
		And then read line by line: "PAHNAPLSIIGYIR"
		Write the code that will take a string and make this conversion given a number of rows:
		
		string convert(string text, int nRows);
		convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 */
	// time - O(N)
	// Space - O(1)
	// skip1: main numbers are like P A Y, A L I .. each one's distance: 2*numRows - 2
	// skip: numbers are on the slashes, distance between main numbers and slash numbers: --2 between two main numbers (except the first and last line, each main number are followed a slash number)
	// if numNumbers = 1, the above rule does not apply, should be taken as a boundary case
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		StringBuilder str = new StringBuilder();
		int skip1 = numRows + (numRows - 2);
		int skip2 = skip1;
		
		for (int i = 0; i < numRows; i++) {
			if (i != 0 && i != numRows - 1){//not first and last line
				skip2 -= 2;
			}
		
			int index = i;
			while (index < s.length()) {
				str.append(s.charAt(index));
				if (i != 0 && i != numRows - 1 && (index + skip2) < s.length()) {
					str.append(s.charAt(index + skip2));
				}
				index += skip1;
			}
		}
		return str.toString();
	}
}
