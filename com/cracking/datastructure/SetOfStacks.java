package com.cracking.datastructure;

import java.util.ArrayList;

public class SetOfStacks {
	
	private StackNode []setOffStacks;
	private int indexTracker;
	private int capacityPerStack;
	private int capacityTracker;
	
	
	SetOfStacks(){
		this.setOffStacks = new StackNode[10];
		indexTracker = 0;
		this.capacityPerStack = 5;
		capacityTracker = 0;
	}
	
	SetOfStacks(int numOffStacks, int capacityPerStack){
		this.setOffStacks = new StackNode[numOffStacks];
		this.capacityPerStack = capacityPerStack;
		this.indexTracker = 0;
		capacityTracker = 0;
	}
	
	public boolean push(int val){
		if(this.indexTracker >= this.setOffStacks.length ) {
			return false;
		}
		StackNode s = new StackNode(val);
		if(this.capacityTracker < this.capacityPerStack) {
			this.capacityTracker++;
			s.next = this.setOffStacks[indexTracker];
			this.setOffStacks[indexTracker] = s;
		}else {
			this.indexTracker++;
			this.capacityTracker = 0;
			this.setOffStacks[indexTracker] = s;
		}
		return true;
	}
	
	public int pop() {
		int popped = -99;
		if(indexTracker < 0) {
			return -99;
		}
		if(this.capacityTracker == 0) {
			this.capacityTracker = this.capacityPerStack -  1; 

			popped = this.setOffStacks[indexTracker].num;
			indexTracker--;
			this.setOffStacks[indexTracker] = this.setOffStacks[indexTracker].next;			
		}else {
			popped = this.setOffStacks[indexTracker].num;
			this.setOffStacks[indexTracker] = this.setOffStacks[indexTracker].next;
			this.capacityTracker--;
		}
		return popped;
	}
	
	
	public static void main(String [] args) {
		SetOfStacks ss = new SetOfStacks();
		ss.push(10);
		ss.push(20);
		ss.push(30);
		ss.push(40);
		ss.push(50);
		ss.push(60);
		ss.push(70);
		ss.push(80);
		ss.push(90);
		ss.push(100);
		
		while(ss.indexTracker >= 0) {
			System.out.println(ss.pop());
		}
	}
	class StackNode{
		private int num;
		private StackNode next;
		private int size = 0;
		StackNode(int va){
			num = va; 
			this.size++;
		}
		
		public int getSize() {
			return this.size;
		}
		
		public void setSize(int val) {
			this.size = val;
		}
	}

}
