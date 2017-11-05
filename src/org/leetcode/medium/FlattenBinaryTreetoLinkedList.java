package org.leetcode.medium;

public class FlattenBinaryTreetoLinkedList {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public void flattenBinaryTreetoLinkedList(TreeNode root) {
        if(root == null)
            return;
        TreeNode pHead = root;
        core(root, null);
        while(pHead != null)
        {
        	pHead.right = null;
            pHead = pHead.left;
        }
        mirror(root);
    }
    public TreeNode core(TreeNode root, TreeNode pNode)
    {
    	if(pNode != null)
    		pNode.left = root;
    	pNode = root;
        if(root.left != null)
        	pNode = core(root.left, pNode);
        if(root.right != null)
        	pNode = core(root.right, pNode);
        return pNode;
    }
    public void mirror(TreeNode root)
    {
        if(root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }
}

