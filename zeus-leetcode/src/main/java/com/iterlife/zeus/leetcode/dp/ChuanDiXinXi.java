package com.iterlife.zeus.leetcode.dp;

/**
 * @desc:https://leetcode-cn.com/problems/chuan-di-xin-xi/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/22 17:33
 **/
public class ChuanDiXinXi {


    public static void main(String args[]) {
        int[][] relation = new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        System.out.println(new ChuanDiXinXiSolution().numWays(5, relation, 3));
    }
}

class ChuanDiXinXiSolution {
    public int numWays(int n, int[][] relation, int k) {

        printMap(n, relation);

        //dp[i][j]表示第j轮传递到编号为i的小朋友的总方案数
        //dp[i][j]+=dp[i][j-1]
        int[][] dp = new int[n][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j < relation.length; ++j) {
                int u = relation[j][0];
                int v = relation[j][1];
                dp[v][i] += dp[u][i - 1];
            }
            printDp(i, dp);
        }
        return dp[n - 1][k];
    }

    public void printDp(int k, int[][] input) {
        int[][] output = new int[input[0].length][input.length];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; ++j) {
                output[i][j] = input[j][i];
            }
        }


        System.out.println(String.format("\n第 %s 轮动态规划结果:", k));
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < output[i].length; ++j) {
                System.out.print(String.format(" %s  |", output[i][j]));
            }
            System.out.println("\n");
        }
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < output[i].length; ++j) {
                if (i == k - 1 && output[i][j] > 0) {
                    System.out.println(String.format("第 %s 轮结束后到达 %s 的路径长度畅通，距离+%s", i, j, output[i][j]));
                }
            }
        }
    }

    public void printMap(int k, int[][] input) {
        int[][] map = new int[k][k];

        for (int i = 0; i < input.length; ++i) {
            map[input[i][0]][input[i][1]] = 1;
        }
        System.out.print("   ||");
        for (int i = 0; i < map.length; ++i) {
            System.out.print(String.format("  %s |", i));
        }
        System.out.println("\n________________________________");
        for (int i = 0; i < map.length; ++i) {
            System.out.print(String.format(" %s ||", i));
            for (int j = 0; j < map[i].length; ++j) {
                System.out.print(String.format(" %s  |", map[i][j] == 1 ? " " : "0"));
            }
            System.out.print("\n");
        }
    }
}
