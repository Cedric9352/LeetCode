package org.leetcode.medium;

import org.leetcode.util.TreeNode;

public class FindSecondMinimumValue {
    private int min = Integer.MAX_VALUE;
    private int secMin = Integer.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
        core(root);
        //the judgment must cover all conditions
        if(min == secMin || (root.left == null && root.right == null)
            || secMin == Integer.MAX_VALUE)
            return -1;
        else
            return secMin;
    }
    public void core(TreeNode root) {
        if(root == null)
            return;
        core(root.left);
        core(root.right);
        if(root.val < min) {
            secMin = min;
            min = root.val;
        }
        else {
            if((root.val != min && root.val < secMin))
                secMin = root.val;
        }
    }
}
