package com.cci.interviewquestions;

import java.util.HashSet;
import java.util.Set;



public class LInkeListQuestions {
	private   LinkedList linkedList;
	
	
	public static void main (String [] args) {
		LInkeListQuestions llq = new LInkeListQuestions();
		llq.linkedList.add('a');
		llq.linkedList.add('b');
		llq.linkedList.add('c');
		llq.linkedList.add('a');
		llq.linkedList.add('c');
		llq.removeDubs(llq.linkedList);
		
		Node curr = llq.linkedList.head;
		while(curr!= null) {
			System.out.println(curr.value);
			curr = curr.next;
		}
		
	}
	
	LInkeListQuestions(){
		this.linkedList = new LinkedList();
	}
	
	
	public boolean removeDubs(LinkedList ll) {
		
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
	
	class Node{
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
	
	 class LinkedList {
		Node head;
		
		LinkedList(){
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
		
	}
	
	
}
