package com.guilin.others;

import java.util.EmptyStackException;

public class ImplementStackGuilinZhang {
	/*
	 * 
	 */
	Object[] val;
	
	int maxSize;	
	int top;
	
	public ImplementStackGuilinZhang(int maxSize){
		this.maxSize = maxSize;
		val = new Object[maxSize];
		top = -1;
	}
	
	/*
	 * Check whether stack is empty
	 */
	public boolean isEmpty() {
		return top == -1;
	}
	
	/*
	 * Check whether stack is full
	 */
	public boolean isMax() {
		return top == maxSize - 1;
	}
	
	/*
	 * Count the number of elements in stack
	 */
	public int countElements() {
		return top + 1;
	}
	
	/*
	 * Add an element to the top of a stack
	 */
	public boolean push(Object val) {
		if (isMax()) {
			return false;
		}
		
		this.val[++top] = val;
		return true;
	}
	
	/*
	 * Remove the top element from stack
	 */
	public Object pop() throws Exception {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		return this.val[top--];
	}
	
	/*
	 * Return the top element of stack
	 */
	public Object peek() {
		return this.val[countElements() - 1];
	}  

	
	public static void main(String[] args) throws Exception {
		ImplementStackGuilinZhang testStack = new ImplementStackGuilinZhang(10);
		//test isEmpty() method
		System.out.println("isEmpty()===> " + testStack.isEmpty());
		
		// push()
		testStack.push("red");
		testStack.push("green");
		testStack.push("blue");
		testStack.push("purple");
		testStack.push("tan");
		
		// isMax()
		if (testStack.isMax()){
			System.out.println("isMax()===> Wow, the stack is full!");
		} else {
			System.out.println("isMax()===> Come on, the stack still has space!");
		}
		
		// countElement()
		System.out.println("countElements()===> " + testStack.countElements());
		
		// peek()
		System.out.println("peek()===> " + testStack.peek()); // tan
		
		// pop()
		System.out.println("pop()===> " + testStack.pop()); // pop tan
		System.out.println("pop()===> " + testStack.pop()); // pop purple
		
		// peek()
		System.out.println("peek()===> " + testStack.peek()); // blue
	}
	

}
