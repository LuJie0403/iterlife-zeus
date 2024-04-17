package com.iterlife.zeus.algo.offer;

import java.util.*;

/**
 * @desc:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/29 20:19
 **/
public class Offer_32_III {
    public static void main(String args[]) {
        Offer_32_III_Solution.TreeNode lRoot2 = new Offer_32_III_Solution.TreeNode(4, null, null);
        Offer_32_III_Solution.TreeNode rRoot2 = new Offer_32_III_Solution.TreeNode(5, null, null);
        Offer_32_III_Solution.TreeNode lRoot1 = new Offer_32_III_Solution.TreeNode(2, lRoot2, null);
        Offer_32_III_Solution.TreeNode rRoot1 = new Offer_32_III_Solution.TreeNode(3, null, rRoot2);
        Offer_32_III_Solution.TreeNode root = new Offer_32_III_Solution.TreeNode(1, lRoot1, rRoot1);
        List<List<Integer>> result = new Offer_32_III_Solution().levelOrder(root);
        System.out.println(result);
    }
}


class Offer_32_III_Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList(new LinkedList<Integer>());
        }

        List<List<Integer>> resultLists = new ArrayList<List<Integer>>();

        Queue<LinkedList<TreeNode>> queue = new ArrayDeque<LinkedList<TreeNode>>();
        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);
        queue.add(new LinkedList<>(nodeList));
        int deep = 0;
        while (!queue.isEmpty()) {
            ++deep;
            nodeList = queue.poll();
            LinkedList<Integer> resultList = new LinkedList<>();
            LinkedList<TreeNode> tNodeList = new LinkedList<TreeNode>();
            for (int i = 0; i < nodeList.size(); ++i) {
                if (deep % 2 == 1) {
                    resultList.addLast(nodeList.get(i).val);
                } else {
                    resultList.addFirst(nodeList.get(i).val);
                }

                if (nodeList.get(i).left != null) {
                    tNodeList.add(nodeList.get(i).left);
                }
                if (nodeList.get(i).right != null) {
                    tNodeList.add(nodeList.get(i).right);
                }
            }
            if (!tNodeList.isEmpty()) {
                queue.add(tNodeList);
            }
            resultLists.add(resultList);
        }
        return resultLists;
    }
}
