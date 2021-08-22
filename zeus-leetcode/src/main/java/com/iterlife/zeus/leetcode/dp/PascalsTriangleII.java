package com.iterlife.zeus.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:https://leetcode-cn.com/problems/pascals-triangle-ii/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 11:02
 **/
public class PascalsTriangleII {
    public static void main(String args[]) {
        System.out.println(new PascalsTriangleIISolution().getRow(3));
        System.out.println(new PascalsTriangleIISolution().getRow(0));
        System.out.println(new PascalsTriangleIISolution().getRow(1));
    }
}

class PascalsTriangleIISolution {
    public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex + 1).get(rowIndex);
    }

    public List<List<Integer>> generate(int numRows) {
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
