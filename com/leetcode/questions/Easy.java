package com.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy {
	public static void main (String [] args) {
		int nums[] = {4, 3, 10, 9, 8};
		System.out.println(minSubsequence(nums));
	}
	
	// min subsequence - Easy
	public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int j = nums.length - 1; j >= 0; j--){
            int firstsum = addArrayElement(j, nums.length, nums);
            int secondsum =addArrayElement(0, j, nums);
            
            if(firstsum > secondsum){
                addToList(j, nums, list);
                break;
            }
        }
        return list;
	}
	    
    private static int addArrayElement(int first, int last, int[] nums){
        int sum = 0;
        for(int i = first; i < last; i++){
            sum+= nums[i];
        }
        return sum;
    }
	    
    private static void addToList(int j, int [] nums, List<Integer> list){
        
        for(int i = nums.length - 1; i >= j; i--){
            list.add(nums[i]);
        }
    }

}
