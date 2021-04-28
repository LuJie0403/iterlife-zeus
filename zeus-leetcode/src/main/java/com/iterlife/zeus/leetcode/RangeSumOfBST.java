package com.iterlife.zeus.leetcode;

/**
 * @desc:https://leetcode-cn.com/problems/range-sum-of-bst/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/28 08:35
 **/
public class RangeSumOfBST {
    public static void main(String[] args) {
    }
}

class RangeSumOfBSTSolution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root.left != null) {
            return sum += rangeSumBST(root.left, low, high);
        }
        if (root.right != null) {
            return sum + rangeSumBST(root.right, low, high);
        }
        return sum += (root.val >= low && root.val <= high ? root.val : 0);
    }
}


/**
 * Definition for a binary tree node.
 **/
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
