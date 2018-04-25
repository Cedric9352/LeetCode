package org.leetcode.medium;

public class CountSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        byte[][] dp = new byte[n][n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if(i < n-1 && s.charAt(i) == s.charAt(i+1))
                dp[i][i+1] = 1;
        }
        for(int size = 2; size < n; size++) {
            for(int i = 0; i < n-size; i++) {
                if(s.charAt(i) == s.charAt(i+size) &&
                  dp[i+1][i+size-1] == 1)
                    dp[i][i+size] = 1;
            }
        }
        for(int i = 0; i < n; i++) 
            for(int j = i; j < n; j++)
                count += dp[i][j];
        return count;
    }
    public static void main(String[] args) {
    	System.out.println(new CountSubstrings().countSubstrings("aaa"));
    }
}
