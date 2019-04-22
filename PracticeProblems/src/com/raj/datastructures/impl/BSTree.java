package com.raj.datastructures.impl;

import java.util.ArrayList;
import java.util.List;

import com.raj.datastructures.nodes.BSTreeNode;

public class BSTree {

	public static void main(String[] args) {
		BSTreeNode bnode = new BSTreeNode(7);
		BSTree bs = new BSTree();
		bnode.insert(10);
		bnode.insert(2);
		bnode.insert(1);
		bnode.insert(3);
		bnode.insert(8);
		bnode.insert(12);
		bnode.insert(25);
		bnode.insert(14);
		bnode.insert(15);

		bs.inOrderTraversal(bnode);
		System.out.println("\nNew Print with Result\n");
		System.out.println(bs.inOrderTraversal(bnode, new ArrayList<Integer>()));
		System.out.println();
		System.out.println(bs.preOrderTraversal(bnode,  new ArrayList<Integer>()));
		System.out.println();
		System.out.println(bs.postOrderTraversal(bnode,  new ArrayList<Integer>()));
		System.out.println(bs.isBalanced(bnode));
		System.out.println("Min --> " +bs.minValue(bnode));
		System.out.println("MAX --> " +bs.maxValue(bnode));


	}
	
	//This gives the sorted data
	//Time - O(N) , Space O(1)
	public void inOrderTraversal(BSTreeNode node) {
		if(node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.data + ",");
		inOrderTraversal(node.right);
		
	}
	//Time - O(N) , Space O(1)
	//Left -- Root -- Right
	public List<Integer> inOrderTraversal(BSTreeNode node, ArrayList<Integer> result) {
		
		if(node == null) {
			return result;
		}
		inOrderTraversal(node.left, result);
		System.out.print(node.data + ",");
		result.add(node.data);
		inOrderTraversal(node.right, result);
		return result;
	}
	//Time - O(N) , Space O(1)
	//Root -- Left -- Right
	public List<Integer> preOrderTraversal(BSTreeNode node, ArrayList<Integer> result) {
		if(node == null) {
			return result;
		}
		result.add(node.data);
		preOrderTraversal(node.left, result);
		preOrderTraversal(node.right, result);
		
		return result;
		
	}
	
	//Time O(n), Space O(1)
	//left --> Right --> Root
	public List<Integer> postOrderTraversal(BSTreeNode node, ArrayList<Integer> result) {
		if(node == null) {
			return result;
		}
		
		postOrderTraversal(node.left, result);
		postOrderTraversal(node.right,result);
		result.add(node.data);
		return result;
		
	}
	
	//Breadth First Search
	//Time - O(N) , Space O(n)
	public void breadthFirstSearch(BSTreeNode root) {
		List<BSTreeNode> processor = new ArrayList<BSTreeNode>();
		processor.add(root);
		while(!processor.isEmpty()) {
			BSTreeNode curr = processor.get(0);
			System.out.println(curr.data); //process the node
			//add children to the end of the list
			if(curr.left != null) {
				processor.add(curr.left);
			}
			if(curr.right != null) {
				processor.add(curr.right);
			}
			//remove the current node as its processed.
			processor.remove(curr);
		}
		
	}
	
	//Depth First Search
	//Time - O(N) , Space O(n)
	public void depthFirstSearch(BSTreeNode root) {
		List<BSTreeNode> processor = new ArrayList<BSTreeNode>();
		processor.add(root);
		while(!processor.isEmpty()) {
			BSTreeNode curr = processor.get(0);
			System.out.println(curr.data); //process the node.
			//Add children to the start of the processor
			processor = getNewProcessor(processor, curr);
			//remove the current node
			processor.remove(curr);
		}
	}

	private List<BSTreeNode> getNewProcessor(List<BSTreeNode> processor, BSTreeNode curr) {
		List<BSTreeNode> result = new ArrayList<BSTreeNode>();
		if(curr.left!=null) {
			result.add(curr.left);	
		}
		if(curr.right !=null) {
			result.add(curr.right);
		}
		result.addAll(processor);
		return result;
	}
	

	
	//Get Height of the Binary Tree/ Binary Search Tree
	//Time - O(N) , Space O(1)
	public int findHeight(BSTreeNode node) {
		if (node == null) return 0;
		return 1 + Math.max(findHeight(node.left), findHeight(node.right));
	}
	
	//Check if Binary Tree is balanced or not
	public boolean isBalanced(BSTreeNode root) {
		if(root == null) {
			return true;
		}
		if(Math.abs(findHeight(root.left)-findHeight(root.right)) >1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	//Validate Binary Search Tree
	//Time O(n), space O(1)
	public boolean isValidBST(BSTreeNode root) {
		
		if(root == null) {
			return true;
		}
		return isValidBST(root, null, null);
	}
	
	private boolean isValidBST(BSTreeNode node, Integer min, Integer max) {
		if(min !=null && node.data < min) {
			return false;
		}
		if(max!=null && node.data>max) {
			return false;
		}
		if(node.left != null && !(isValidBST(node.left, min, node.data))) {
			return false;
		}
		if(node.right!=null && !(isValidBST(node.right, node.data, max))) {
			return false;
		}
		return true;
	}
	
	/*
	 * Find MIN Value of the Tree
	 */
	public int minValue(BSTreeNode root) {
		if(root == null) {
			return -1;
		}
		BSTreeNode node = root;
		while(node.left !=null) {
			node = node.left;
		}
		return node.data;
	}
	/*
	 * Max Value
	 */
	public int maxValue(BSTreeNode root) {
		if(root == null){
			return -1;
		}
		BSTreeNode node = root;
		while(node.right!=null) {
			node = node.right;
		}
		return node.data;
	}
}
