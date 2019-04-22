/**
 * 
 */
package com.raj.datastructures.impl;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class Stack<T> {
	
	private class StackNode<T> {
		private T data;
		private StackNode<T> next;
		public StackNode(T value) {
			this.data = value;
		}
	}

	private StackNode<T> top;
	public int size =0;
	
	public void push(T data) {
		StackNode<T> node = new StackNode<T>(data);
		node.next = top;
		top = node;
		size++;
	}
	
	public T pop() {
		if(top == null) {
			return null;
		}
		T data = top.data;
		top = top.next;
		size--;
		return data;
	}
	
	public T peek() {
		/*if(top == null) {
			return null;
		}
		return top.data;*/
		return top==null?null:top.data;
	}
	
	/** Try to consolidate the lines of codes, instead of if else, 
	 *  we can use just one line here
	 * @return
	 */
	public boolean isEmpty() {
		/*if(top == null) {
			return true;
		}
		return false;*/
		return top==null;
	}
	
}
