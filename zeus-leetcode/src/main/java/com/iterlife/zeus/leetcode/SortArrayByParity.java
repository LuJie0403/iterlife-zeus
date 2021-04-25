/**
 * @project iterlife-zeus
 * @file lang.leetcode.OddEvenNumber.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 **/
package com.iterlife.zeus.leetcode;

/**
 * @author Lu Jie
 * @desc https://lang.leetcode-cn.com/problems/sort-array-by-parity/
 * @date 2019 2019年3月24日 下午3:16:47
 * @tags
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        int a[] = {0, 2};
        new SortArrayByParitySolution().sortArrayByParity(a);
        for (int k : a) {
            System.out.print(k + " ");
        }
    }

}

class SortArrayByParitySolution {
    public int[] sortArrayByParity(int[] A) {

        for (int i = 0, j = A.length - 1; i < j; ++i, --j) {
            while (i < j && A[i] % 2 == 0) {
                i++;
            }
            while (j > i && A[j] % 2 == 1) {
                j--;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return A;
    }
}
