package com.raj.sort;

public class BinarySearch {

	public static void main(String[] args) {

		BinarySearch bs = new BinarySearch();

		System.out.println(bs.find(new int[] { 1, 2, 3, 4, 5, 6 }, 1));

	}

	public boolean find(int[] array, int n) {

		// Binary Search divide the array into half and search

		return find(array, 0, array.length, n);

	}

	// [1,2,3,4,5,6] 2

	/*
	 * low = 0
	 * max = 5
	 * mid = 0 + 5 /2 = 2	 
	 * array[2] = 3
	 * 2<3 --> go left
	 * low = 0, max = 2
	 * mid = 2
	 * 
	 */

	//

	// Space O(1), Time O(log(n))

	private boolean find(int[] array, int low, int max, int n) {

		if (low <= max) {
			int mid = low + (max - low) / 2;
			System.out.println(mid);
			if (n == array[mid]) {
				return true;

			}
			if (n < array[mid]) {
				return find(array, low, mid-1, n);
			} else {
				return find(array, mid + 1, max, n);
			}
		}
		return false;
	}

}
