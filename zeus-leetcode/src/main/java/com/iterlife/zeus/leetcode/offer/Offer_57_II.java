package com.iterlife.zeus.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/14 23:18
 **/
public class Offer_57_II {
    public static void main(String args[]) {
        new Offer_57_II_Solution().findContinuousSequence(9);
    }
}

class Offer_57_II_Solution {


    class Node {
        int start;
        int end;
        int size;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.size = end - start + 1;
        }
    }

    public int[][] findContinuousSequence(int target) {
        List<Node> result = new ArrayList<Node>();
        if (target <= 2) {
            return new int[][]{};
        }

        for (int start = 1, end = 2, ans = start; start < end && end <= target / 2 + 1; ) {
            ans += end;
            if (ans >= target) {
                if (ans == target) {
                    Node node = new Node(start, end);
                    result.add(node);
                }
                start++;
                ans = start;
                end = start + 1;
                continue;
            }
            end++;
        }
        int[][] ans = new int[result.size()][];
        for (int i = 0; i < result.size(); ++i) {
            int[] temp = new int[result.get(i).size];
            for (int start = result.get(i).start, counter = 0; start <= result.get(i).end && result.get(i).size >= 2; start++, counter++) {
                temp[counter] = start;
            }
            if (temp.length >= 2) {
                ans[i] = temp;
            }
        }
        return ans;
    }
}