package com.raj.datastructures.impl;

public class AVLTree {

	/*
	 * This is a balanced tree The height is always O(nLogn)
	 * Every Insert/Removal, the tree balances itself.
	 * It may take extra steps but the insertion still remains as O(n)
	 * 
	 */
	
	private class Node {
		
		int data;
		Node left, right;
		int height;
		
	}
}
