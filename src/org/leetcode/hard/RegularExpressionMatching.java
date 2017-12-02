package org.leetcode.hard;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	if(s == null || p == null)
    		return false;
        return core(s, p, 0, 0);
    }
    public boolean core(String s, String p, int index1, int index2) {
    	int len_s = s.length(), len_p = p.length();
    	//both s and p match over
    	if(index1 >= len_s && index2 >= len_p)
    		return true;
    	//s is over but p is not
    	if(index1 < len_s && index2 >= len_p)
    		return false;
    	if(index2 + 1 < len_p) {
    		if(p.charAt(index2 + 1) == '*') {
    			if(index1 < len_s && (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '.'))
    				return core(s, p, index1+1, index2+2) ||
    						core(s, p, index1, index2+2) ||
    						core(s, p, index1+1, index2);
    			//notice: this condition contains s is over, p ends with "x*"
    			else
    				return core(s, p, index1, index2+2);
    		}
    	}
    	if(index1 < len_s && (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '.'))
    		return core(s, p, index1+1, index2+1);
    	//notice: this condition contains s is over, p ends with "xx.."
    	else
    		return false;
    }
    public static void main(String[] args) {
    	RegularExpressionMatching r = new RegularExpressionMatching();
    	System.out.println(r.isMatch("a", "a.*"));
    }
}
