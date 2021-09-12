package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/10 18:07
 **/
public class Offer_64 {

}


class Offer_64_Solution {
    public int sumNums(int n) {
        //  return n > 0 ? n + sumNums(n - 1) : n;
        int sum = n;
        boolean flag = (n > 0) && ((sum += sumNums(n - 1)) > 0);
        return sum;
    }
}