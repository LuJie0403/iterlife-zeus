package com.iterlife.zeus.leetcode;

import javax.swing.tree.TreeNode;

/**
 * @desc:https://leetcode-cn.com/problems/invert-binary-tree/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/25 21:26
 **/
public class InvertBinaryTree {
}


class InvertBinaryTreeSolution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        return root;
    }

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}



