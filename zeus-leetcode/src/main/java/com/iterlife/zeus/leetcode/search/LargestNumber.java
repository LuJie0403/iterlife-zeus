package com.iterlife.zeus.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @desc:https://leetcode-cn.com/problems/largest-number/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/25 15:17
 **/
public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new LargestNumberSolution().largestNumber(new int[]{0, 0}));
    }
}

class LargestNumberSolution {
    public String largestNumber(int[] nums) {
        List<String> strList = new ArrayList<String>();
        Arrays.stream(nums).forEach(num -> strList.add(Integer.toString(num)));
        if (strList.size() == 1) {
            return strList.get(0);
        }
        strList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1.concat(o2);
                String s2 = o2.concat(o1);
                return s2.compareTo(s1);
            }
        });
        StringBuilder result = new StringBuilder("");
        strList.forEach(str -> {
            if (!("0".equals(result.toString()) || "0".equals(strList))) {
                result.append(str);
            }
        });
        return result.toString();
    }
}
