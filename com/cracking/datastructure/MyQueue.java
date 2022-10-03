package com.cracking.datastructure;

public class MyQueue<T> {
	private int size;
	private T [] queueArray;
	private int firstIndex;
	private int lastIndex;
	
	
	public MyQueue() {
		this.queueArray = (T[])new Object[10];
		this.firstIndex = -1;
		this.lastIndex = -1;
		this.size= 0;
	}
	
	public MyQueue(int myArray) {
		this.queueArray = (T[]) new Object[myArray];
		this.firstIndex = -1;
		this.lastIndex = -1;
		this.size = 0;
	}
	
	public boolean enqueue(T data) {
		if(isFull()) {
			return false;
		} 
		if(this.firstIndex == -1) {
			this.firstIndex++;
		}
		this.lastIndex++;
		this.queueArray[this.lastIndex] = data;
		this.size++;
		return true;
		
	}
	
	public boolean deque() {
		if(isEmpty()) {
			return false;
		}
		this.queueArray[this.firstIndex] = null;
		this.firstIndex++;
		this.size--;
		return true;
	}
	
	public T peak() {
		return this.queueArray[this.firstIndex];
	}
	
	public boolean isFull() {
		if(this.size == this.queueArray.length - 1) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(){
		if(this.size <= 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String [] args) {
		MyQueue<String> myQueue = new MyQueue<String>(7);
		myQueue.enqueue("Hello");
		myQueue.enqueue("my");
		myQueue.enqueue("name");
		myQueue.enqueue("is");
		myQueue.enqueue("suzi");
		
		while(!myQueue.isEmpty()) {
			System.out.println(myQueue.peak());
			myQueue.deque();
		}
		
		
	}
	
}
