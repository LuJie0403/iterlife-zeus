package com.iterlife.zeus.algo.offer;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 14:45
 **/
public class Offer_07 {
}


class Offer_07_Solution {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;
        if (size == 0) {
            return null;
        }
        int rootVal = preorder[0], rootPosition = 0;
        //把中序遍历结果分成两部分
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == rootVal) {
                rootPosition = i;
                break;
            }
        }
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootPosition), Arrays.copyOfRange(inorder, 0, rootPosition));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootPosition, size), Arrays.copyOfRange(inorder, rootPosition + 1, size));
        return treeNode;
    }
}