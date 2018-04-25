package org.leetcode.easy;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
    	int sum = 0, subSum = 0;
    	for(int i = 0; i < nums.length; i++)
    		sum += nums[i];
    	for(int i = 0; i < nums.length; i++) {
    		if(subSum + nums[i] == sum - subSum)
    			return i;
    		subSum += nums[i];
    	}
    	return -1;
    }
}
