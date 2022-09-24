package com.cracking.datastructure;

public class MyArrayList {
	private int [] array;
	private int size;
	private int  lastIndex;
	
	public MyArrayList(){
		this.size = 10;
		this.array = new int [this.size];
		this.lastIndex = 0;
	}
	
	public MyArrayList(int size){
		this.size = size;
		this.array = new int [this.size];
		this.lastIndex = 0;
	}
	
	
	
	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public void add(int val) {
		if(this.lastIndex < array.length) {
			this.array[this.lastIndex] = val;
			this.lastIndex++;
		}else {
			this.size = this.size * 2;
			int [] tempArray = new int[this.size];
			for(int i = 0; i < this.array.length; i++) {
				tempArray[i] = this.array[i];
				
			}
			
			this.array = tempArray;
			this.array[this.lastIndex] = val;
		}
		
	}
	
	public void delete() {
		this.array[this.lastIndex] = 0;
		this.lastIndex--;
	}
	
	public static void main(String [] args) {
		MyArrayList al = new MyArrayList(3);
		al.add(9);
		al.add(4);
		
		
		System.out.println(al.getLastIndex() + ": " + al.getSize());
		al.add(7);
		al.add(6);
		System.out.println(al.getLastIndex() + ": " + al.getSize());
		for(int i : al.getArray()) {
			System.out.println(i);
		}
		al.delete();
		for(int i : al.getArray()) {
			System.out.println(i);
		}
		
	}
}
