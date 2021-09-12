package com.iterlife.zeus.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 22:27
 **/
public class Offer_36 {
}


class Offer_36_Solution {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> ansList = new ArrayList<Node>();
        inorderTraverse(root, ansList);
        for (int i = 0; i < ansList.size(); ++i) {
            Node tNode = ansList.get(i);
            tNode.left = (i == 0) ? ansList.get(ansList.size() - 1) : ansList.get(i - 1);
            tNode.right = (i == ansList.size() - 1) ? ansList.get(0) : ansList.get(i + 1);
        }
        Node head = ansList.get(0);
        return head;
    }

    public void inorderTraverse(Node node, List<Node> ansList) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inorderTraverse(node.left, ansList);
        }
        ansList.add(node);
        if (node.right != null) {
            inorderTraverse(node.right, ansList);
        }
    }
}