/**
 * 
 */
package com.raj.datastructures.impl;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class StackClass {
	
	private Object[] stack = null;
	private int size = 0;
	
	public StackClass(int size) {
		this.stack = new Object[size];
	}
	
	public void push(Object obj) {
		this.stack[size] = obj;
		this.size++;
	}
	
	public Object pop() {
		if(size<0) {
			return null;
		} 
		Object result = this.stack[this.size-1];
		this.stack[this.size-1] = null;
		this.size--;
		return result;
	}
	
	public Object peek() {
		if(size <=0) {
			return null;
		}
		return this.stack[this.size-1];
	}
	
	public int length() {
		return this.size;
	}
	
	public void printStack(){
		for(int i=0; i<this.size; i++){
			System.out.print(this.stack[i]);
		}
	}

}
