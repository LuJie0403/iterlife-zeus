package com.iterlife.zeus.algo.dp;

/**
 * @desc:https://leetcode-cn.com/problems/climbing-stairs/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 15:18
 **/
public class ClimbingStairs {
    public static void main(String args[]) {
        System.out.println(new ClimbingStairsSolution().climbStairs1(3) + " " + new ClimbingStairsSolution().climbStairs2(3));
        System.out.println(new ClimbingStairsSolution().climbStairs1(4) + " " + new ClimbingStairsSolution().climbStairs2(4));
        System.out.println(new ClimbingStairsSolution().climbStairs1(5) + " " + new ClimbingStairsSolution().climbStairs2(5));
        System.out.println(new ClimbingStairsSolution().climbStairs1(7) + " " + new ClimbingStairsSolution().climbStairs2(7));
        System.out.println(new ClimbingStairsSolution().climbStairs1(10) + " " + new ClimbingStairsSolution().climbStairs2(10));
        System.out.println(new ClimbingStairsSolution().climbStairs1(33) + " " + new ClimbingStairsSolution().climbStairs2(33));
    }
}

class ClimbingStairsSolution {
    /**
     * 每次你可以爬 1 或 2 个台阶,假设怕第n层的方法有f(n)种，则:
     * f(1)=1
     * f(2)=2
     * f(3)=f(2)+f(1)=3
     * f(4)=最后一步踩一个台阶[f(3)+f(1)]=4 或 最后一步踩两个台阶[f(2)+f(2)]=4
     * f(5)=最后一步踩一个台阶[f(4)+f(1)]或 最后一步踩两个台阶[f(3)+f(2)]
     * ...
     * f(n)=最后一步踩一个台阶[f(n-1)+f(1)]或 最后一步踩两个台阶[f(n-2)+f(2)]
     * 缺点：超出时间限制
     */
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        //下述表示从第三层及以上的情况
        int counter = 0;
        int index1 = 1;//累计从 n-1 层到 n 层的方法共1种，初始时表示从第3层开始
        int index2 = 2;//累计从 n-2 层到 n 层的方法共2种，初始时表示从第3层开始
        for (int k = 3; k <= n; ++k) {
            counter = (index1 + index2);
            index1 = index2;
            index2 = counter;
        }
        return counter;
    }
}