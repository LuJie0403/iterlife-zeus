package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/4 23:55
 **/
public class Offer_46 {

}

class Offer_46_Solution {

    /**
     * 参考：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
     */
    public int translateNum(int num) {
        String strValue = String.valueOf(num);
        int[] dp = new int[strValue.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= strValue.length(); ++i) {
            int temp = Integer.valueOf(strValue.substring(i - 2, i));
            if (temp >= 10 && temp <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[strValue.length()];
    }
}
