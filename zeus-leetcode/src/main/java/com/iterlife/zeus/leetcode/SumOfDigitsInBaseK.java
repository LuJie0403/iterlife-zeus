package com.iterlife.zeus.leetcode;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/26 09:13
 **/
public class SumOfDigitsInBaseK {
}


class SumOfDigitsInBaseKSolution {
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }
}
