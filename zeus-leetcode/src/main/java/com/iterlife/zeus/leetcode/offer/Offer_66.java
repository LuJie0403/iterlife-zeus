package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/13 00:36
 **/
public class Offer_66 {
    public static void main(String args[]) {
        new Offer_66_Solution().constructArr2(new int[]{1, 2, 3, 4, 5});
    }
}

class Offer_66_Solution {
    /**
     * 常规操作，数据量大的情况下循规蹈矩地进行乘法运算会导致计算超时，所以需要减少乘法次数
     */
    public int[] constructArr1(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; ++i) {
            b[i] = 1;
            for (int j = 0; j < a.length; j++) {
                if (j == i) {
                    continue;
                }
                if (a[j] == 1) {
                    continue;
                }
                if (a[j] == -1) {
                    b[i] = -b[i];
                }
                b[i] *= a[j];

            }
        }
        return b;
    }

    /**
     * 上/下三角动态规划法
     * 执行用时：2 ms, 在所有 Java 提交中击败了 53.40% 的用户
     * 内存消耗：50.4 MB, 在所有 Java 提交中击败了 99.20% 的用户
     */
    public int[] constructArr2(int[] a) {
        if (a == null || a.length == 0) {
            return new int[]{};
        }

        int[] bLeft = new int[a.length];
        int[] bRight = new int[a.length];
        int b[] = new int[a.length];

        bLeft[0] = 1;
        bRight[a.length - 1] = 1;
        // 动态规划下三角
        for (int i = 1, cur = 1; i < a.length; ++i) {
            bLeft[i] = bLeft[i - 1] * a[i - 1];
        }
        //动态规划上三角
        for (int i = a.length - 2; i >= 0; --i) {
            bRight[i] = bRight[i + 1] * a[i + 1];
        }
        //计算结果值
        for (int i = 0; i < a.length; ++i) {
            b[i] = bLeft[i] * bRight[i];
        }
        return b;
    }
}