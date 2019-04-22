/**
 * 
 */
package com.raj.datastructures.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rajeev
 *ˇ
 */
public class GraphNode {
	public int data;
	public State state;
	public List<GraphNode> children;
	
	public GraphNode(int val) {
		this.data = val;
		this.children = new ArrayList<GraphNode>();
	}

	public enum State{Unvisited, visited, visiting}
}
