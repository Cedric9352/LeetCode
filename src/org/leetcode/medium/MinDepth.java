package org.leetcode.medium;

public class MinDepth {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private int min = Integer.MAX_VALUE;
    private int cur = 0;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        core(root);
        return min;
    }
    public void core(TreeNode root) {                
        cur += 1;
        if(root.left == null && root.right == null) {
            if(cur < min) min = cur;
            cur -= 1;
            return;
        } 
        if(root.left != null) core(root.left);
        if(root.right != null) core(root.right);
        cur -= 1;
    }
}
