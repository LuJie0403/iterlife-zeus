package com.iterlife.zeus.algo;

import java.util.*;

/**
 * @desc: 集合覆盖算法：给定一个包含所有元素的宇宙集合和一组子集合，算法会找出最小的子集合组合，使得它们的并集包含了所有元素。
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2024/5/11 18:04
 **/

public class SetCoverAlgo {

    public static List<String> setCover(Set<Integer> universe, Map<String, Set<Integer>> sets) {
        List<String> result = new ArrayList<>();
        Set<Integer> elements = new HashSet<>(universe);

        while (!elements.isEmpty()) {
            String bestSet = null;
            int bestSetSize = 0;

            for (String key : sets.keySet()) {
                Set<Integer> intersection = new HashSet<>(elements);
                    intersection.retainAll(sets.get(key));

                if (intersection.size() > bestSetSize) {
                    bestSet = key;
                    bestSetSize = intersection.size();
                }
            }

            if (bestSet != null) {
                result.add(bestSet);
                elements.removeAll(sets.get(bestSet));
            }
        }

        return result;
    }

    public static String genRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Set<Integer> universe = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        Map<String, Set<Integer>> subSets = new HashMap<>();
        subSets.put(genRandomString(4), new HashSet<>(Arrays.asList(1, 2, 3)));
        subSets.put(genRandomString(4), new HashSet<>(Arrays.asList(2, 4)));
        subSets.put(genRandomString(4), new HashSet<>(Arrays.asList(4, 5)));
        subSets.put(genRandomString(4), new HashSet<>(Arrays.asList(6, 5)));
        subSets.put(genRandomString(4), new HashSet<>(Arrays.asList(5, 4, 6)));

        System.out.println("Main set:" + universe);
        System.out.println("Sub set:");
        for (String key : subSets.keySet()) {
            System.out.println("        " + key + ":" + Arrays.asList(subSets.get(key)));
        }

        List<String> result = setCover(universe, subSets);
        System.out.println("Minimum set cover: " + result);
    }

}
