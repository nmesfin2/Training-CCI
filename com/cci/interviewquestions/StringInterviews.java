package com.cci.interviewquestions;

import java.util.HashMap;

public class StringInterviews {
	
	public static void main(String [] args) {
		System.out.println(checkPermutation("acbaaa", "baacaa"));
		System.out.println(urlify("Mr John Smith       ", 13));
//		System.out.println(palindromePermuation("Tact ddCoa"));
//		System.out.println(oneAway("pale", "bake"));
		
		
		String [][] matrix = { {"A", "B", "C", "D"}, {"X", "Y", "Z", "V"}, {"1", "2", "3", "4"}, {"5", "6", "7", "8"}};
		
		
		printMatrix(matrix);
		rotate90Matrix(matrix);
		System.out.println();
		printMatrix(matrix);
		System.out.println();
		
		roateMinus90Matrix(matrix);
		printMatrix(matrix);
		
	}
	
	
	public static void printMatrix(String[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
		}
		
	}
	public static boolean isUnique(String str) {
		//method one o(ij)
//		for(int i = 0; i < str.length(); i++) {
//			for(int j = i+1; j < str.length(); j++) {
//				if(str.charAt(i) == str.charAt(j)) {
//					return false;
//				}
//			}
//		}
		//return true;
		
		// method two o(n)
		int Max_Integer = 10000;
		int [] alphabet = new int[Max_Integer];
		
		for(int i = 0; i <str.length(); i++) {
			System.out.println(str.charAt(i));
			int index = str.charAt(i) - 'A';
			System.out.println(index);
			if(alphabet[index] > 0) {
				return false;
			}
			alphabet[index]++;
		}
		return true;
		
	}
	
	
	// check for permuation
	public static boolean checkPermutation(String str1, String str2) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		if(str1.length() != str2.length()) {
			return false;
		}
		
		for(int i = 0; i < str1.length(); i++) {
			if(hm.containsKey(str1.charAt(i))) {
				hm.put(str1.charAt(i), hm.get(str1.charAt(i)) + 1);
			}else {
				hm.put(str1.charAt(i), 1);
			}
		}
		
		for(int i = 0; i < str2.length(); i++) {
			if(!hm.containsKey(str2.charAt(i))) {
				return false;
			}
			
			if(hm.get(str2.charAt(i)) < 1){
				return false;
			}
			
			hm.put(str2.charAt(i), hm.get(str2.charAt(i))- 1);
		}
		return true;
	}
	
	public static char[] urlify(String s, int trueLength) {
		int urlLength = trueLength;
		
		char [] a = s.toCharArray();
		
		for(int i = 0; i < urlLength; i++) {
			if(a[i] == ' ') {
				for(int j = urlLength - 1; j > i; j--) {
					a[j+2] = a[j];
				}
				a[i]= '%';
				a[i+1]='2';
				a[i+2]='0';
				urlLength = urlLength + 2;
				i = i +2 ;
			}
		}
		return a;
	}
	
	
	public static boolean palindromePermuation(String str) {
		
		str = str.toLowerCase();
		
		char[] strArray = str.toCharArray();
		
		int [] array = new int[128];
		
		int moreThanOneOdd = 0;
		
		for(Character c : strArray) {
			if(c != ' ') {
				 array[c - 'a']++;
			}

		}
		
		for(int i = 0; i < array.length; i ++) {
			if(array[i]%2 != 0) {
				moreThanOneOdd++;
			}
			
		
		}
		
		if(moreThanOneOdd > 1) {
			return false;
		}
		
		return true;
	}
	
	
	// one away
	public static boolean  oneAway(String str1, String str2) {
		
		char [] str1Chars = str1.toCharArray();
		char [] str2Chars = str2.toCharArray();
		
		int [] array = new int [128];
		int moreThanTwo = 0;
		
		for(Character c: str1Chars) {
			array[c - 'a']++;
		}
		
		for(Character c: str2Chars) {
			array[c - 'a']--;
		}
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				moreThanTwo++;
			}
			System.out.println(i + " : " + array[i]  );
		}
		
		if(moreThanTwo > 2) {
			return false;
		}
		return true;
	}
	
	
	public static void rotate90Matrix(String [][] matrix) {
		
		
		int n = matrix.length;
		for(int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			for(int i = first; i < last; i++) {
				int offset = i - first;
				
				String top = matrix[first][i];
				
				//left to top
				matrix[first][i] = matrix[last - offset][first];
				
				//bottom to left
				matrix[last-offset][first]=matrix[last][last-offset];
				
				// right to bottom
				matrix[last][last-offset] = matrix[i][last];
				
				// top to right
				matrix[i][last] = top;
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void roateMinus90Matrix(String [][] matrix) {
		
		int n = matrix.length;
		
		for(int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			for(int i = first; i < last; i++) {
				int offset = i - first;
				
				String top = matrix[first][i];
				
				//right to top				
				matrix[first][i] = matrix[i][last];
				
				// bottom to right;				
				matrix[i][last] = matrix[last][last-offset];
				
				// left to bottom
				matrix[last][last-offset] = matrix[last-offset][first];
				
				// top to left
				matrix[last-offset][first] = top;
			}
			
		}
		
	}

}
