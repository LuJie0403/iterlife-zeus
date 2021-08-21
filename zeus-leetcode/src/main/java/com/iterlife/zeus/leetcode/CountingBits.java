package com.iterlife.zeus.leetcode;

/**
 * @desc:https://leetcode-cn.com/problems/counting-bits/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 17:37
 **/
public class CountingBits {
    public static void main(String args[]) {
        new CountingBitsSolution().countBits(10);
    }
}


class CountingBitsSolution {
    /**
     * 核心原理：当 i 最低位是0时,i中1的个数和 i>>1 相同，否则就是(i>>1)中1的个数再加1
     */
    public int[] countBits(int n) {
        int bitCounter[] = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            //  bitCounter[i] = bitCounter[i >> 1] + ((i & 0b0001) == 1 ? 1 : 0);
            bitCounter[i] = bitCounter[i >> 1] + (i & 0b0001);
            System.out.println(String.format("bitCounter[%s]=%s", i, bitCounter[i]));
        }
        return bitCounter;
    }
}
