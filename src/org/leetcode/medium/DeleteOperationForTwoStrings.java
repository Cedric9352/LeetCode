package org.leetcode.medium;

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
    	int row = word1.length(), col = word2.length();
    	/*
    	 * dp[i][j] represents the minimum operation transforming
    	 * from substring 0~i-1 of word1
    	 * to substring 0~j-1 of word2
    	 */
        int[][] dp = new int[row + 1][col + 1];
        for(int i = 1; i <= col; i++) 
        	dp[0][i] = i;
        for(int i = 1; i <= row; i++)
        	dp[i][0] = i;
        for(int i = 1; i <= row; i++) {
        	for(int j = 1; j <= col; j++) {
        		dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
        		if(word1.charAt(i-1) == word2.charAt(j-1))
        			dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
        		else
        			dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 2);
        	}
        }
        return dp[row][col];
    }
}
