package org.leetcode.easy;

import java.util.*;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> right = new HashMap<>(), 
        		left = new HashMap<>(), count = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	if(left.get(nums[i]) == null) left.put(nums[i], i);
        	right.put(nums[i], i);
        	count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        int ans = nums.length;
        int degree = Collections.max(count.values());
        for(int x : count.keySet()) {
        	if(count.get(x) == degree) {
        		ans = Math.min(ans, right.get(x) - left.get(x) + 1);
        	}
        }
        return ans;
    }
}
