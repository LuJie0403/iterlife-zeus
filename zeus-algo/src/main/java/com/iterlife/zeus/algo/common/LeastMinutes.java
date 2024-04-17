package com.iterlife.zeus.algo.common;

/**
 * @desc:https://leetcode-cn.com/problems/Ju9Xwi/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/22 17:12
 **/
public class LeastMinutes {
}

class LeastMinutesSolution {
    public int leastMinutes(int n) {
        int result = 0, ant = 1;
        while (ant <= n) {
            ant <<= 1;
            result++;
        }
        return result + 1;
    }
}
