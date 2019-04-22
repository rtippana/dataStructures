/**
 * 
 */
package com.raj.datastructures.impl;

import com.raj.datastructures.nodes.BinaryNode;
import com.raj.datastructures.nodes.Node;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class BinarySearchTree {
	
	public static void main(String[] args) {
		BinaryNode bNode = new BinaryNode(50);
		bNode.insert(23);
		bNode.insert(45);
		bNode.insert(68);
		System.out.println("Binary Node");
		//System.out.println(bNode.contains(45));
		
		BinarySearchTree btree = new BinarySearchTree();
		System.out.println(btree.findHeight(bNode));
	}
	
	public boolean validateBinarySearchTree(BinaryNode root) {
		
		return validBSearchTree(root, null, null);
		

	}
	
	private boolean validBSearchTree(BinaryNode node, Integer min, Integer max) {
		
		if(max != null && node.getData() > max) {
			return false;
		}
		if(min !=null && node.getData() < min) {
			return false;
		}
		
		if(node.getLeft() !=null && !(validBSearchTree(node.getLeft(), min, node.getData()))){
			return false;
		}
		
		if(node.getRight() != null && validBSearchTree(node.getRight(), node.getData(), max)) {
			return false;
		}
		
		return true;
		
	}
	
	public  int heightOfBtree(BinaryNode node) {
		return findHeight(node);
	}
	
	private int findHeight(BinaryNode node) {
		if (node == null) return 0;
		return 1 + Math.max(findHeight(node.getLeft()), findHeight(node.getRight()));
	}
	//Distance between 2 nodes
	//The distance between two nodes can be obtained in terms of lowest common ancestor.

	//Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 
    //'n1' and 'n2' are the two given keys
    //'root' is root of given Binary Tree.
    //'lca' is lowest common ancestor of n1 and n2
    //Dist(n1, n2) is the distance between n1 and n2.
	//****Better solution - We first find LCA of two nodes. Then we find distance from LCA to two nodes.
	
	private BinaryNode lca(BinaryNode root, int n1, int n2) {
		
		if(root == null){
			return root;
		}
		
		if(root.getData() == n1 || root.getData()==n2) {
			return root;
		}	
		BinaryNode left = lca(root.getLeft(), n1, n2);
		BinaryNode right = lca(root.getRight(),n1,n2);
		if(left !=null && right != null){
			return root;
		}
		else 		//present in one of the sides
		return left !=null?left:right;
		
		
	}
	
	private int findLevel(BinaryNode root, int n, int level) {
		if(root==null){
			return -1;
		}	
		if(root.getData()==n){
			return level;
		}
		int left = findLevel(root.getLeft(), n, level +1);
		return left!=-1?left:findLevel(root.getRight(),n,level+1);	
		
		
	}
	
	public int distance(BinaryNode root, int a, int b) {
		BinaryNode lca = lca(root, a, b);
		int al = findLevel(lca, a, 0);
		int bl = findLevel(lca, b,0);
		
		return al+bl;
	}	
	
}
