package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 19:59
 **/
public class offer_26 {
}


class offer_26_Solution {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val && checkStructure(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean checkStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return B == null;
        }
        if (A.val != B.val) {
            return false;
        }
        return checkStructure(A.left, B.left) && checkStructure(A.right, B.right);
    }
}