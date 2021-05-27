package com.iterlife.zeus.leetcode;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/problems/find-the-highest-altitude/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/5/27 10:43
 **/
public class FindTheHighestAltitude {
    public static void main(String[] args) {
        // int[] gain = new int[]{-5, 1, 5, 0, -7};
        int[] gain = new int[]{-4, -3, -2, -1, 4, 3, 2};

        System.out.println(new FindTheHighestAltitudeSolution().largestAltitude(gain));
    }
}


class FindTheHighestAltitudeSolution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;
        for (int i = 0; i < gain.length; ++i) {
            int diffAltitude = gain[i];
            if (currentAltitude + diffAltitude > maxAltitude) {
                maxAltitude = currentAltitude + diffAltitude;
            }
            currentAltitude += diffAltitude;
        }
        return maxAltitude;
    }
}