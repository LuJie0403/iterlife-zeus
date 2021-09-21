package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 16:32
 **/
public class Offer_43 {
    public static void main(String args[]) {
        System.out.println(new Offer_43_Solution().countDigitOne(1410065408));
    }
}

/**
 * 枚举每一个数位，分别统计该数位上数字 11 出现的次数，最后将所有数位统计出的次数进行累加即可得到答案
 * ⌊n/10^(k+1)⌋×10^k+min(max(n mod 10^(k+1)−10^k+1,0),10^k)   {k=0,1,2,...,位数}
 */
class Offer_43_Solution {

    public int countDigitOne(int n) {
        //假设上述公式 t=10^k;
        int ans = 0;
        long t = 1;
        while (n >= t) {
            ans += ((n / (t * 10)) * t + Math.min(Math.max(n % (t * 10) - t + 1, 0), t));
            t *= 10;
        }
        return ans;
    }
}