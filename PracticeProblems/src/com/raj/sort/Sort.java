/**
 * 
 */
package com.raj.sort;

/**
 * @author rajeev
 *
 */
public class Sort {
	
	//Merge Sort with Array O(nlogn) average and worst case. 
	//Space complexity here is O(n) as we are creating 2 arrays every time
	/*
	 * 1. Divide the array into 2 halves left and right
	 * 2. call merge on each of them and return that
	 * 3. Merge function will fill in the result and return in every time.
	 */
	public int[] mergeSort(int[] array) {
		if(array.length==1) {
			return array;
		}
		int mid = array.length/2;
		int[] left = new int[mid];
		int[] right = new int[array.length-mid];
		for(int i=0;i<mid; i++) {
			left[i] = array[i];
		}
		for(int j=mid; j<array.length; j++) {
			right[j-mid] = array[j];
		}
		return merge(mergeSort(left),mergeSort(right));
	}

	private int[] merge(int[] left, int[] right) {
		int li=0;
		int ri=0;
		int[] result = new int[left.length+right.length];
		int current=0;
		while(li<left.length && ri<right.length) {
			if(left[li]<right[ri]) {
				result[current++] = left[li++];
			} else {
				result[current++] = right[ri++];
			}
		}
		if(li<left.length) {
			while(li<left.length) {
				result[current++] = left[li++];
			}
			
		}
		if(ri<right.length) {
			while(ri<right.length) {
				result[current++] = right[ri++];
			}
		}
		return result;
	}
	//End Merge Sort with Array
	
	/*Start Quick Sort 
	 * Average O(nLogN), worst Case O(n^2)
	 * Worst case becuase if the pivot is selected as wrong value
	 * Algorithm
	 * 1. Pick a element in the array.
	 * 2. See if there is a smallest element before that
	 * 
	 * 
	 * 
	 */
	
	public int[] quickSort(int[] array) {
		
		return quickSort(array, 0,array.length-1);
		
	}
	private int[] quickSort(int[] array, int left, int right) {
		if(left>=right) {
			return array;
		}
		int pivot = array[(left+right)/2];
		int index = partition(array, left, right, pivot);
		quickSort(array, left, index-1);
		quickSort(array, index, right);
		return array;
	}
	private int partition(int[] array, int left, int right, int pivot) {
		while(array[left]<pivot) {
			left++;
		}
		while(array[right]>pivot) {
			right-- ;
		}
		if(left<=right) {
			int a = array[left];
			array[left]=array[right];
			array[right]=a;
			left++;
			right--;
		}
		return left;
	}
}
