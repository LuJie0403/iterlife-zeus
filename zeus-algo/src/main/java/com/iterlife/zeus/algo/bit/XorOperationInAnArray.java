package com.iterlife.zeus.algo.bit;

/**
 * @desc:https://leetcode-cn.com/problems/xor-operation-in-an-array/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/5/11 18:44
 **/
public class XorOperationInAnArray {
    public static void main(String[] args) {
        System.out.print(new XorOperationInAnArraySolution().xorOperation(1, 0));
    }
}

class XorOperationInAnArraySolution {
    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; ++i) {
            result ^= (2 * i + start);
        }
        return result;
    }
}
