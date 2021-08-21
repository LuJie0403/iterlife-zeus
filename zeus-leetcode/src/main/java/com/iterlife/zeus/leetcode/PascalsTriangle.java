package com.iterlife.zeus.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:https://leetcode-cn.com/problems/pascals-triangle/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 11:02
 **/
public class PascalsTriangle {
    public static void main(String args[]) {
        System.out.println(new PascalsTriangleSolution().generate1(3));
        System.out.println(new PascalsTriangleSolution().generate2(1));
    }
}

class PascalsTriangleSolution {
    public List<List<Integer>> generate1(int numRows) {
        int array[][] = new int[numRows + 1][numRows + 1];
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (i == 0 || j == 0 || i == j) {
                    array[i][j] = 1;
                    tempList.add(j, array[i][j]);
                    continue;
                }
                array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                tempList.add(j, array[i][j]);
            }
            resultList.add(i, tempList);
        }
        return resultList;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> antList = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (i == 0 || j == 0 || i == j) {
                    antList.add(j, 1);
                    continue;
                }
                antList.add(j, resultList.get(i - 1).get(j - 1) + resultList.get(i - 1).get(j));
            }
            resultList.add(i, antList);
        }
        return resultList;
    }
}
