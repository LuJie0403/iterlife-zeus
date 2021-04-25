/**
 * @project iterlife-zeus
 * @file lang.algorithm.SingleNumber.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 **/
package com.iterlife.zeus.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Lu Jie
 * @desc https://lang.leetcode-cn.com/problems/single-number-iii/
 * https://leetcode-cn.com/problems/single-number/
 * https://leetcode-cn.com/problems/single-number-ii/
 * @date 2019 2019年3月24日 上午11:47:09
 * @tags
 */
public class SingleNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(new SingleNumberSolution().singleNumber1(a));
        System.out.println(new SingleNumberSolution().singleNumber2(a));
        System.out.println(new SingleNumberSolution().singleNumber3(a));
    }
}

class SingleNumberSolution {
    public int singleNumber1(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public int[] singleNumber2(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int temp = nums[i];
            boolean removed = list.removeIf(e -> e.equals(temp));
            if (!removed) {
                list.add(temp);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int singleNumber3(int[] nums) {
        int result = 0;
        Map<Integer, Integer> items = new HashMap<Integer, Integer>();
        for (int num : nums) {
            Integer intValue = (items.get(num) == null)
                    ? 1
                    : items.get(num) + 1;
            items.put(num, intValue);
        }

        for (Map.Entry<Integer, Integer> kv : items.entrySet()) {
            if (kv.getValue() == 1) {
                result = kv.getKey();
                break;
            }
        }
        return result;
    }
}
