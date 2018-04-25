package org.leetcode.medium;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
    	if(s == null)
    		return false;
        return core(s, 0, 0);
    }
    public boolean core(String s, int index, int count) {
    	if(count < 0 || (index == s.length() && count > 0))
    		return false;
    	if(index == s.length() && count == 0)
    		return true;
    	if(s.charAt(index) == '(')
    		return core(s, index+1, count+1);
    	else if(s.charAt(index) == ')')
    		return core(s, index+1, count-1);
    	else
    		return core(s, index+1, count) ||
    				core(s, index+1, count+1) ||
    				core(s, index+1, count-1);
    }
    public static void main(String[] args) {
    	String s = "**";
    	System.out.println(new ValidParenthesisString().checkValidString(s));
    }
}
