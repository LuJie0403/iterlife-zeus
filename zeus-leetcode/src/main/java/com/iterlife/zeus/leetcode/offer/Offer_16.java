package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/10 18:18
 **/
public class Offer_16 {
    public static void main(String args[]) {
        //   System.out.println(new Offer_16_Solution().myPow(34.00515, -3));
        System.out.println(new Offer_16_Solution().myPow(2.00000, -2147483648));
    }

}

class Offer_16_Solution {
    public double myPow(double x, int n) {
        if (Math.abs(x) - 1d == 0) {
            return n % 2 == 0 ? 1d : x;
        }

        if (n > Integer.MAX_VALUE || n <= Integer.MIN_VALUE) {
            return 0d;
        }
        System.out.print(Integer.MIN_VALUE);
        if (n >= 0) {
            return myPowPositive(x, n);
        }
        double ans = myPowPositive(x, -n);
        return 1 / ans;
    }

    public double myPowPositive(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 1) {
            return myPowPositive(x * x, n / 2) * x;
        }
        return myPowPositive(x * x, n / 2);
    }
}
