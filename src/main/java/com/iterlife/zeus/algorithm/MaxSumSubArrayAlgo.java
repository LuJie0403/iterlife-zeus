/**
 *
 * @project iterlife-zeus
 * @file com.iterlife.zeus.algorithm.MaxSumSubArrayAlgo.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 *
 **/
package com.iterlife.zeus.algorithm;

/**
 *
 * @desc 目前最快的时间复杂度为O(n)的最大子列和问题-在线处理算法
 * @author Lu Jie
 * @date 2019 2019年3月29日 上午9:46:15
 * @tags
 */
public class MaxSumSubArrayAlgo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {1, 3, -1, 2, 5, -3, -1, 32, -20, 13};
		System.out.println(maxSum(array));
	}

	public static int maxSum(int array[]) {
		int maxSum = 0, tempSum = 0;
		for (int i = 0; i < array.length; ++i) {
			tempSum += array[i];
			if (tempSum > maxSum) {
				maxSum = tempSum;
				System.out.println("End:array[" + i + "]=" + array[i]);
			}
			if (tempSum < 0) {
				tempSum = 0;
			}
		}
		return maxSum;
	}
}
