package com.iterlife.zeus.algo.offer;

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

    public void dfs(TreeNode root, int target, List<Integer> tempList) {
        if (root == null) {
            return;
        }
        target -= root.val;
        tempList.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            //tempList 是存储遍历过的临时路径，所以当满足条件的时候要把临时复制一份作为最终结果输出
            ansList.add(new ArrayList<>(tempList));
        }
        dfs(root.left, target, tempList);
        dfs(root.right, target, tempList);
        // 检索到此处说明没有满足条件的路径，则后一步继续检索另一个子树（先进后出）
        tempList.remove(tempList.size() - 1);
    }
}