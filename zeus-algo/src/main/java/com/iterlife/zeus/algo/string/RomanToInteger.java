package com.iterlife.zeus.algo.string;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * Copyright (C) 2025 Shanghai Shuhe.Co.Ltd. All rights reserved.
 * create date: 2025/7/10 21:03
 * <p>
 *
 * @author lujie
 * @version V1.0.0
 * @desc https://leetcode.cn/problems/roman-to-integer/
 * @datetime 2025/7/10 21:03
 **/
public class RomanToInteger {
	
	public static final Map<Character, Integer> romanNumeralsMap = Stream.of(new Object[][]{{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}})
			.collect(Collectors.toMap(data -> (Character) data[0], data -> (Integer) data[1]));
	
	public static void main(String args[]) {
		System.out.println(new RomanToInteger().romanToInt("III"));
		System.out.println(new RomanToInteger().romanToInt("IV"));
		System.out.println(new RomanToInteger().romanToInt("IX"));
		System.out.println(new RomanToInteger().romanToInt("LVIII"));
		System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
	}
	
	public int romanToInt(String s) {
		//int result = romanNumeralsMap.get(s.charAt(0));
		int result = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int current = romanNumeralsMap.get(s.charAt(i));
			int next = romanNumeralsMap.get(s.charAt(i + 1));
			if (current < next) {
				result -= current;
			} else {
				result += current;
			}
			//System.out.println(s + "第" + i + "位计算:current=" + current + ",next=" + next + ",result=" + result);
		}
		return result + romanNumeralsMap.get(s.charAt(s.length() - 1));
	}
}
