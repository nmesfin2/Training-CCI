package com.cci.interviewquestions;

import java.util.HashSet;
import java.util.Set;



public class LInkeListQuestions {

	Node head;
	
	LInkeListQuestions(){
		//Node n = new Node();
		this.head = null;
	}
	
	void add(int val) {
		if(this.head == null) {
			Node n = new Node(val);
			this.head = n;
		}else {
			Node runner = this.head;
			while(runner.next != null) {
				runner = runner.next;
			}
			
			Node n = new Node(val);
			runner.next= n;
			
		}
	}
	
	 boolean remove(int v) {
		if(this.head == null) {
			return false;
		}else if(this.head.next == null){
			this.head = null;
			return true;
		}else {
			Node curr = this.head;
			while(curr.next != null) {
				if(curr.next.value == v) {

					if(curr.next.next != null) {
						Node temp = curr.next;
						curr.next = curr.next.next;
						temp = null;
					}
				}
				curr = curr.next;
			}
			return true;
		}
	}
	
	
	
	public static void main (String [] args) {
		LInkeListQuestions llq = new LInkeListQuestions();
		llq.add(55);
		llq.add(23);
		llq.add(32);
		llq.add(4);
		llq.add(2);
		llq.add(3);
		//llq.removeDubs(llq.linkedList);
		
		//return kth
		//System.out.println(llq.returnKthToLast(llq.linkedList, 5));
		
		// remove middle node
		//llq.deleteMiddleNode(llq, 4);
		
		// partition 
		Node h = llq.partitionOnPivot(llq.head, 32);
		
		Node curr = h;
		while(curr!= null) {
			System.out.println(curr.value);
			curr = curr.next;
		}
		
	}
	
	//partition my approach
	public Node partitionOnPivot(Node head, int c) {
		Node prev = head;
		Node curr = head;
		
		
		while(curr.next != null) {
			if(curr.next.value >= c) {
				prev = curr;
				curr = curr.next;
				while(curr.next != null) {
					if(curr.next.value < c) {
						Node t = prev.next;
						Node l = curr.next.next;
						prev.next = curr.next;
						prev.next.next = t;
						curr.next = l;
						curr = prev;
						break;
						
					}else {
						curr = curr.next;
					}
				}
				if(curr.next == null) {
					break;
				}else {
					curr = curr.next;
				}
				
			}else {
				Node t = prev.next;
				prev.next = curr.next;
				curr.next = t;
				prev = curr;
				curr = curr.next;
				
			}
		}
		
		if(head.value >= c) {
			Node t = head;
			head = head.next;
			t.next = null;
			curr.next = t;
		}
		
		return head;
		
	}
	//delete middle node
	public void deleteMiddleNode(LInkeListQuestions ll, int c) {
		
		if(ll.head.value == c) {
			if(ll.head.next != null) {
				ll.head = ll.head.next;
			}else {
				ll.head = null;
			}
		}else {
			Node curr = ll.head;
			Node prev = ll.head;
			while(curr != null) {
				if(curr.value != c) {
					prev = curr;
					curr =curr.next;
				}else {
					prev.next = curr.next;
					curr = prev;
				}
			}
		}
		
		
	}
	
	// return kth to last element
	public int returnKthToLast(LInkeListQuestions ll, int k) {
		int size = 0;
		Node curr = ll.head;
		while(curr != null) {
			size++;
			curr = curr.next;
		}
		
		int counter = 0;
		curr = ll.head;
		while((size - counter) != k) {
			curr = curr.next;
			counter++;
		}
		
		
		return curr.value;
	}
	public boolean removeDubs(LInkeListQuestions ll) {
		
		Set<Integer> s = new HashSet<Integer>();
		if(ll.head == null) {
			return false;
		}else {
			Node curr = ll.head;
			s.add(curr.value);
			while(curr.next != null) {
				if(s.contains(curr.next.value)) {
					curr.next = curr.next.next;
					//curr = curr.next;
				}else {
					s.add(curr.next.value);
					curr = curr.next;
				}
				
			}
			return true;
		}
	}
	
	public class Node{
		int value;
		Node next;
		Node () {
			next = null;
			value = Integer.MAX_VALUE;
		}
		
		Node(int value){
			this.value = value;
			next = null;
		}
	}
}
