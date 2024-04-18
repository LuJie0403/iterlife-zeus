package com.iterlife.zeus.demo.jdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc：List 引用测试
 * @date：2019-07-05 17:50
 * @author：lujie
 */
public class ListObject {

    public static void main(String[] args) {
        testIntegerReference();
    }


    private static void testIntegerReference() {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        System.out.println(list1.size() + " " + list2.size());
        list1.add(new Integer(2));
        System.out.println(list1.size() + " " + list2.size());
        list2.add(list1.get(0));
        System.out.println(list1.size() + " " + list2.size());
        list2.clear();
        System.out.println(list1.size() + " " + list2.size());
    }

    private static void testMapReference() {
        HashMap<String, Integer> testMap = new HashMap<String, Integer>();
        testMap.put("1", 1);
        testMap.put("2", 1);
        List<Map<String, Integer>> list1 = new ArrayList();
        List<Map<String, Integer>> list2 = new ArrayList();
        System.out.println(list1.size() + " " + list2.size());
        list1.add(testMap);
        System.out.println(list1.size() + " " + list2.size());
        list2.add(list1.get(0));
        System.out.println(list1.size() + " " + list2.size());
        list2.clear();
        System.out.println(list1.size() + " " + list2.size());
    }
}
