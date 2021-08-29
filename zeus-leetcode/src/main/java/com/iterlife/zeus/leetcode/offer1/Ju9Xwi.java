package com.iterlife.zeus.leetcode.offer1;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/22 17:12
 **/
public class Ju9Xwi {
}

class Ju9XwiSolution {
    public int leastMinutes(int n) {
        int result = 0, ant = 1;
        while (ant <= n) {
            ant <<= 1;
            result++;
        }
        return result + 1;
    }
}
