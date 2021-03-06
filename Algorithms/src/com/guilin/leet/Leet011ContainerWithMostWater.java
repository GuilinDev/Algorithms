package com.guilin.leet;

public class Leet011ContainerWithMostWater {
	/*
	 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

		Note: You may not slant the container.
	 */
	public int maxArea(int[] height) {
        // greedy algorithms, the shorter one will deside water volumn
        // use two pointers, search from begin and end, record the biggest volumn
		int maxWater = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {
			// record max water
			maxWater = Math.max(maxWater, right - left) * Math.min(height[left], height[right]);
			if (height[left] < height[right]) {
				left ++;
			} else {
				right--;
			}
		}
		return maxWater;
	}

}
