package com.raj.datastructures.impl;

import com.raj.datastructures.nodes.Node;

public class LinkedList {
	
	private Node head = null;
	
	public LinkedList() {
		head = null;
	}
	
	/**
	 * Head always go to the first one. 
	 * @param value
	 */
	public void insertFirst(Object value) {
		Node node = new Node(value, head);
		this.head = node; 
	}
	
	public void printList() {
		Node next = this.head.getNext();
		Object data = this.head.getData();
		System.out.print(" Data: " + data);
		
		while(next !=null) {
			System.out.print(" Data: " + next.getData());
			next = next.getNext();
		}
	}
	
	public int size() {
		if(this.head == null){
			return 0;
		}
		Node next = this.head;
		int size = 0;
		while(next !=null) {
			size++;
			next = next.getNext();
		}
		return size;
	}
	
	public Node getFirst() {
		return this.head;
	}
	
	public Node getLast() {
		if(this.head ==null){
			return null;
		}
		Node result = this.head;
		Node next = this.head.getNext();
		while(next!=null){
			result = next;
			next = next.getNext();
		}
			
		return result;
	}

	public void clear() {
		this.head =null;
	}
	
	public void removeFirst() {
		if(this.head != null) {
			Node first = this.head.getNext();
			this.head = first;
		}
		
	}
	
	public void removeLast() {
		if(this.head != null) {
			if(this.head.getNext() == null){
				this.head=null;
				return;
			}
			Node previous = this.head;
			Node current = this.head.getNext();

			while(current.getNext() != null) {
				previous = current;
				current = current.getNext();
			}
			previous.setNext(null);
		}
	}
	
	public void insertLast(Object data) {
		Node lastNode = getLast();
		if(lastNode == null) {
			this.head = new Node(data, null);
		} else {
			lastNode.setNext(new Node(data,null));
		}
	}
	
	public Node getAt(int index) {
		if(this.head == null || index > size()) {
			return null;
		} 
		Node current = this.head;
		Node nextNode = this.head.getNext();
		int counter=1;
		while(counter < index){
			current = nextNode;
			nextNode = nextNode.getNext();
			counter++;
		}
		if(counter==index) {
			return current;
		}
		return null;
	}
	
	public void removeAt(int index) {

		/*if(this.head != null && index <= size()){

			Node previous = getAt(index-1);
			Node nextNode = getAt(index+1);
			if(previous == null){
				this.head = nextNode;
			} else if(nextNode == null) {
				previous.next = null;
			} else {
				previous.next = nextNode;
			}
			
		}*/
		
		//Other solution
		if(this.head !=null && index <= size()) {
			if(index ==1){
				this.head = this.head.getNext();
			} else {
				Node previous = getAt(index-1);
				if(previous.getNext().getNext() == null) {
					previous.setNext(null);
				} else {
					previous.setNext(previous.getNext().getNext());
				}
			}
		}
	}
	
	public void insertAt(Object data, int index) {

		if(index <=size() && index >0 ) {
			Node currentNode = getAt(index-1);
			if(currentNode == null){
				Node insertNode = new Node(data,this.head);
				this.head = insertNode;
			} else {
				Node insertNode = new Node(data,currentNode.getNext() );
				currentNode.setNext(insertNode);
			}
			
		}
	}
	
	/**
	 * Do not use size or getAt function
	 * @return
	 */
	public Node getMidPoint() {
		
		if(this.head !=null){
			Node slow = this.head;
			Node fast = this.head;
			while(fast.getNext()!=null && fast.getNext().getNext() !=null){
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}
			return slow;
		}
		
		return null;
	}
	/*
	 * Find if the list is curcular
	 * 
	 */
	public boolean isCircular() {
		
		if(this.head !=null){
			Node slow = this.head;
			Node fast = this.head;
			while(fast.getNext()!=null && fast.getNext().getNext() !=null){
				slow = slow.getNext();
				fast = fast.getNext().getNext();
				if(slow.equals(fast)) {
					return true;
				}
			}
		}
		return false;
		
	}
	/*
	 * Find the kth to Last Element
	 * 
	 */
	
	public Node getKthElement(Node node, int k) {
		if(node == null || node.getNext() == null) {
		 return null;
		}

		Node slow = head;
		Node fast = head;
		for(int i=0; i< k; i++) {
			if(fast == null){
				return null; // out of bounds
			}
			fast = fast.getNext();
		}
		while(fast !=null) {
			fast = fast.getNext();
			slow = slow.getNext();
		}
		
		return slow;
	}
}
