/**
 *
 * @project zeus
 * @file lang.algorithm.BigDataSortAlgo.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 *
 **/
package lang.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @desc Java 中 Integer取值范围
 *       [-2147483648,2147483647]，如测试手机号码，最多只能取后面9位进行测试，所以测试必须分组(桶)进行，手机号码作为索引，索引值不超过int最大值。
 * @author Lu Jie
 * @date 2019 2019年3月23日 上午11:24:28
 * @tags
 */
public class BigDataSortAlgo {
	static int capacity = 1000000000 >> 3;
	static byte[][] sortArea = new byte[10][capacity];
	static List<String> phoneSheet = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		// 输入原始数据
		iutput();

		// 排序
		for (String telNo : phoneSheet) {
			sort(telNo);
		}

		// 输出原始数据
		for (int i = 0; i < 10; ++i) {
			output(i);
		}

	}

	public static void sort(String telNo) {
		// 解析手机号码
		int groupId = -1;
		int phoneId = -1;
		// 分组
		if (telNo == null || telNo.length() != 11) {
			return;
		}
		groupId = new Integer(telNo.substring(1, 2));
		phoneId = new Integer(telNo.substring(2, 11));
		if (groupId < 0 || phoneId < 0) {
			return;
		}
		// 位点标记法排序
		int index = phoneId >>> 3;
		int offset = phoneId % 8;
		sortArea[groupId][index] |= (0b1 << offset);
		// 输出排序结果
		System.out.println(telNo + " [" + groupId + " " + index + " "
				+ sortArea[groupId][index] + "]");
	}

	public static void iutput() throws IOException {

		String filename = "phone_input.txt";
		FileReader readFile = null;
		BufferedReader reader = null;
		String lineReader;
		try {
			readFile = new FileReader(filename);
			reader = new BufferedReader(readFile);
			while ((lineReader = reader.readLine()) != null) {
				phoneSheet.add(lineReader);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (readFile != null) {
				readFile.close();
			}
		}

	}
	public static void output(int i) throws IOException {
		String filename = new StringBuffer("phoneoutput-1").append(i)
				.append(".txt").toString();
		File file = null;
		FileWriter writeFile = null;
		BufferedWriter out = null;
		try {
			file = new File(filename);
			file.createNewFile();
			writeFile = new FileWriter(file);
			out = new BufferedWriter(writeFile);
			for (int j = 0; j < capacity; ++j) {
				// 原来的比特存储取值如果小0，说明byte存储有溢出
				int offset = (sortArea[i][j] < 0)
						? (offset = (sortArea[i][j]) + 256)
						: sortArea[i][j];
				for (int k = 0; k < 8; ++k) {
					if (offset % 2 == 1) {
						String phoneNo = new StringBuffer("1").append(i)
								.append(String.format("%09d", (j << 3) + k))
								.append("\r\n").toString();
						out.write(phoneNo);
						out.flush(); // 把缓存区内容压入文件
					}
					offset >>>= 1;
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}
}
