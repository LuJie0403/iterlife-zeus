package com.iterlife.zeus.algo.offer;

/**
 * @desc: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/8 10:53
 **/
public class Offer_55_I {
}


class Offer_55_I_Solution {

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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}