package com.iterlife.zeus.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 23:00
 **/
public class Offer_34 {
}


class Offer_34_Solution {
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

    List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return ansList;
        }
        dfs(root, target, new ArrayList<>());
        return ansList;
    }

    public void dfs(TreeNode root, int target, List<Integer> resList) {
        if (root == null) {
            return;
        }
        target -= root.val;
        resList.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            ansList.add(new ArrayList<>(resList));
        }
        dfs(root.left, target, resList);
        dfs(root.right, target, resList);
        resList.remove(resList.size() - 1);
    }
}