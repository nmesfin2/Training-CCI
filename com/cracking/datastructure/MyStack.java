package com.cracking.datastructure;

import java.util.ArrayList;

public class MyStack<T extends Comparable<T>> implements Comparable<T> {
	
	private ArrayList<T>  stackArray; 
	private int size;
	private int topIndex;
	private T min;
	MyStack(int arrayLength){
		this.size = arrayLength;
		this.stackArray =   new ArrayList<T>(arrayLength);
		this.topIndex = -1;
		this.min = null;
	}
	
	MyStack(){
		this.size = 0;
		this.stackArray = new ArrayList<T>(10);
		this.topIndex = -1;
		this.min = null;
	}
	
	public boolean push(T val) {
		//System.out.println(stackArray.size());
		if(topIndex == size - 1) {
			return false;
		}else {
			this.topIndex++;
			this.stackArray.add(val);
			if(this.min == null) {
				this.min = val;
			}
			else if(val.compareTo(this.min) < 0){
				min = val;
			}
			return true;
			
		}	
	}
	
	public boolean pop() {
		if(topIndex == -1) {
			return false;
		}else {

			this.stackArray.set(topIndex, null);
			this.topIndex--;
			return true;
		}
	}
	public T peek() {
		return this.stackArray.get(topIndex);
	}
	
	public boolean isEmpty() {
		return this.topIndex == -1;
	}
	
	
	public T Min() {
		return this.min;
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
		
		System.out.println(myStack.Min());
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		if(this.min.compareTo(o) == 1){
			return 1;
		}
		return 0;
	}
}
