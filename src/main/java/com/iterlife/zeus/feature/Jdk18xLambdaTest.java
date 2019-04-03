package com.iterlife.zeus.feature;

import java.util.Comparator;
import java.util.TreeSet;


public class Jdk18xLambdaTest {

    public static void main(String args[]) {
        testLambda();
    }


    public static void testLambda() {
        Comparator<Integer> cpt1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet treeSet1 = new TreeSet<>(cpt1);
        //Lambda写法
        Comparator<Integer> cpt2 = (x, y) -> Integer.compare(x, y);
        TreeSet treeSet2 = new TreeSet<>(cpt2);
    }
}
