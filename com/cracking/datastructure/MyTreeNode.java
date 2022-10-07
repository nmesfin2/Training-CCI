package com.cracking.datastructure;

public class MyTreeNode {
	private int root;
	private MyTreeNode [] children;
	private MyTreeNode parent;
	private int numOfChildren;
	private int childIndexTracker;
	
	MyTreeNode(int val, int numOfChildren){
		this.root = val;
		this.numOfChildren = numOfChildren;
		this.children = new MyTreeNode[numOfChildren];
		this.childIndexTracker = 0;
	}
	
	
	public boolean addChild(int val) {
		if(childIndexTracker > this.children.length - 1) {
			return false;
		}
		MyTreeNode childNode = new MyTreeNode(val, numOfChildren);
		childNode.parent = this;
		this.children[childIndexTracker] = childNode;
		this.childIndexTracker++;
		return true;
	}

	public int getRoot() {
		return this.root;
	}
	
	public boolean isRoot() {
		return this.parent == null;
	}
	
	
	public boolean isLeaf() {
		return this.childIndexTracker == 0;
	}
	
	public int getLevel() {
		if(this.isRoot()) {
			return 0;
		}else {
			return this.parent.getLevel() + 1;
		}
	}
	
	
	
	public MyTreeNode[] getChildren() {
		return children;
	}


	public void setChildren(MyTreeNode[] children) {
		this.children = children;
	}


	public static void main (String [] args) {
		MyTreeNode m1 = new MyTreeNode(11, 3);
		m1.addChild(3);
		m1.addChild(2);
		m1.addChild(8);
		m1.addChild(10);
		
		System.out.println(m1.getRoot());
		System.out.println(m1.getLevel());
		System.out.println(m1.getChildren()[1].root);
	}
}
