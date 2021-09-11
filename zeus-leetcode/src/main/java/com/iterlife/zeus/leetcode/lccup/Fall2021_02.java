package com.iterlife.zeus.leetcode.lccup;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/contest/season/2021-fall/problems/uOAnQW/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/11 17:41
 **/
public class Fall2021_02 {

    public static void main(String args[]) {
        new Fall2021_02_Solution().maxmiumScore(new int[]{}, 1);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2}, 1);
        new Fall2021_02_Solution().maxmiumScore(new int[]{3}, 1);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 1}, 1);
        new Fall2021_02_Solution().maxmiumScore(new int[]{3, 1}, 1);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 2}, 1);
        new Fall2021_02_Solution().maxmiumScore(new int[]{3, 2}, 1);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 3}, 1);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 4}, 1);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 1, 2}, 1);
        new Fall2021_02_Solution().maxmiumScore(new int[]{4, 1, 4}, 1);

        new Fall2021_02_Solution().maxmiumScore(new int[]{}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{3}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 1}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{3, 1}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 2}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{3, 2}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 3}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 4}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 1, 2}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{4, 1, 4}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 3, 5, 7}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 4, 6, 8}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 5, 4, 6, 3}, 2);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2);


        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 3}, 3);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 4}, 3);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 1, 2}, 3);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 2, 2}, 3);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 8, 9}, 3);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 4, 6, 8}, 3);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 5, 4, 6, 3}, 3);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3);

        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 3}, 4);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 4}, 4);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 1, 2}, 4);
        new Fall2021_02_Solution().maxmiumScore(new int[]{2, 2, 2}, 4);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 8, 9}, 4);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 5, 4, 6, 3}, 4);
        new Fall2021_02_Solution().maxmiumScore(new int[]{1, 2, 5, 4, 6, 3}, 5);


    }
}


class Fall2021_02_Solution {
    /**
     * 动态规划问题
     */
    public int maxmiumScore(int[] cards, int cnt) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < cards.length; ++i) {
            sb.append(cards[i] + " ");
        }

        int[] sortedArray = Arrays.stream(cards).sorted().toArray();
        if (cnt == 0 || cards.length == 0 || cnt < cards.length) {
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