package com.guilin.lint;

import java.util.ArrayList;

public class SearchForARange_Lint_61 {
	/*
	 * Given a sorted array of n integers, find the starting and ending position of a given target value.
	 * If the target is not found in the array, return [-1, -1].
	 * 
	 * Example
	 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
	 * 
	 * Challenge
	 * O(log n) time.
	 */
	
	 /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
	
	//Binary Search - from left and from right to find left bound and right bound
	public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (A.size() == 0){
            arrayList.add(-1);
            arrayList.add(-1);
            return arrayList;
        }
        
        int start, end, mid;
        
        //Search left bound
        start = 0;
        end = A.size() - 1;
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if (A.get(mid) < target){
                start = mid;
            } else if (A.get(mid) == target){
                end = mid;//left bound must be at left
            } else{
                end = mid;
            }
        }
        if (A.get(start) == target){
            arrayList.add(start);
        } else if (A.get(end) == target){
            arrayList.add(end);
        } else {
            arrayList.add(-1);
            arrayList.add(-1);
            return arrayList;
        }
        
        // Search right bound
        start = 0;
        end = A.size() - 1;
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if (A.get(mid) < target){
                start = mid;
            } else if(A.get(mid) == target){
                start = mid;//right bound must be at right
            } else{
                end = mid;
            }
        }
        if (A.get(end) == target){
            arrayList.add(end);
        } else if (A.get(start) == target){
            arrayList.add(start);
        } else {
            arrayList.add(-1);
            arrayList.add(-1);
            return arrayList;
        }
    
        return arrayList;
    }
	
	//Straightforward solution - from left to right - mark first position and last position when meet
    public ArrayList<Integer> searchRange2(ArrayList<Integer> A, int target) {
        // write your code here
        
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        
        if (A.size() == 0){
            arrayList.add(-1);
            arrayList.add(-1);
            return arrayList;
        }
        
        int range = 0, single = 0;
        for (int i = 0; i <= A.size() - 1; i++){
            if (A.get(i) == target){
                if (range == 0){
                    arrayList.add(i);
                    single = i;
                    range += 1;
                }
                range += 1;
            }
            if (A.get(i) != target && range != 0){
                arrayList.add(i - 1);
                break;
            }
        }
        
        if (arrayList.size() == 0){
            arrayList.add(-1);
            arrayList.add(-1);
        }else if (arrayList.size() == 1){
            if (range - 1 == A.size()){
                arrayList.add(A.size() - 1);
            } else {
                arrayList.add(single);
            }
        }
        
        return arrayList;
    }

}
