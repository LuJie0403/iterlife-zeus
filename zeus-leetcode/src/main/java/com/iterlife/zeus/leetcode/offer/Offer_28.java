package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 19:27
 **/
public class Offer_28 {
}

class Solution {

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            if (root.left.val == root.right.val) {
                return isSymmetric(root.left) && isSymmetric(root.right);
            }
            return false;
        }
        return false;
    }
}