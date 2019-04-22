package com.raj.sort;

import com.raj.test.TestUtil;

public class SortedMerge {

	public static void main(String[] args) {
		
		int[] a = new int[] {1,2,3,0,0,0,0};
		int[]b = new int[] {4,5,6};
		TestUtil.printArray(SortedMerge.merge(a, b, 3, 3));
		
	}
	
	
	
	//
	 // Given 2 sorted arrays A, B. Merge B into A. 
	 // Assume that A has enough space to hold B
	 

	public static int[] merge(int[] a, int[] b, int countA, int countB) {
		if(b.length ==0) {
			return a;
		}
		int index = countA + countB -1;
		while(countB>0) {
			if(countA>0 && a[countA-1]> b[countB-1]) {
				a[index--]=a[countA-1];
				countA--;
			} else {
				a[index--] = b[countB-1];
				countB--;
			}
		}
		return a;
	}
}
