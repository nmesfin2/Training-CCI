package com.cracking.datastructure;

public class MyStackLinkedList<T> {
	class StackNode<T>{
		StackNode<T> next;
		T data;
		
		StackNode(T data){
			this.data = data;
		}
	}
	
	private StackNode<T> top;
	
	MyStackLinkedList(){
		this.top = null;
	}
	
	public boolean pop() {
		if(top == null) {
			return false;
		}else {
			T item = top.data;
			top = top.next;
			return true;
		}
	}
	
	public boolean push(T item) {
		StackNode t = new StackNode(item);
		t.next = top;
		top = t;
		return true;

	}
	
	public T peek() {
		if(top != null ) {
			return top.data;
		}else {
			return null;
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public static void main(String [] args) {
		MyStackLinkedList<String> myStack = new MyStackLinkedList<String>();
		myStack.push(" oh");
		myStack.push(" my");
		myStack.push(" God");
		myStack.push(" Look");
		myStack.push(" at");
		myStack.push(" her");
		myStack.push("butt");
		
		while(!myStack.isEmpty()) {
			System.out.print(myStack.peek());
			myStack.pop();
		}
	}
}
