package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 20:09
 **/
public class Offer_27 {
}

class Offer_27_Solution {
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

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tTreeNode = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tTreeNode);
        return root;
    }
}