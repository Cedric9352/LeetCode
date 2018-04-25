package org.leetcode.easy;

public class RomanToInteger {
	public int romanToInt(String s) {
		int[] tagVal = new int[256];
		int val = 0;
		tagVal['I'] = 1;
		tagVal['V'] = 5;
		tagVal['X'] = 10;
		tagVal['C'] = 100;
		tagVal['M'] = 1000;
		tagVal['L'] = 50;
		tagVal['D'] = 500;
		for(int i = 0; i < s.length(); i++) {
			if(i+1 >= s.length() || 
					tagVal[s.charAt(i)] >= tagVal[s.charAt(i+1)])
				val += tagVal[s.charAt(i)];
			else
				val -= tagVal[s.charAt(i)];
		}
		return val;
    } 
}
