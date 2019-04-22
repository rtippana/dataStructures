/**
 * 
 */
package com.raj.datastructures.impl;

import java.util.ArrayList;
import java.util.List;

import com.raj.datastructures.nodes.TreeNode;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class Tree {
	
	public List<Object> traverseBF(TreeNode node) {
		
		List<TreeNode> processor = new ArrayList<TreeNode>();
		List<Object> result = new ArrayList<Object>();
		processor.add(node);
		//keep the every node in the processor and get all the children for each of them 
		//and add it to processor
		while(processor.size()>0){
			TreeNode tempNode = processor.get(0);
			result.add(tempNode.getData());
			List<TreeNode> childLst = tempNode.getchildren();
			for(TreeNode child : childLst ){
				processor.add(child);
			}
			processor.remove(tempNode);
		}
		
		return result;
	}
	
	public List<Object> traverseDF(TreeNode node) {
		
		List<TreeNode> processor = new ArrayList<TreeNode>();
		List<Object> result = new ArrayList<Object>();
		processor.add(node);
		//keep the every node in the processor and get all the children for each of them
		while(processor.size()>0){
			TreeNode tempNode = processor.get(0);
			List<TreeNode> childLst = tempNode.getchildren();
			processor = getNewProcessor(childLst, processor);
			result.add(tempNode.getData());
			processor.remove(tempNode);
		}
		
		return result;
	}

	private List<TreeNode> getNewProcessor(List<TreeNode> childLst, List<TreeNode> processor) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		for(TreeNode obj: childLst){
			result.add(obj);
		}
		for(TreeNode obj: processor){
			result.add(obj);
		}
		return result;
	}
	
	public List<Integer> getLevelWidth(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		int counter =0;
		List<TreeNode> processor = new ArrayList<TreeNode>();
		processor.add(root);
		processor.add(new TreeNode("Stop"));
		while(processor.size()>0){
			TreeNode node = processor.get(0);
			List<TreeNode> childLst = node.getchildren();
			if(node.getData().equals("Stop")){
				result.add(counter);
				counter=0;
				processor.remove(node);
				if(processor.size() > 0){
					processor.add(node);
				}
			} else {
				counter++;
				for(TreeNode childNode: childLst){
					processor.add(childNode);
				}
				processor.remove(node);
			}
		}
		return result;
	}

}
