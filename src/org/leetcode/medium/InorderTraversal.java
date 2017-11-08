package org.leetcode.medium;

import java.util.LinkedList;
import org.leetcode.util.TreeNode;

public class InorderTraversal {
	public void inorderTravelsal(TreeNode root)
	{
		TreeNode pNode = root;
		LinkedList<TreeNode> stack = new LinkedList<>();
		System.out.println("The inorder traversal of tree is: ");
		while(pNode != null || !stack.isEmpty())
		{
			while(pNode != null)
			{
				stack.push(pNode);
				pNode = pNode.left;
			}
			pNode = stack.poll();
			if(stack.isEmpty() && pNode.right == null)
				System.out.print(pNode.val + "\n");
			else
				System.out.print(pNode.val + " ");
			pNode = pNode.right;
		}
	}
}
