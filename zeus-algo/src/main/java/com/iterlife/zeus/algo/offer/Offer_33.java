package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 16:56
 **/
public class Offer_33 {
}


class Offer_33_Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) {
            return true;
        }
        return verifyChildTree(postorder, 0, postorder.length - 1);
    }

    public boolean verifyChildTree(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int rootValue = postorder[right];
        int k = left;
        //找到第一个大于根结点的值，大于根结点的值属于右子树,分成两组
        while (k < right && postorder[k] < rootValue) {
            k++;
        }
        // 进行判断后续的区域是否所有的值都是大于当前的根节点，如果出现小于的值就直接返回false
        for (int i = k; i < right; i++) {
            if (postorder[i] < rootValue) {
                return false;
            }
        }
        if (!verifyChildTree(postorder, left, k - 1)) {
            return false;
        }
        if (!verifyChildTree(postorder, k, right - 1)) {
            return false;
        }
        return true;
    }
}
