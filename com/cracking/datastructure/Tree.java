package com.cracking.datastructure;

public class Tree {
	private class Node{
		private int num;
		private Node left;
		private Node right;
		
		Node(int val){
			this.num = val;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	
	public Tree() {
		root = null;
	}
	
	public Tree(int num) {
		root = new Node(num);
	}
	
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void add(int val) {
		root = this.add(root, val);
	}
	private Node add(Node root, int val) {
		Node n = new Node(val);
		if(root == null) {
			root = new Node(val);
		} else if(root.num >= val) {
			root.left = add(root.left, val);
		}else {
			root.right = add(root.right, val);
		}
		
		return root;
	}
	
	public void inOrder(Node n) {
		if(n != null) {
			inOrder(n.left);
			System.out.print(n.num + " ");
			inOrder(n.right);
		}
	}
	
	public void preOrder(Node n) {
		if(n != null) {
			System.out.print(n.num + " ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	
	public void postOrder(Node n) {
		if(n != null) {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.num + " ");
		}
	}
	public static void main (String [] args) {
		Tree t = new Tree(3);
		t.add(t.getRoot(), 2);
		t.add(t.getRoot(), 4);
		t.add(t.getRoot(), 3);
		t.add(t.getRoot(), 99);
		t.add(t.getRoot(), 0);
		t.add(t.getRoot(), 34);
		t.add(t.getRoot(), 8);
		
		System.out.println(" in order ---- ");
		t.inOrder(t.getRoot());
		
		System.out.println();
		System.out.println(" pre order ---- ");
		t.preOrder(t.getRoot());
		
		System.out.println();
		System.out.println(" post order ---- ");
		t.postOrder(t.getRoot());
	}
}
