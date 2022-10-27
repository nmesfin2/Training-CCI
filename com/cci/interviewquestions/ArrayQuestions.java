package com.cci.interviewquestions;

import java.util.HashMap;
import java.util.Map;

public class ArrayQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] fruits = {1, 2, 1};
		System.out.println(totalFruit(fruits));

	}

	
	// total fruits
	public static int totalFruit(int[] fruits) {
        return totalFruitHelper(fruits);
    }
    
    // total fruit helper
    private static int totalFruitHelper(int [] fruits){
        int highest = 0;
        int secondHighest = 0;
        Map<Integer, Integer> fruitMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < fruits.length; i++){
            if(fruitMap.get(fruits[i]) == null){
                fruitMap.put(fruits[i], 1);
                if(1 > highest ){
                  highest = 1;
              } else if(1 > secondHighest){
                  secondHighest = 1;
              }
            }else{
              int incrementedVal = fruitMap.get(fruits[i]) + 1;
              fruitMap.put(fruits[i], incrementedVal);
              if(incrementedVal >= highest ){
                  highest = incrementedVal;
              } else if(incrementedVal >= secondHighest){
                  secondHighest = incrementedVal;
              }
            }
        }
        
        return highest + secondHighest;
    }
}
