package com.iterlife.zeus.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 21:59
 **/
public class Offer_54 {
}

/**
 * Definition for a binary tree node.
 */
class Offer_54_Solution {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public int kthLargest(TreeNode root, int k) {
        List<TreeNode> ansList = new ArrayList<>();
        inorderTraverse(root, ansList);
        return ansList.get(ansList.size() - k).val;
    }

    /**
     * 中序遍历
     */
    public void inorderTraverse(TreeNode root, List<TreeNode> ansList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTraverse(root.left, ansList);
        }
        ansList.add(root);
        if (root.right != null) {
            inorderTraverse(root.right, ansList);
        }
        ansList.stream().forEach(treeNodeItem -> System.out.println(treeNodeItem.val));
    }
}