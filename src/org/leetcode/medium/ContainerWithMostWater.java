package org.leetcode.medium;

public class ContainerWithMostWater {
	public int containerWithMostWater(int[] height) {
		int left = 0, right = height.length-1;
		int water = 0;
		while(left < right) {
			int h = Math.min(height[left], height[right]);
			water = Math.max(water, h * (right-left));
			while(height[left] <= h && left < right) left++;
			while(height[right] <= h && left < right) right--;
		}
		return water;
	}
	public static void main(String[] args) {
		int[] height = { 1,8,6,2,5,4,8,3,7 };
		System.out.println(new ContainerWithMostWater().containerWithMostWater(height));
	}
}
