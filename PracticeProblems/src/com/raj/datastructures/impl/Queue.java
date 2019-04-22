/**
 * 
 */
package com.raj.datastructures.impl;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class Queue<T> {

	private class QueueNode<T> {
		
		private QueueNode<T> next= null;
		private T data = null;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	//For queue we need to  know the first one and last one 
	private QueueNode<T> first = null;
	private QueueNode<T> last = null;
	
	public void push(T data) {
		QueueNode<T> node = new QueueNode<T>(data);
		if(last != null) {
			last.next=node;
		}
		last = node;
		if(first == null) {
			first = node;
		}
	}
	
	public T pop() {
		if(first == null){
			return null;
		}
		T item = first.data;
		first = first.next;
		if(first==null) {
			last = null;
		}
		return item;
	}
	
}
