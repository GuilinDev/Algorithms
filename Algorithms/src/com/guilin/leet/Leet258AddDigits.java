package com.guilin.leet;

public class Leet258AddDigits {
	/*
	 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

	 *For example:

		*Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

		*Follow up:
		*Could you do it without any loop/recursion in O(1) runtime?

	*Hint:
		*A naive implementation of the above process is trivial. Could you come up with other methods? 
		
	 */
	
	// Solution 1: Native solution
	public int addDigits(int num) {
        int target = num;
        int digits = 10;
        
        while (digits >= 10) {
            digits = 0;
            while (target > 0) {
                digits += target % 10;
                target /= 10;
            }
            target = digits;
        }
        return digits;
    }
	
	// Solution2:  O(1) solution
	/* Output for solution 1
	in  out  in  out
	0   0    10  1
	1   1    11  2
	2   2    12  3
	3   3    13  4
	4   4    14  5
	5   5    15  6
	6   6    16  7
	7   7    17  8
	8   8    18  9
	9   9    19  1
	
	The outputs follows this pattern:
	
	out = (in - 1) % 9 + 1
	*/
	
	public int addDigits2(int num) {
		if (num == 0) {
            return 0;
        }
        return (num - 1) % 9 + 1;
	}
}
