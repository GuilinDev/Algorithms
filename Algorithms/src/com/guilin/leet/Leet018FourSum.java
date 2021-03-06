package com.guilin.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet018FourSum {
	/*
	 * k sum solution
	 * 1) Sort  array;
	 * 2) for loop by using k - 2, num[i_1], num[i_2], ..., num[i_{k-2}]
	 * 3) narrow from two directions, find num[i_{k-1}] and num[i_k]
	 * 
	 * Time ~ O(N^3)
	 * Space ~ O(1)
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listSet = new ArrayList<List<Integer>>();
        if (nums.length < 4) {
            return listSet;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i = increment(nums, i)) {
            for (int j = i + 1; j < nums.length - 2; j = increment(nums, j)) {
                int a = nums[i], b = nums[j], lo = j + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int c = nums[lo], d = nums[hi];
                    int sum = a + b + c + d;
                    if (sum == target) {
                        List<Integer> list = Arrays.asList(a, b, c, d);
                        listSet.add(list);
                        lo = increment(nums, lo);
                        hi = decrement(nums , hi);
                    } else if (sum < target) {
                        lo = increment(nums, lo);
                    } else {
                        hi = decrement(nums, hi);
                    }
                }
            }
        }
        return listSet;
    }
    
    private int increment(int[] num, int lo) {
        while (lo < num.length - 1 && num[lo] == num[++lo]) {}
        return lo;
    }
    
    private int decrement(int[] num, int hi) {
        while (hi > 0 && num[hi] == num[--hi]){}
        return hi;
    }
}
