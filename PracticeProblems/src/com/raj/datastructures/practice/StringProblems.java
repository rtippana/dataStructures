package com.raj.datastructures.practice;

public class StringProblems {

	public static void main(String[] args) {
		
		System.out.println(StringProblems.reverse("abb 'cde"));
		System.out.println(StringProblems.reverseInt(346678));
		System.out.println(StringProblems.isPallindrome("122321"));
		System.out.println("Is Unique == " +StringProblems.isUnique("abczz"));
		System.out.println("Replace --> " + new String(StringProblems.replaceSpace("Mr John Smith     ".toCharArray(), 13)));
	}
	
	
	//Time complexity O(n) Space O(n) as we are creating a buffer.
	public static String reverse(String st) {
		
		if(st == null || st =="") {
			return st;
		}
		StringBuffer br = new StringBuffer();
		for(int i=st.length()-1; i>=0; i--) {
			br.append(st.charAt(i));
		}
		return br.toString();
	}
	
	//Time complexity can say O(m) where m is number of digits. Space is O(1) no extra space
	public static int reverseInt(int n) {
		if(n <10) {
			return n;
		}
		//to reverse get the last digit first
		//then remove the last digit
		//Then next time *10 and add it to the previous one
		int result=0;
		while(n>0) {
			int last = n%10;
			n = n/10;
			result = result*10 + last;
		}
		return result;
		
	}
	//Time O(N/2) ~ O(n) Space O(1)
	public static boolean isPallindrome(String st) {
		
		if(st==null || st=="") {
			return true;
		}
		int first =0;
		int last = st.length()-1;
		while(first <last) {
			if(st.charAt(first) != st.charAt(last)) {
				return false;
			}
			first++;
			last--;
		}
		return true;
	}
	
	/*
	 * Is String has unique characters
	 */
	public static boolean isUnique(String st) {
		if(st == null || st=="") {
			return true;
		}
		for(int i=0; i< st.length()-1; i++) {
			if(st.substring(i+1).indexOf(st.substring(i,i+1)) !=-1) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Replace space with %20 given string and its true length
	 * Do in place as the characterArray has more characters
	 */
	public static char[] replaceSpace(char[] array, int trueLength) {
		System.out.println(array.length);
		int newIndex = trueLength-1 + charCount(array, trueLength, ' ')*2;
		System.out.println(newIndex);
		for(int i=trueLength-1; i>=0; i--) {
			if(array[i]==' ') {
				array[newIndex--] = '0';
				array[newIndex--] ='2';
				array[newIndex--] = '%';
			} else {
				array[newIndex--] = array[i];
			}
		}
		return array;
	}
	
	private static int charCount(char[] array, int n, char target) {
		int count=0;
		for(int i=0; i< n; i++) {
			if(array[i]==' ') {
				count++;
			}
		}
		return count;
	}
}
