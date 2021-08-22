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
        System.out.println(new ChuanDiXinXiSolution().numWays1(5, relation, 3));
        System.out.println(new ChuanDiXinXiSolution().numWays2(5, relation, 3));
    }
}

class ChuanDiXinXiSolution {
    public int numWays1(int n, int[][] relation, int k) {
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
        }
        return dp[n - 1][k];
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi/solution/chuan-di-xin-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numWays2(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }
}
