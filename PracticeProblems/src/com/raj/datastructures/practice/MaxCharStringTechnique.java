package com.raj.datastructures.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MaxCharStringTechnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MaxCharStringTechnique.maxChar("Hello hhhhhWorld!"));
	}
	
	/*
	 * Find the max char in the input string means char that is coming multiple times
	 * Other variations uses same technique
	 * 1. what is most common character in the String
	 * 2. Does string A have same characters as string B(Anagram)
	 * 3. Does the given string have any repeated characters in it
	 * 
	 * Technique
	 * 1. Add the characters to a hash Map with char as Key 
	 * and number of occurrences as value.
	 * 2. Use this to get the repeated characters.
	 * 
	 */
	
	public static char maxChar(String st) {
		if(st == null || st == "") {
			return ' ';
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i< st.length(); i++) {
			char current = st.charAt(i);
			if(map.containsKey(current)) {
				map.put(current, map.get(current)+1);
			} else {
				map.put(current,1);
			}
		}//HashMap created
		//loop through hashMap and find the max count
		Set<Character> keySet = map.keySet();
		Iterator<Character> it = keySet.iterator();
		Character max = new Character(' ');
		int maxVal=0;
		while(it.hasNext()) {
			Character key = (Character)it.next();
			int tempVal = map.get(key);
			if(tempVal>maxVal) {
				max=key;
				maxVal=tempVal;
			}
		}
		return max.charValue();
	}
	
	//Anagram -- both strings have same characters
	/*1. We can loop a and check all the characters in a are in B 
	 * 	  and then loop from B and check all the chars in the B
	 *   this will take O(a.length) + O(b.length) and checks twice
	 * 2. We can add all the characters from a to hash map
	 * 	 and check if both maps have same keys and same numbers
	 * 	 this also takes O(a.length) + O(b.length) but also takes Space O(m+n)
	 * 	 m,n are number of characters in the two strings
	 * 3. Possibly the best way Sort both arrays and if they are equal.
	 *   Keep in mind that we need to remove any spaces or special characters here
	 *   Sorting usually is nLog(n) -- merge Sort and constant time for comparing.
	 * 
	 */
	public static boolean isAnagram(String a, String b) {
		
		if((a == null && b== null) || (a=="" && b=="")) {
			return true;
		}
		//Remove special Characters
		b= b.trim();
		a=a.trim();
		b= b.replaceAll("[^\\w\\s]","").toLowerCase();
		a= a.replaceAll("[^\\w\\s]","").toLowerCase();
		if(sort(a).equals(sort(b)) ) {
			return true;
		}
		return false;
	}
	
	private static String sort(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
		
	}

}
