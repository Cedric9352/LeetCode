package org.leetcode.medium;

public class IsBalance {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public boolean isBalanced(TreeNode root) {
        if(root == null)
             return true;
        int[] depth = new int[1];
        return core(root, depth);
    }
    public boolean core(TreeNode root, int[] depth) {
        if(root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        boolean left_isBalanced = core(root.left, left);
        if(left_isBalanced) {
            int[] right = new int[1];
            boolean right_isBalanced = core(root.right, right);
            if(left_isBalanced && right_isBalanced) {
                if(left[0] - right[0] >= -1 && left[0] - right[0] <= 1) {
                    depth[0] = Math.max(left[0], right[0]) + 1;
                    return true;
                }
            }
        }
        return false;
    }
}
