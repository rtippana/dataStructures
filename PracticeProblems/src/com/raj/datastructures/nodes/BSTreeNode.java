/**
 * 
 */
package com.raj.datastructures.nodes;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class BSTreeNode {
	
	public int data;
	public BSTreeNode left, right;
	
	public BSTreeNode(int data) {
		this.data=data;
		left=null;
		right=null;
	}
	
	//O(h)
	public void insert(int val) {
		if(this.left==null && val < this.data) {
			this.left = new BSTreeNode(val);
		} else if(this.right == null && val>=this.data) {
			this.right = new BSTreeNode(val);
		} else if(this.left!= null && val <this.data) {
			this.left.insert(val);
		} else if(this.right != null && val >=this.data) {
			this.right.insert(val);
		}
	}
	
	//O(logN)
	public boolean contains(int val) {
		if(this.data==val) {
			return true;
		}
		if(val <this.data && this.left!=null){
			this.left.contains(val);
		} else if(this.right!=null) {
			this.right.contains(val);
		}
		return false;
	}


}
