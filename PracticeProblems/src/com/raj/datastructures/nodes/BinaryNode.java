/**
 * 
 */
package com.raj.datastructures.nodes;
import java.util.List;
import java.util.ArrayList;

/**
 * @author rajeev.tippanaboyina
 * common question - add a new node to the binary tree
 * common question - validate a binary tree
 * binary tree vs binary search tree
 */
public class BinaryNode {

	private Integer data;
	
	private BinaryNode left, right;
	
	public BinaryNode(Integer value){
		setData(value);
		left = null;
		right = null;
	}
	
	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}
	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	/**
	 * Add a element to the binary search tree
	 * @param data
	 */
	public void insert(Integer data) {
		if(this.left !=null && data < this.getData()) {
			this.left.insert(data);
		} else if(data < this.getData()) {
			this.left = new BinaryNode(data);
		} else if(this.right !=null && data > this.getData()) {
			this.right.insert(data);
		} else if(data > this.getData()) {
			this.right = new BinaryNode(data);
		}
	}
	

	/**
	 * This method will get a data and returns a node if any node has the data
	 * @param data
	 * @return
	 */
	public boolean contains(Integer data) {
		
		if(this.getData() == data) {
			return true;
		}
		if(data< this.getData() && this.left !=null ) {
			this.left.contains(data);
		} else if(data > this.getData() && this.right !=null) {
			this.right.contains(data);
		}
		 return false;
	}
	
	public List<Integer> traverseBF(BinaryNode node) {
		List<Integer> result = new ArrayList<Integer>();
		List<BinaryNode> processor = new ArrayList<BinaryNode>();
		processor.add(node);
		while(processor.size() > 0) {
			BinaryNode tempNode = processor.get(0);
			result.add(tempNode.getData());
			//add left right children after the current node
			processor.add(tempNode.getLeft());
			processor.add(tempNode.getRight());
			processor.remove(tempNode);
		}
		return result;
	}
	
	public List<Integer> traverseDF(BinaryNode node) {
		List<Integer> result = new ArrayList<Integer>();
		List<BinaryNode> processor = new ArrayList<BinaryNode>();
		processor.add(node);
		while(processor.size() > 0) {
			BinaryNode tempNode = processor.get(0);
			result.add(tempNode.getData());
			//add left right children before the current node
			processor = getfirstProcessor(processor, tempNode);
			processor.remove(tempNode);
		}
		return result;
	}
	
	private List<BinaryNode> getfirstProcessor(List<BinaryNode> parents, BinaryNode node) {
		List<BinaryNode> result = new ArrayList<BinaryNode>();
		result.add(node.getLeft());
		result.add(node.getRight());
		result.addAll(parents);
		return result;
	}
}
