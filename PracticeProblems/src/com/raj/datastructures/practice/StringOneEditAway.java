package com.raj.datastructures.practice;

public class StringOneEditAway {

	public static void main(String[] args) {
		
		StringOneEditAway sq = new StringOneEditAway();
		System.out.println(sq.oneEditAway("pale","pal"));
		System.out.println(sq.oneEditAway("pale","dal"));
		System.out.println(sq.oneEditAway("pale","palf"));
		System.out.println(sq.oneEditAway("pal","pald"));
		System.out.println(sq.oneEditAway("pa","pald"));

	}
	
	/* One Edit Away
	
	*	pale , pal -- insert
	*	bale, pale -- replace
	*	ale, pale -- insert
	*	pae , pale -- insert
	*	pad, pale -- insert
	*/
	public boolean oneEditAway(String s1, String s2){
		if(s1.length() == s2.length()){
			return oneEditReplace(s1, s2);	
		} else if(s1.length() +1 == s2.length()) {
			return oneEditInsert(s1, s2); //insert one char in s1 to get S2
		} else if(s1.length() == s2.length() +1) {
		   return oneEditInsert(s2, s1); // insert one char in S2 to get S1
		}
		return false;

	}
	//s1, s2 are same length, so one edit replace means only one character should be different
	//If we find any other char that is different then its false
	private boolean oneEditReplace(String s1, String s2) {
		boolean diffFound = false;
		for(int i=0; i< s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(diffFound) {
				 return false;
				}
				diffFound = true;
			}
		}
		return diffFound;
	}

	//To insert one character into S1 to make it S2.
	//It means all characters in s1 to be in s2 in that order
	private boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while(index1 < s1.length() && index2 < s2.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if(index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;

	}

}
