package com.iterlife.zeus.leetcode.bit;

/**
 * @desc:https://leetcode-cn.com/problems/reverse-bits-lcci/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/22 11:37
 **/
public class ReverseBitsLcci {

    public static void main(String args[]) {

        System.out.println(String.format("[2>>1] = %s,[2/2] = %s", 2 >> 1, 2 / 2));
        System.out.println(String.format("[2>>>1] = %s,[2/2] = %s", 2 >>> 1, 2 / 2));
        System.out.println(String.format("[-1>>1] = %s,[-1/2] = %s", -1 >> 1, -1 / 2));
        System.out.println(String.format("[-1>>>1] = %s,[-1/2] = %s", -1 >>> 1, -1 / 2));
        System.out.println(String.format("[-2>>1] = %s,[-2/2] = %s", -2 >> 1, -2 / 2));
        System.out.println(String.format("[-2>>>1] = %s,[-2/2] = %s", -2 >>> 1, -2 / 2));
        System.out.println(String.format("[-5>>1] = %s,[-5/2] = %s", -5 >> 1, -5 / 2));
        System.out.println(String.format("[-5>>>1] = %s,[-5/2] = %s", -5 >>> 1, -5 / 2));

        System.out.println(String.format("\nnum=%s maxLength=%s\n", -1, new ReverseBitsLcciSolution().reverseBits(-1)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", -2, new ReverseBitsLcciSolution().reverseBits(-2)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", -3, new ReverseBitsLcciSolution().reverseBits(-3)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", -4, new ReverseBitsLcciSolution().reverseBits(-4)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", -10, new ReverseBitsLcciSolution().reverseBits(-10)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", -51, new ReverseBitsLcciSolution().reverseBits(-51)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", -440783016, new ReverseBitsLcciSolution().reverseBits(-440783016)));

        System.out.println(String.format("\nnum=%s maxLength=%s\n", 0, new ReverseBitsLcciSolution().reverseBits(0)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", 1, new ReverseBitsLcciSolution().reverseBits(1)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", 7, new ReverseBitsLcciSolution().reverseBits(7)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", 8, new ReverseBitsLcciSolution().reverseBits(8)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", 15, new ReverseBitsLcciSolution().reverseBits(15)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", 1775, new ReverseBitsLcciSolution().reverseBits(1775)));
        System.out.println(String.format("\nnum=%s maxLength=%s\n", 440783016, new ReverseBitsLcciSolution().reverseBits(440783016)));
    }
}


class ReverseBitsLcciSolution {
    public int reverseBits(int num) {
        int[] bitCounters = splitBits(num);
        int maxLength = bitCounters[0] + 1, tempLength = 0;
        for (int i = 1; i < bitCounters.length; ++i) {
            tempLength = bitCounters[i - 1] + bitCounters[i] + 1;
            maxLength = maxLength > tempLength ? maxLength : tempLength;
        }
        return maxLength > 32 ? 32 : maxLength;
    }

    public int[] splitBits(int num) {
        int tCounter = 0, cIndex = 0, cSize = 32;
        int bitCounters[] = new int[cSize];
        while (cSize-- > 0) {
            int bit = num & 0b001;
            tCounter += bit;
            if (bit == 0 || cSize == 0) {
                bitCounters[cIndex++] = tCounter;
                tCounter = 0;
            }
            num = num >>> 1;
        }
        return bitCounters;
    }
}
