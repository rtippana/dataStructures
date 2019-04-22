/**
 * 
 */
package com.raj.datastructures.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class TreeNode {
	
	private Object data = null;
	private List<TreeNode> children = null;
	
	public TreeNode(Object dataVal) {
		setData(dataVal);
		children = new ArrayList<TreeNode>();
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public List<TreeNode> getchildren(){
		return this.children;
	}

	public void addChild(Object child) {
		this.children.add(new TreeNode(child));
	}
	
	public void removeChild(Object child) {
		if(this.children.contains(child)) {
			this.children.remove(child);
		}
	}


}
