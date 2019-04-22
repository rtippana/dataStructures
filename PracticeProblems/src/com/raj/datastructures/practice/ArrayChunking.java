package com.raj.datastructures.practice;

import java.util.Arrays;

public class ArrayChunking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Math.ceil(7.0/2));
		int[][] array = ArrayChunking.arrayChunk(new int[]{1,2,3,4,5,6,7}, 2);
		System.out.println(Arrays.deepToString(array));

	}

	/*
	 * Given a Array and chunk Size, divide the array into multiple chunks
	 * [1,2,3,4,5,6,7],4 --> [[1,2,3,4],[5,6,7]]
	 * [1,2,3,4,5,6,7],2 --> [[1,2], [3,4],[5,6],[7]]
	 *sample
	 *i=0, j=0, chunkInd =0, n=2, length=7
	 *result = [4][2]
	 *loop
	 *i=2, j=0, chunkInd =1, n=2, length=7
	 *[0][0] = [0][1,2]
	 *[1]      [1][3,4]
	 
	 */
	public static int[][] arrayChunk(int[] array, int n) {
		if(n>= array.length || n<1) {
			return new int[][] {array};
		}
		//*******Remember doing this by 1.0 only them it makes 
		//the / work on float and result in 3.5 else it will give 3 
		//so ceil will just return 3.
		int numOfChunks = (int)Math.ceil((1.0*array.length)/n);
		int[][] result = new int[numOfChunks][n];
		int chunkInd=0; //this is for chunks;
		int j=0;
		for(int i=0; i<array.length; i++) {
			if(j==n) { //chunk reached it max size
				j=0;
				chunkInd++;
			}
			result[chunkInd][j++] = array[i];
		}
		
		return result;
	}
	
}
