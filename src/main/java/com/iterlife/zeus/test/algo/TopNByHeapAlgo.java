package com.iterlife.zeus.test.algo;

import java.util.Iterator;
import java.util.Scanner;

import com.iterlife.zeus.test.service.impl.FixedSizeBigHeap;
import com.iterlife.zeus.test.service.impl.FixedSizeSmallHeap;
/**
 *
 * @desc Top N算法
 * @author Lu Jie
 * @date 2019 2019年3月23日 上午11:24:28
 * @tags
 */
public class TopNByHeapAlgo {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		FixedSizeSmallHeap<Integer> sHeap = new FixedSizeSmallHeap<Integer>(n);
		FixedSizeBigHeap<Integer> bHeap = new FixedSizeBigHeap<Integer>(n);
		while (sc.hasNext()) {
			String data = sc.next();
			if ("quit".equals(data)) {
				break;
			}
			sHeap.add(Integer.valueOf(data));
			bHeap.add(Integer.valueOf(data));
			for (Integer sInt : new Iterable<Integer>() {

				@Override
				public Iterator<Integer> iterator() {
					return sHeap.getBody().iterator();
				}
			}) {
				System.out.print("-" + sInt);
			}
			System.out.println("");
			for (Integer bInt : new Iterable<Integer>() {

				@Override
				public Iterator<Integer> iterator() {
					return bHeap.getBody().iterator();
				}
			}) {
				System.out.print("-" + bInt);
			}
			System.out.println("");
		}
		sc.close();
		System.out.println(sHeap.list());
		System.out.println(bHeap.list());

	}
}
