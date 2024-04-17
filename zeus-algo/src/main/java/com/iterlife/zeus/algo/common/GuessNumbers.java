package com.iterlife.zeus.algo.common;

/**
 * @desc:https://leetcode-cn.com/problems/guess-numbers/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/15 09:31
 **/
public class GuessNumbers {

    public static void main(String args[]) {
        new GuessNumbersSolution().game2(new int[]{1, 2, 3}, new int[]{3, 2, 3});
    }
}

class GuessNumbersSolution {
    public int game1(int[] guess, int[] answer) {
        int counter = 0;
        for (int i = 0; i < guess.length; ++i) {
            if ((guess[i] ^ answer[i]) == 0) {
                counter++;
            }
        }
        return counter;
    }

    public int game2(int[] guess, int[] answer) {
        int counter = 0;
        for (int i = 0; i < guess.length; ++i) {
            counter += (guess[i] ^ answer[i]) == 0 ? 1 : 0;
        }
        return counter;
    }
}


