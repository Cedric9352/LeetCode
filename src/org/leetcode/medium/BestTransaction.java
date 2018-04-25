package org.leetcode.medium;

public class BestTransaction {
    public int maxProfit(int[] prices, int fee) {
    	if(prices.length == 0)
    		return 0;
    	int n = prices.length;
    	//hold[i] represents the max profit that you hold a stack when day i is over
    	//unhold[i] represents the max profit that you hold nothing when day i is over
    	int[] hold = new int[n];
    	int[] unhold = new int[n];
    	hold[0] = -prices[0];
    	unhold[0] = 0;
    	for(int i = 1; i < n; i++) {
    		hold[i] = Math.max(hold[i-1], unhold[i-1]-prices[i]);
    		unhold[i] = Math.max(unhold[i-1], hold[i-1]+prices[i]-fee);
    	}
    	return unhold[n-1];
    }
    public static void main(String[] args) {
    	int[] prices = { 1, 3, 2, 8, 4, 9 };
    	System.out.println(new BestTransaction().maxProfit(prices, 2));
    }
}
