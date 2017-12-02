package org.leetcode.medium;

import org.leetcode.util.TreeNode;

public class LongestUnivaluePath {
	int max;
	public int longestUnivaluePath(TreeNode root)
	{
		max = 0;
		core(root);
		return max;
	}
	public int core(TreeNode root)
	{
		if(root == null)
			return 0;
		int left = core(root.left);
		int right = core(root.right);
		int left_equal = 0, right_equal = 0;
		if(root.left != null && root.left.val == root.val)
			left_equal = left + 1;
		if(root.right != null && root.right.val == root.val)
			right_equal = right + 1;
		max = Math.max(max, left_equal + right_equal);
		return Math.max(left_equal, right_equal);
	}
}
