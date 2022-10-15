package com.cracking.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;

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
	
	public  Node minimalTree(int [] sortedArray) {
		return minimalTreeHelper(sortedArray, 0, sortedArray.length - 1);
	}
	
	private Node minimalTreeHelper( int [] sortedArray, int firstIndex, int lastIndex) {
		if(lastIndex < firstIndex) {
			return null;
		}
		int middle = (firstIndex + lastIndex)/2;	
		Node n = new Node(sortedArray[middle]);
		n.left = minimalTreeHelper(sortedArray, firstIndex, middle - 1);
		n.right = minimalTreeHelper(sortedArray, middle + 1, lastIndex);	
		return n;
	}
	
	public void ListOfNodeLinkedList(Node root) {
		ArrayList<LinkedList<Node>> lists = new ArrayList<>();
		ListOfNodeLinkedList(root, lists, 0);
	}
	
	// go line by line and add it to the array of linkedlist nodes
	private void ListOfNodeLinkedList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
		if(root == null) {
			return;
		}
		
		LinkedList<Node> list = null;
		if(lists.size() == level) {
			list =  new LinkedList<>();
			lists.add(list);
		}else {
			list.get(level);
		}
		list.add(root);
		ListOfNodeLinkedList(root.left, lists, level + 1);
		ListOfNodeLinkedList(root.right, lists, level + 1);
	}
	
	// check balanced
	public boolean checkBalanced(Node n) {
	
		return checkBalancedHelper(n) != -99;
	}
	
	// check balanced Helper
	public int checkBalancedHelper(Node n) {
		if(n == null) {
			return -1;
		}
		
		int left = checkBalancedHelper(n.left);
		if(left == -99) {
			return -99;
		}
		int right = checkBalancedHelper(n.right);
		if(right == -99) {
			return -99;
		}
		
		if(Math.abs(left - right) > 1) {
			return -99;
		}else {
			return Math.max(left, right) + 1;
		}
		
	}
	
	// validate BST
	Integer lastVal = null;
	public boolean validateBST(Node n) {
		
		if(n == null ) {
			return true;
		}
		
		if(!validateBST(n.left)) {
			return false;
		}
		if(lastVal != null && lastVal >= n.num) {
			return false;
		}
		
		lastVal = n.num;
		
		if(!validateBST(n.right)) {
			return false;
		}
		return true;
				
		
		
	}
	public static void main (String [] args) {
		Tree t = new Tree(3);
		t.add(t.getRoot(), 2);
		t.add(t.getRoot(), 1);
		t.add(t.getRoot(), 3);
		t.add(t.getRoot(), 99);
		t.add(t.getRoot(), 0);
		t.add(t.getRoot(), 34);
		t.add(t.getRoot(), 8);
		
		System.out.println("in order ---- ");
		t.inOrder(t.getRoot());
		System.out.println();
		
		System.out.println();
		System.out.println("pre order ---- ");
		t.preOrder(t.getRoot());
		
		System.out.println();
		System.out.println();
		System.out.println("post order ---- ");
		t.postOrder(t.getRoot());
		
		
		System.out.println();
		System.out.println();
		
		
		int [] n = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Node n2 = t.minimalTree(n);
		
		System.out.print("minimum depth bst pre order ----  " );
		t.preOrder(n2);
		System.out.println();
		System.out.print("minimum depth bst in order ----  " );
		t.inOrder(n2);
		System.out.println();
		System.out.print("minimum depth bst post order ----  " );
		t.postOrder(n2);
		
		
		Tree t2 = new Tree(3);
		t2.add(t2.getRoot(), 1);
		t2.add(t2.getRoot(), 5);
		t2.add(t2.getRoot(), 6);
		t2.add(t2.getRoot(), 7);
		t2.add(t2.getRoot(), 8);
		t2.add(t2.getRoot(), 9);
		t2.add(t2.getRoot(), 10);
		System.out.println();
		System.out.print("check balanced ----  " );
		System.out.println(t2.checkBalanced(t2.getRoot()));
		System.out.println(t.checkBalanced(n2));
		
		System.out.print("validate BST ----  " );
		System.out.println(t2.validateBST(t2.getRoot()));
	}
}
