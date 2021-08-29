package com.iterlife.zeus.leetcode.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @desc:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/29 20:19
 **/
public class Offer_32_I {
}

/**
 * Definition for a binary tree node.
 */


class Offer_32_I_Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        List<Integer> result = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            root = queue.poll();
            result.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            array[i] = result.get(i);
        }
        return array;
    }
}
