package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/w3tCBm/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 21:42
 **/
public class W3tCBm {
    public static void main(String args[]) {
        new W3tCBmSolution().countBits(0);
        // new W3tCBmSolution().countBits(10);
    }
}


class W3tCBmSolution {
    public int[] countBits(int n) {
        int counter[] = new int[n + 1];
        counter[0] = 0;
        if (n >= 1) {
            counter[1] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            counter[i] = (i & 0b0001) == 0 ? counter[i >> 1] : counter[i >> 1] + 1;
            System.out.print(String.format("counter[%s]=%s\n", i, counter[i]));
        }
        return counter;
    }
}