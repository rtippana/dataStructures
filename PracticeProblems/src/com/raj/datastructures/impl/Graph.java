package com.raj.datastructures.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.raj.datastructures.nodes.GraphNode;
import com.raj.datastructures.nodes.GraphNode.State;

public class Graph {

	public List<GraphNode> nodes;

	public Graph() {
		this.nodes = new ArrayList<GraphNode>();
	}

//Breadth First Search

	public void bfs(Graph graph) {
		
		LinkedList<GraphNode> que = new LinkedList<GraphNode>();	
		que.addAll(graph.nodes);
		
		while(!que.isEmpty()) {
			GraphNode node = que.removeFirst();
			if(!State.visited.equals(node.state) ) {
				que.addAll(node.children);
				System.out.print(node.data);
			}
			node.state = State.visited;
		}	
	}

//Depth First Search
	public void dfs(Graph graph) {
		for(GraphNode node: graph.nodes) {
			dfs(node);
		}
	}
	private void dfs(GraphNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data);
		node.state=State.visited;
		for(GraphNode child: node.children) {
			if(!State.visited.equals(child.state)) {
				dfs(child);
			}
		}
	}


//Bidirectional Search to find the shortest path


}
