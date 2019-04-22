/**
 * 
 */
package com.raj.datastructures.nodes;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class Node {
	
	private Node next = null;
	private Object data = null;
	
	public Node(Object value, Node nextVal) {
		this.setNext(nextVal);
		this.setData(value);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
