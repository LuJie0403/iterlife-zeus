package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 19:27
 **/
public class Offer_28 {
}

class Offer_28_Solution {

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
        TreeNode mirrorTree = mirrorTreeNode(root);

        return isEqualTree(root, mirrorTree);
    }

    public TreeNode mirrorTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode mirrorTree = new TreeNode(treeNode.val);
        TreeNode tTreeNode = treeNode.left;
        mirrorTree.left = mirrorTreeNode(treeNode.right);
        mirrorTree.right = mirrorTreeNode(tTreeNode);
        return mirrorTree;
    }


    public boolean isEqualTree(TreeNode aTree, TreeNode bTree) {
        if (aTree == null || bTree == null) {
            return bTree == null;
        }
        if (aTree.val == bTree.val && isEqualTree(aTree.left, bTree.left) && isEqualTree(aTree.right, bTree.right)) {
            return true;
        }
        return false;
    }


}