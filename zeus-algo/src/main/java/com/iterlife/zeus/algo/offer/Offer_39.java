package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/13 00:30
 **/
public class Offer_39 {
}

class Offer_39_Solution {
    //Boyer-Moore 投票算法
    public int majorityElement(int[] nums) {
        int ans = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                ans = num;
                cnt += 1;
            } else {
                //当 cnt=0 的时候，可以认为前面的遍历都无效了，相等的 num 和所有互不相等的数字总和相等，从头再来
                cnt += (ans == num) ? 1 : -1;
            }
        }
        return ans;
    }
}