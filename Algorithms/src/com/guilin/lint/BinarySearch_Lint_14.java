package com.guilin.lint;

public class BinarySearch_Lint_14 {
	/*
	 * For a given sorted array (ascending order) and a target number, 
	 * find the first index of this number in O(log n) time complexity.
	 * If the target number does not exist in the array, return -1.
	 * 
	 * Example
	 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
	 * 
	 * Challenge
	 * If the count of numbers is bigger than 2^32, can your code work properly?
	 * 
	 */
	
	 /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        
        if(nums.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int middle = 0;
        
        //loop to narrow array two numbers
        while(start + 1 < end){//start + 1 < end --- prevent dead loop
        	//If the count of numbers is bigger than 2^32, can your code work properly?
        	// to prevent int overflow when both end and start are close to 2^32 
            middle = start + (end - start)/2;
            if (nums[middle] < target){
                start = middle;
            }else if(nums[middle] == target){
                end = middle;//
            }else if(nums[middle] > target){
                end = middle;
            }
        }
        
        // check which one is the target among two numbers
        if (nums[start] == target){
           return start;
        }
        if (nums[end] == target){
            return end;
        }
            
        return -1;
    }

}
