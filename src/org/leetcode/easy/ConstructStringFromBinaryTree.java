package org.leetcode.easy;

public class ConstructStringFromBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public String tree2str(TreeNode t) {
        if(t == null)
        	return "";
        StringBuilder sb = new StringBuilder(String.valueOf(t.val));
        if(t.left == null && t.right != null) {
        	String s = tree2str(t.right);
        	sb.append("()").append("(").append(s).append(")");
        } else if(t.left != null && t.right == null) {
        	String s = tree2str(t.left);
        	sb.append("(").append(s).append(")");
        } else if(t.left != null && t.right != null) {
        	String left = tree2str(t.left), right = tree2str(t.right);
        	sb.append("(").append(left).append(")");
        	sb.append("(").append(right).append(")");
        } else;
        return sb.toString();
    }
}
