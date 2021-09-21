package com.iterlife.zeus.leetcode.offer;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 21:28
 **/
public class Offer_37 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, null, null);
        root.right = new TreeNode(3, new TreeNode(4, null, null), new TreeNode(5, null, null));
        String result = new Codec().serialize(root);
        System.out.println(result);
    }
}


/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode leftNode, TreeNode rightNode) {
        val = x;
        this.left = leftNode;
        this.right = rightNode;
    }
}

class Codec {

    final static String NONE_CHAR = "-";
    final static String SPLIT_CHAR = " ";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return write(root, new StringBuilder()).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] valArray = data.split(SPLIT_CHAR);
        List<String> nodeList = new LinkedList<String>(Arrays.asList(valArray));
        return read(nodeList);
    }

    // Encodes a tree to a single string.
    public StringBuilder write(TreeNode root, StringBuilder result) {
        if (root == null) {
            result.append(NONE_CHAR).append(SPLIT_CHAR);
        } else {
            result.append(root.val).append(SPLIT_CHAR);
            write(root.left, result);
            write(root.right, result);
        }
        return result;
    }

    // Encodes a tree to a single string.
    public TreeNode read(List<String> nodeList) {
        if (NONE_CHAR.equals(nodeList.get(0))) {
            nodeList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodeList.get(0)));
        nodeList.remove(0);
        root.left = read(nodeList);
        root.right = read(nodeList);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));