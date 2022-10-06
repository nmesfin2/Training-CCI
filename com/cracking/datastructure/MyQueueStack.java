package com.cracking.datastructure;

import com.cracking.datastructure.MyStackLinkedList.StackNode;

public class MyQueueStack {
	private MyStackLinkedList stackOne;
	private MyStackLinkedList stackTwo;
	
	public MyQueueStack() {
		this.stackOne = new MyStackLinkedList();
		this.stackTwo = new MyStackLinkedList();
	}
	
	
	public boolean add(int val) {
		stackOne.push(val);
		return true;
	}
	
	
	public boolean remove() {
		if(this.stackOne.isEmpty()) {
			return false;
		}
		while(!stackOne.isEmpty()) {
			this.stackTwo.push(this.stackOne.peek());
			this.stackOne.pop();
		}
		
		this.stackTwo.pop();
		
		while(!this.stackTwo.isEmpty()) {
			this.stackOne.push(this.stackTwo.peek());
			this.stackTwo.pop();
		}
		return true;
	}
	
	public Object peek() {
		return this.stackOne.peek();
	}
	
	public boolean isEmpty() {
		return this.stackOne.isEmpty();
	}
	
	public static void main(String [] args) {
		MyQueueStack mqs = new MyQueueStack();
		mqs.add(1);
		mqs.add(2);
		mqs.add(3);
		mqs.add(4);
		mqs.add(5);
		mqs.add(6);
		mqs.add(7);
		
		while(!mqs.isEmpty()) {
			System.out.println(mqs.peek());
			mqs.remove();
		}
		
	}
	
	
}
