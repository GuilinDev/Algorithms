package com.guilin.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet15ThreeSum {
	/*
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

		Note:
		Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c)
		The solution set must not contain duplicate triplets.
    	For example, given array S = {-1 0 1 2 -1 -4},

    	A solution set is:
    	(-1, 0, 1)
    	(-1, -1, 2)
	 */
	
	// Thinking: Time  ~ O(N^2); Space ~ O(1)
	// sort the array at first, then select num[i] as -target, then among num[i+1 .. N-1] look for 2Sum = -target by using two pointers
	// there may be same elements in an array, using this to avoid duplicates: use increment(num, lo) instead of io++, and use
	// decrement(num, hi) instead of hi--, if there are same elements in the array, continue execute until value changed
	
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> listSet = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i = increment(nums, i)) {// lo and hi have assigned
            int a = nums[i], lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int b = nums[lo], c = nums[hi];
                if (a + b + c == 0) {
                    List<Integer> list = Arrays.asList(a, b, c);
                    listSet.add(list);
                    
                    lo = increment(nums, lo);
                    hi = decrement(nums, hi);
                } else if (a + b + c > 0) {
                    hi = decrement(nums, hi);
                } else if ( a + b + c < 0) {
                    lo = increment(nums, lo);
                }
            }
        }
        return listSet;
    }
    
    private int increment(int[] num, int lo) {
        //avoid repeat
        while (lo < num.length - 1 && num[lo] == num[++lo]){}
        return lo;
    }
    private int decrement(int[] num, int hi) {
        //avoid repeat
        while (hi > 0 && num[hi] == num[--hi]){}
        return hi;
    }

}
