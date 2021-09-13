package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/13 09:54
 **/
public class Offer_12 {
}


class Offer_12_Solution {
    /**
     * 检查字符矩阵 board 中是否存在字符串 word 的一个子序列
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word.isEmpty()) {
            return word.isEmpty() ? true : false;
        }
        char[] words = word.toCharArray();
        //从所有可能的起点开始进行暴露穷举例
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 矩阵遍历方法
     *
     * @param board 原始字母矩阵
     * @param x     检索起始位置横坐标
     * @param y     检索起始位置纵坐标
     * @param words 需要检索的原始字符串
     * @param index 从字符串的第 k 个位置开始检索
     * @return true - 检索成功 false - 检索失败
     */
    private boolean dfs(char[][] board, int x, int y, char[] words, int index) {

        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || board[x][y] != words[index]) {
            return false;
        }
        //说明字符串中所有字母已经遍历结束
        if (index == words.length - 1) {
            return true;
        }
        //说明找到了本次需要遍历的字符，因为字符不可以重复遍历，所以需要对该已经遍历的字符打标
        char temp = board[x][y];
        board[x][y] = '\0';
        //继续递归从各个方向找下一个字符，任意方向找到即可
        if (dfs(board, x + 1, y, words, index + 1) ||
                dfs(board, x - 1, y, words, index + 1) ||
                dfs(board, x, y - 1, words, index + 1) ||
                dfs(board, x, y + 1, words, index + 1)) {
            return true;
        }
        //没有找到
        board[x][y] = temp;
        return false;
    }
}
