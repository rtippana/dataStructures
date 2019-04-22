/**
 * 
 */
package com.raj.datastructures.impl;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class StackWithMin {
	private class StackMinNode {
		int data =0;
		int min = 0;
		private StackMinNode next = null;
		public StackMinNode(int data) {
			this.data = data;
		}
	}
	private StackMinNode top = null;
	
	public void push(int data) {
		StackMinNode node = new StackMinNode(data);
		node.next=top;
		if(top == null) {
			node.min = data;
		} else {
			node.min = data<top.min?data:top.min;
		}
		top = node;			
	}
	
	public int pop() {
		if(top == null){
			return -1;
		}
		int result = top.data;
		top=top.next;
		return result;
	}
	
	public int minimum() {
		if(top==null){
			return -1;
		}
		return top.min;
	}
	
	public int peek() {
		if(top==null){
			return -1;
		}
		return top.data;
	}
}
