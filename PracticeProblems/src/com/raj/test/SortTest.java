package com.raj.test;

import com.raj.sort.Sort;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{2,-1,0,60,3,1};
		TestUtil.printArray(input);
		System.out.println("New Sorted Array");
		Sort srt = new Sort();
		TestUtil.printArray(srt.mergeSort(input));
		System.out.println("\nNew Quick Sorted Array");
		TestUtil.printArray(srt.quickSort(input));
		
	}
}
