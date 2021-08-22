package com.iterlife.zeus.leetcode.compute;

import java.util.ArrayList;

/**
 * @desc:https://leetcode-cn.com/problems/reverse-integer/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/25 20:43
 **/
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.print(new ReverseIntegerSolution().reverse(-123));
    }
}


class ReverseIntegerSolution {
    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = x % 10 + n * 10;
            x /= 10;
        }
        return (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) ? 0 : (int) n;
    }

    public int reverse1(int x) {
        ArrayList arrayList = new ArrayList();
        if (x == 0 || x == -0) {
            return x;
        }
        if (x > Integer.MAX_VALUE) {
            x = -(x - Integer.MAX_VALUE);
        }
        String flag = x > 0 ? "" : "-";
        x = x > 0 ? x : -x;

        while (x > 0) {
            arrayList.add(x % 10);
            x /= 10;
        }
        StringBuilder stringBuilder = new StringBuilder(flag);

        for (int i = 0; i < arrayList.size(); ++i) {
            stringBuilder.append(arrayList.get(i));
        }
        try {
            return Integer.valueOf(stringBuilder.toString());
        } catch (Exception e) {
            return 0;
        }
    }
}