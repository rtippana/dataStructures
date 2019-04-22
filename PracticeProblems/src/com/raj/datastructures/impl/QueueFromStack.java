/**
 * 
 */
package com.raj.datastructures.impl;

/**
 * This class will use 2 stacks to implement a queue
 * @author rajeev.tippanaboyina
 *
 */
public class QueueFromStack {
	
	private StackClass stackA = null;
	private StackClass stackB = null;
	
	public QueueFromStack(int size) {
		stackA = new StackClass(size);
		stackB = new StackClass(size);
	}
	
	public void push(Object obj) {
		stackA.push(obj);
	}
	
	/**
	 * Move all elements from A to B and pop B and then move again
	 * @return
	 */
	public Object pop(){
		
		while(stackA.peek() !=null) {
			stackB.push(stackA.pop());
		}
		Object result = stackB.pop();
		while(stackB.peek() !=null) {
			stackA.push(stackB.pop());
		}
		return result;
	}
	
	public void printQueue() {
		stackA.printStack();
	}

	public Object peek() {
		while(stackA.peek() !=null) {
			stackB.push(stackA.pop());
		}
		Object result = stackB.peek();
		while(stackB.peek() !=null) {
			stackA.push(stackB.pop());
		}
		return result;
	}
}
