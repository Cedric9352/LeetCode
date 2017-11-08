package org.leetcode.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import org.leetcode.medium.InorderTraversal;
import org.leetcode.medium.PreorderTraversal;

public class BinaryTree {
	public TreeNode root;
	public BinaryTree(InputStream in) throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(in));
		ArrayDeque<TreeNode> queue = new ArrayDeque<>(); 
		String s = bufr.readLine();
		root = new TreeNode(Integer.parseInt(s));
		queue.offer(root);
		while(!"quit".equals(s = bufr.readLine()))
		{
			TreeNode pNode = queue.poll();
			String[] nums = s.split("\\s+");
			if(!"#".equals(nums[0]))
			{
				pNode.left = new TreeNode(Integer.parseInt(nums[0]));
				queue.offer(pNode.left);
			}
			if(!"#".equals(nums[1]))
			{
				pNode.right = new TreeNode(Integer.parseInt(nums[1]));
				queue.offer(pNode.right);
			}
		}
	}
	public static void main(String[] args) throws IOException
	{
		BinaryTree tree = new BinaryTree(System.in);
		InorderTraversal i = new InorderTraversal();
		PreorderTraversal p = new PreorderTraversal();
		i.inorderTravelsal(tree.root);
		p.preorderTravelsal(tree.root);
	}
}
