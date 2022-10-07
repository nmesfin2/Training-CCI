package com.random.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BirthStones {
	
	
	public static void main(String [] args) {
		Map<String, String> monthBirthStoneMap = new HashMap<>(); //  (monthname -> nick name)
		Map<Integer, String> numberToMonthMap = new HashMap<>(); //(monthNumber -> month name)
		
		// insert the month and nick name in the first map, 
		// and the number and the month name in the second.
		monthBirthStoneMap.put("January", "Garnet");
		numberToMonthMap.put(1, "January");
		
		monthBirthStoneMap.put("February", "Amethyst");
		numberToMonthMap.put(2, "February");
		
		monthBirthStoneMap.put("March", "Aquamarine");
		numberToMonthMap.put(3, "March");
		
		monthBirthStoneMap.put("April", "Diamond");
		numberToMonthMap.put(4, "April");
		
		monthBirthStoneMap.put("May", "Emerald");
		numberToMonthMap.put(5, "May");
		
		monthBirthStoneMap.put("June", "pearl");
		numberToMonthMap.put(6, "June");
		
		monthBirthStoneMap.put("July", "Ruby");
		numberToMonthMap.put(7, "July");
		
		monthBirthStoneMap.put("August", "Peridot");
		numberToMonthMap.put(8, "August");
		
		monthBirthStoneMap.put("September", "Saphire");
		numberToMonthMap.put(9, "September");
		
		monthBirthStoneMap.put("October", "Opal");
		numberToMonthMap.put(10, "October");
		
		monthBirthStoneMap.put("November", "Topaz");
		numberToMonthMap.put(11, "November");
		
		monthBirthStoneMap.put("December", "Turquoise");
		numberToMonthMap.put(12, "December");
		
		
		//ask user for number
		Scanner scanner = new Scanner(System.in);
		System.out.print("What Month's birthstone do you want to know? ");
		
		int num = scanner.nextInt();
		
		if(num < 1 || num > 12) {
			System.out.print("I think you must be confused, " + num + " doesn't match a month.");
		}else {
			
			// get the month name from the second map
			String monthName = numberToMonthMap.get(num); 
			
			// using the month name from the second map, we get the birthStone from the first map
			String monthBirthStoneName = monthBirthStoneMap.get(monthName);
			
			
			System.out.println(monthName + "'s birthstone is "  +  monthBirthStoneName);
		}
		
		
	}

}
