/**
 *
 * @project iterlife-zeus
 * @file com.iterlife.zeus.leetcode.SudokuSolver.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 *
 **/
package com.iterlife.zeus.leetcode;

/**
 *
 * @desc
 * @author Lu Jie
 * @date 2019 2019年3月24日 下午3:45:14
 * @tags
 */
public class SudokuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static final int trueFlag = 45;

	/**
	 * 检查3*3方格
	 * 
	 * @param board
	 * @param row
	 *                  当前行标
	 * @param col
	 *                  当前列表
	 * @return
	 * @return 通过与否
	 */
	private boolean boardChecker(char board[][], int row, int col) {

		int temp = 0;
		for (int i = row - 1; i < row + 1; i++) {
			for (int j = col - 1; i < col + 1; j++) {
				temp += board[i][j];
			}
		}
		return temp == 0;
	}

	/**
	 * 检查程序主入口，检查行，列以及3*3是否符合规则
	 * 
	 * @param board
	 * @return 通过与否
	 */
	public void solveSudoku(char[][] board) {
		boolean boardCheckFlag = true;
		// 定义十个大小单元的 int 数组，默认初始值均为0，前九位代表0-8列，第十位代表当前行的累计和
		int[] checkResult = new int[10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				checkResult[j] += board[i][j];
				checkResult[9] += board[i][j];
				if (i % 3 == 1 && j % 3 == 1) {
					boardCheckFlag = boardChecker(board, i, j);
				}
			}
			if (checkResult[9] == trueFlag && boardCheckFlag) {
				checkResult[9] = 0;
			} else {
				return;
			}
		}
		for (int i : checkResult) {
			if (i != trueFlag) {
				return;
			}
		}
		return;
	}

}
