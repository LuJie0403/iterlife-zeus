package com.iterlife.zeus.algo.dp;

/**
 * @desc:https://leetcode-cn.com/problems/divisor-game/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 19:02
 **/
public class DivisorGame {

    public static void main(String args[]) {
        //  System.out.println(new DivisorGameSolution().divisorGame1(2));
        System.out.println(new DivisorGameSolution().divisorGame1(3));
    }
}

class DivisorGameSolution {
    public boolean divisorGame1(int n) {
        int counter = 0;
        for (int x = 1; x <= n; x++) {
            if (n % x == 0) {
                n -= x;
                x = 1;
                counter++;
            }
        }
        return counter % 2 != 0;
    }

    /**
     * 如果N是奇数，因为奇数的所有因数都是奇数，因此 N 进行一次 N-x 的操作结果一定是偶数
     * 所以如果 a 拿到了一个奇数，那么轮到 b 的时候，b拿到的肯定是偶数，这个时候 b 只要进行 -1， 还给 a 一个奇数，那么这样子b就会一直拿到偶数，到最后b一定会拿到最小偶数2，a就输了。
     * 所以如果游戏开始时Alice拿到N为奇数，那么她必输，也就是false。如果拿到N为偶数，她只用 -1，让bob 拿到奇数，最后bob必输，结果就是true。
     */
    public boolean divisorGame2(int n) {
        return (n & 0b0001) != 0b0001;
    }
}
