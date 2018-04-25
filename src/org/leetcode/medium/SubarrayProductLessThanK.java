package org.leetcode.medium;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    	int left = 0;
    	int count = 0, product = 1;
    	for(int right = 0; right < nums.length; right++) {
    		product *= nums[right];
    		while(left <= right && product > k) product /= nums[left++];
    		//the window size represent the numbers of subarray which contains the right as its right boundary
    		count += right - left + 1;
    	}
    	return count;
    }
}
