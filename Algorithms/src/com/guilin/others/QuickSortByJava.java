package com.guilin.others;

public class QuickSortByJava {

	public static void main(String[] args) {
		int [] arr = {21, 34, 1, -6, -58, 12345, 33, -1, 0, 0, 31};
		if(arr != null && arr.length != 0){
			System.out.println("Before quick sort===>");
			for (int i = 0; i <= arr.length - 1; i++){
				System.out.print(arr[i] + " ");
			}
			
			System.out.println();
			
			System.out.println("After quick sort===>");
			quickSortRecursion(arr, 0, arr.length - 1);
			for (int i = 0; i <= arr.length - 1; i++){
				System.out.print(arr[i] + " ");
			}
		}
	}
	
	 // Recursive Solution
	public static void quickSortRecursion (int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			quickSortRecursion(arr, 0, pivot - 1);
			quickSortRecursion(arr, pivot + 1, right);
		}
	}
	private static int partition(int[] arr, int left, int right) {
		int temp = arr[left]; // first or last element
		while (left < right) {
			while (left < right && arr[right] >= temp) {
				right--;
			}
			arr[left] = arr[right]; // swap bigger (than temp) value from right to left
			while (left < right && arr[left] <= temp) {
				left++;
			}
			arr[right] = arr[left]; // swap smaller (than temp) value from left to right
		}
		
		arr[left] = temp;
		return left;
	}
}
