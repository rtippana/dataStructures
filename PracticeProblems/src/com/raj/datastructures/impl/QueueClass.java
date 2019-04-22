/**
 * 
 */
package com.raj.datastructures.impl;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class QueueClass {
	
	private Object[] queue = null;
	private int size = 0;
	
	public QueueClass(int size){
		this.queue = new Object[size];
	}
	
	public void push(Object obj) {
		if(this.size >= this.queue.length){
			System.out.println("Queue Full");
			return;
		}
		this.queue[size] =obj ;
		size++;
	}
	
	public Object pop() {
		Object popObject = this.queue[0];
		for(int i=1; i<size; i++ ){
			this.queue[i-1] = this.queue[i];
		}
		this.queue[size-1] = null;
		this.size--;
		return popObject;
		
	}
	//Show last element without removing it
	public Object peek() {
		if(size >0){
			return this.queue[size-1];
		} 
		return null;
		
	}
	
	public void printQueue() {
		
		for(int i=0; i< this.queue.length ; i++ ){
			System.out.print(this.queue[i]);
		}
	}

	public int length() {
		return this.size;
	}
}
