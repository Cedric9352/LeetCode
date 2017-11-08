package org.leetcode.medium;

import java.util.LinkedList;
import org.leetcode.util.TreeNode;

public class PreorderTraversal {
	public void preorderTravelsal(TreeNode root)
	{
		TreeNode pNode = root;
		LinkedList<TreeNode> stack = new LinkedList<>();
		System.out.println("The preorder traversal of tree is: ");
		while(pNode != null || !stack.isEmpty())
		{
			while(pNode != null)
			{
				if(stack.isEmpty() && pNode.left == null && pNode.right == null)
					System.out.print(pNode.val + "\n");
				else
					System.out.print(pNode.val + " ");
				stack.push(pNode);
				pNode = pNode.left;
			}
			pNode = stack.poll();
			pNode = pNode.right;
		}
	}
}
