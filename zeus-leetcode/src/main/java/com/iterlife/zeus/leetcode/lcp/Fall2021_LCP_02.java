package com.iterlife.zeus.leetcode.lcp;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/contest/season/2021-fall/problems/uOAnQW/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/11 17:41
 **/
public class Fall2021_LCP_02 {

    public static void main(String args[]) {

        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 3}, 1));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{3, 1}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 1}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 3}, 2));

        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{3, 3, 1}, 1));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 8, 9}, 3));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{}, 1));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2}, 1));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{3}, 1));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 1}, 1));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{3, 1}, 1));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 2}, 1));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{3, 2}, 1));

        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 4}, 1));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 1, 2}, 1));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{4, 1, 4}, 1));

        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{3}, 2));

        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 2}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{3, 2}, 2));

        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 4}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 1, 2}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{4, 1, 4}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 3, 5, 7}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 4, 6, 8}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 5, 4, 6, 3}, 2));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2));

        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 3}, 3));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 4}, 3));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 1, 2}, 3));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 2, 2}, 3));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 8, 9}, 3));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 4, 6, 8}, 3));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 5, 4, 6, 3}, 3));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3));

        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 3}, 4));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 4}, 4));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 1, 2}, 4));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{2, 2, 2}, 4));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 8, 9}, 4));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 5, 4, 6, 3}, 4));
        System.out.println(new Fall2021_LCP_02_Solution().maxmiumScore2(new int[]{1, 2, 5, 4, 6, 3}, 5));
    }
}


class Fall2021_LCP_02_Solution {
    /**
     * 动态规划问题
     */
    public int maxmiumScore1(int[] cards, int cnt) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < cards.length; ++i) {
            sb.append(cards[i] + " ");
        }

        int[] sortedArray = Arrays.stream(cards).sorted().toArray();
        if (cnt == 0 || cards.length == 0 || cnt > cards.length) {
            return 0;
        }
        int[][] locations = findNumberLocation(sortedArray);
        int[] result = new int[cnt + 1];
        result[0] = 0;
        result[1] = locations[0][1] == -1 ? 0 : sortedArray[locations[0][1]];

        for (int counter = 2; counter <= cnt; ++counter) {
            int evenResult = 0, oddResult = 0;
            locations = findNumberLocation(sortedArray);
            evenResult = locations[0][0] == -1 || locations[0][1] == -1 ? 0 : sortedArray[locations[0][0]] + sortedArray[locations[0][1]];
            oddResult = locations[1][1] == -1 || locations[1][0] == -1 ? 0 : sortedArray[locations[1][0]] + sortedArray[locations[1][1]];

            if (counter % 2 == 1) {
                result[counter] += evenResult;
            } else {
                result[counter] = (oddResult >= evenResult ? oddResult : evenResult);
            }

            if (oddResult >= evenResult && locations[1][0] != -1 && locations[1][1] != -1) {
                sortedArray[locations[1][0]] = 0;
                sortedArray[locations[1][1]] = oddResult;
            }

            if (oddResult < evenResult && locations[0][0] != -1 && locations[0][1] != -1) {
                sortedArray[locations[0][0]] = 0;
                sortedArray[locations[0][1]] = evenResult;
            }
        }
        System.out.println(String.format("Array=%s, cnt=%d, result=%d", sb.append("]").toString(), cnt, result[cnt]));

        return result[cnt];
    }

    /**
     * 动态规划问题
     */
    public int maxmiumScore2(int[] cards, int cnt) {
        int[] sortedArray = Arrays.stream(cards).sorted().toArray();
        if (cnt == 0 || cards.length == 0 || cnt > cards.length) {
            return 0;
        }
        // 选取最大的 cnt 计算其累加值为最大值
        int result = 0, minOddValue = 0, minEvenValue = 0;
        for (int i = sortedArray.length - 1; i > sortedArray.length - cnt - 1; i--) {
            //当前值为偶数的情况
            if ((sortedArray[i] & 0b0001) == 1) {
                minOddValue = sortedArray[i];
            } else {
                //当前值为奇数
                minEvenValue = sortedArray[i];
            }
            result += sortedArray[i];
        }

        //当前计算结果为偶数，直接返回累加值
        if ((result & 0b0001) == 0) {
            return result;
        }

        //当前计算结果为奇数，其中有偶数个奇数（此种情况不会发生：偶数个奇数的和不可能为奇数）

        //当前计算结果为奇数：取方案1和方案2结果值最大的一种方案为最终方案
        //方案1：将最小的奇数换成剩余数组中最大的偶数
        //方案2：将最小的偶数换成剩余数组中最大的奇数

        int[] temp = findNumber(sortedArray, sortedArray.length - cnt);
        int replacedEvenResult = 0, replacedOddResult = 0;
        //查找没有可以替换 result 的剩余数组中最大的奇数result[0]和最大的偶数result[1]
        if (temp[0] == 0 && temp[1] == 0) {
            return 0;
        }
        if (temp[0] != 0 && temp[1] == 0) {
            if (minOddValue == 0) {
                return 0;
            }
            return result + temp[0] - minOddValue;
        }
        if (temp[1] != 0 && temp[0] == 0) {
            if (minEvenValue == 0) {
                return 0;
            }
            return result + temp[1] - minEvenValue;
        }
        if (temp[0] != 0 && temp[1] != 0) {
            if (minEvenValue == 0 && minOddValue == 0) {
                return 0;
            }
            if (minEvenValue != 0 && minOddValue != 0) {
                replacedEvenResult = result + temp[0] - minOddValue;
                replacedOddResult = result + temp[1] - minEvenValue;
                return replacedEvenResult > replacedOddResult ? replacedEvenResult : replacedOddResult;
            }
            if (minEvenValue == 0 && minOddValue != 0) {
                return result + temp[0] - minOddValue;
            }
            if (minEvenValue != 0 && minOddValue == 0) {
                return result + temp[1] - minEvenValue;
            }
        }
        return 0;
    }

    /**
     * 查找剩余正向有序数组中最大的偶数result[0]和最大的奇数result[1]
     */
    public int[] findNumber(int[] num, int length) {
        int[] result = new int[2];
        for (int i = length - 1; i >= 0; i--) {
            if ((num[i] & 0b0001) == 0) {
                result[0] = (result[0] == 0 ? num[i] : result[0]);
            }
            if ((num[i] & 0b0001) == 1) {
                result[1] = (result[1] == 0 ? num[i] : result[1]);
            }

        }
        return result;
    }

    /**
     * @param num 原始输入数组
     * @return locations[][]
     * locations[0][]:i=0表示最大的两个偶数
     * locations[1][]:i=1表示最大的两个奇数
     */
    public int[][] findNumberLocation(int num[]) {
        int[][] locations = new int[][]{{-1, -1}, {-1, -1}};
        int eventCounter = 2, oddCounter = 2;
        for (int i = num.length - 1; i >= 0 && (eventCounter > 0 || oddCounter > 0); --i) {
            if (num[i] == 0) {
                continue;
            }
            if (num[i] % 2 == 0 && eventCounter > 0) {
                locations[0][--eventCounter] = i;
            }
            if (num[i] % 2 == 1 && oddCounter > 0) {
                locations[1][--oddCounter] = i;
            }
        }
        return locations;
    }


    public void print(int[] num) {
        Arrays.stream(num).forEach(System.out::println);
    }

}