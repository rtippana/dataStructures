/**
 * 
 */
package com.raj.test;

import com.raj.datastructures.impl.Graph;
import com.raj.datastructures.nodes.GraphNode;

/**
 * @author rajeev
 *
 */
public class GraphTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testBFS();
		System.out.println("Deapth\n");
		testdFS();

	}
	/*
	 * Graph
	 * 1: 0,2,22
	 * 3: 
	 * 2:1 3 
	 * 0:5
	 */
	private static void testBFS() {
		Graph graph = new Graph();
		GraphNode nodea = new GraphNode(1);
		GraphNode nodeb = new GraphNode(3);
		GraphNode nodec = new GraphNode(2);
		GraphNode noded= new GraphNode(0);
		noded.children.add(new GraphNode(5));
		nodea.children.add(noded);
		nodea.children.add(nodec);
		nodec.children.add(nodea);
		nodec.children.add(nodeb);
		nodea.children.add(new GraphNode(22));
		graph.nodes.add(nodea);
		graph.nodes.add(nodeb);
		graph.nodes.add(nodec);
		graph.nodes.add(noded);
		
		graph.bfs(graph);
	}
	
	/*
	 * Graph
	 * 1: 0,2,22
	 * 3: 
	 * 2:1 3 
	 * 0:5
	 */
	private static void testdFS() {
		Graph graph = new Graph();
		GraphNode nodea = new GraphNode(1);
		GraphNode nodeb = new GraphNode(3);
		GraphNode nodec = new GraphNode(2);
		GraphNode noded= new GraphNode(0);
		noded.children.add(new GraphNode(5));
		nodea.children.add(noded);
		nodea.children.add(nodec);
		nodec.children.add(nodea);
		nodec.children.add(nodeb);
		nodea.children.add(new GraphNode(22));
		graph.nodes.add(nodea);
		graph.nodes.add(nodeb);
		graph.nodes.add(nodec);
		graph.nodes.add(noded);
		int a = 5/2;
		int b= (int)Math.floor(5/2);
		System.out.println(a);
		System.out.println(b);
		
		graph.dfs(graph);
	}

}
