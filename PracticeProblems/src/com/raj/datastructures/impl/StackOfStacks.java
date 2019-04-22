/**
 * 
 */
package com.raj.datastructures.impl;

import java.util.ArrayList;

/**
 * @author rajeev.tippanaboyina
 *
 */
public class StackOfStacks {
	
	ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	int size=0;
	public StackOfStacks(int size){
		this.size = size;
	}
	public void push(Integer data) {
		Stack<Integer> lastStack = getLastStack(this.stacks);
		if(lastStack != null && lastStack.size < this.size) {
			lastStack.push(data);
		} else {
			Stack<Integer> stk = new Stack<Integer>();
			stk.push(data);
			this.stacks.add(stk);
		}
	}

	private Stack<Integer> getLastStack(ArrayList<Stack<Integer>> stacks) {
		if(stacks!= null && stacks.size()>0){
			return stacks.get(stacks.size()-1);
		}
		return null;
	}
	
	public Integer pop() {
		Stack<Integer> last = getLastStack(this.stacks);
		if(last == null) {
			return null;
		}
		int result = last.pop();
		if(last.size==0){
			this.stacks.remove(stacks.size()-1);
		}
		return result;
	}
	
	

}
