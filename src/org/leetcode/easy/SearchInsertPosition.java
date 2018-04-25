package org.leetcode.easy;

public class SearchInsertPosition {
	public int searchInsertPosition(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid = 0;
        while(start <= end) {
        	mid = start + (end - start) / 2;
        	if(nums[mid] == target)
        		return mid;
        	else if(nums[mid] < target)
        		start = mid + 1;
        	else
        		end = mid - 1;
        }
        if(end < 0)
        	return 0;
        else if(start >= nums.length)
        	return nums.length;
        else
        	return (start + end)/2 + 1;
	}
	public static void main(String[] args) {
		int[] nums = { 1,3,5,6 };
		System.out.println(new SearchInsertPosition().searchInsertPosition(nums, 0));
	}
}
