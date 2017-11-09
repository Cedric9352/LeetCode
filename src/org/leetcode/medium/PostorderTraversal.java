package org.leetcode.medium;

import java.util.LinkedList;
import org.leetcode.util.TreeNode;

public class PostorderTraversal {
	public void postorderTraversal(TreeNode root)
	{
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode pNode = root;
		TreeNode pLastVisit = null;
		System.out.println("The postorder traversal of tree is: ");
		while(pNode != null)
		{
			stack.push(pNode);
			pNode = pNode.left;
		}
		while(!stack.isEmpty())
		{
			pNode = stack.poll();
			if(pNode.right == null || pNode.right == pLastVisit)
			{
				if(pNode == root)
					System.out.println(pNode.val);
				else
					System.out.print(pNode.val + " ");
				pLastVisit = pNode;
			}
			else
			{
				stack.push(pNode);
				pNode = pNode.right;
				while(pNode != null)
				{
					stack.push(pNode);
					pNode = pNode.left;
				}
			}
		}
	}
}
