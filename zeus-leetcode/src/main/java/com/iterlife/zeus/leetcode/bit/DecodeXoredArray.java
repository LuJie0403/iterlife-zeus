package com.iterlife.zeus.leetcode.bit;

/**
 * @desc:https://leetcode-cn.com/problems/decode-xored-array/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/5/11 21:44
 **/
public class DecodeXoredArray {
    public static void main(String[] args) {
        int[] encoded = new int[]{6, 2, 7, 3};
        int first = 4;
        int[] decoded = new DecodeXoredArraySolution().decode(encoded, first);
        for (int i = 0; i < decoded.length; ++i) {
            System.out.println(decoded[i]);
        }
    }
}


class DecodeXoredArraySolution {
    public int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;
        for (int i = 0; i < decoded.length - 1; ++i) {
            //encoded[i] = decoded[i] ^ decoded[i + 1];
            decoded[i + 1] = encoded[i] ^ decoded[i];
        }
        return decoded;
    }
}