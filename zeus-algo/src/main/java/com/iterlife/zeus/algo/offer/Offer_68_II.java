package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 17:38
 **/
public class Offer_68_II {
}


class Offer_68_II_Solution {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode lRoot = lowestCommonAncestor(root.left, p, q);
        TreeNode rRoot = lowestCommonAncestor(root.right, p, q);
        // 一左一右
        if (lRoot != null && rRoot != null) {
            return root;
        }
        //在左子树
        if (lRoot != null) {
            return lRoot;
        }
        //在右子树
        if (rRoot != null) {
            return rRoot;
        }
        return null;
    }
}