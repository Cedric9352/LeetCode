package org.leetcode.medium;

public class Search {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int lo = 0, hi = nums.length-1;
        int mid = 0;
        int index = -1;
        while(nums[lo] >= nums[hi]) {
            if(lo + 1 == hi) {
                index = hi;
                break;
            }
            mid = lo + (hi - lo) / 2;
            if(nums[lo] == nums[mid] && nums[hi] == nums[hi]) {
                int min = Integer.MAX_VALUE;
                for(int i = lo; i <= hi; i++){
                    if(min > nums[i]) {
                        min = nums[i];
                        index = i;
                    }
                }
                break;
            }
            if(nums[lo] <= nums[mid])
                lo = mid;
            else
                hi = mid;
        }
        if(index != -1) {
            int left = binarySearch(nums, 0, index-1, target);
            int right = binarySearch(nums, index, nums.length-1, target);
            return  left == -1 ? (right == -1 ? -1 : right) : left;
        } else 
        	return binarySearch(nums, 0, nums.length, target);
    }
    private int binarySearch(int[] a, int start, int end, int target) {
        int mid = 0;
        while(start <= end) {
        	mid = start + (end - start) / 2;
            if(a[mid] == target)
                return mid;
            else if(a[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
    	Search s = new Search();
    	System.out.println(s.search(new int[]{1,3}, 0));
    }
}
