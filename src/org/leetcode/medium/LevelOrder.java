package org.leetcode.medium;

import java.util.*;

public class LevelOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        	return result;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> bucket = new ArrayList<>();
        int count = 1, toBePrinted = 1, cur = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
        	TreeNode pNode = queue.poll();
        	bucket.add(pNode.val);
        	count--;
        	cur++;
        	if(pNode.left != null) { queue.offer(pNode.left); count++; }
        	if(pNode.right != null) { queue.offer(pNode.right); count++; }
        	if(cur == toBePrinted) {
        		result.add(bucket);
        		toBePrinted = count;
        		cur = 0;
        		bucket = new ArrayList<>();
        	}
        }
        return result;
    }
}
