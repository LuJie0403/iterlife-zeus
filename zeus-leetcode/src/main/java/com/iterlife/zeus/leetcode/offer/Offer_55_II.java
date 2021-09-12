package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 14:14
 **/
public class Offer_55_II {
}


class Offer_55_II_Solution {
    /**
     * Definition for a binary tree node.
     */


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int diff = Math.abs(depth(root.left) - depth(root.right));
        if (diff > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
