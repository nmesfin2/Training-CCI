package com.cci.interviewquestions;

import java.util.HashMap;

public class StringInterviews {
	
	public static void main(String [] args) {
		System.out.println(checkPermutation("acbaaa", "baacaa"));
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

}
