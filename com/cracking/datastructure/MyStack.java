package com.cracking.datastructure;

public class MyStack<T> {
	
	private T [] stackArray; 
	private int size;
	private int topIndex;
	
	MyStack(int arrayLength){
		this.size = arrayLength;
		this.stackArray = (T[]) new Object[arrayLength];
		this.topIndex = -1;
	}
	
	MyStack(){
		this.size = 0;
		this.stackArray = (T[]) new Object[10];
		this.topIndex = -1;
	}
	
	public boolean push(T val) {
		if(topIndex == stackArray.length - 1) {
			return false;
		}else {
			this.topIndex++;
			this.stackArray[topIndex] = val;
			
			return true;
			
		}	
	}
	
	public boolean pop() {
		if(topIndex == -1) {
			return false;
		}else {

			this.stackArray[topIndex] = null;
			this.topIndex--;
			return true;
		}
	}
	public T peek() {
		return this.stackArray[this.topIndex];
	}
	
	public boolean isEmpty() {
		return this.topIndex == -1;
	}
	
	
	public static void main(String [] args) {
		MyStack<Integer> myStack = new MyStack<Integer>(10);
		myStack.push(10);
		myStack.push(11);
		myStack.push(12);
		myStack.push(13);
		myStack.push(14);
		myStack.push(15);
		
		while(!myStack.isEmpty()) {
			System.out.println(myStack.peek());
			myStack.pop();
		}
	}
}
