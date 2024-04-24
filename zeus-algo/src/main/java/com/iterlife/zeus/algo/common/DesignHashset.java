package com.iterlife.zeus.algo.common;

/**
 * @desc:https://leetcode.cn/problems/design-hashset/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2024/4/24 19:11
 **/
public class DesignHashset {
    public static void main(String... args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // 返回 True
        myHashSet.contains(3); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // 返回 True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // 返回 False ，（已移除）
    }
}

class MyHashSet {

    private byte[] set = null;

    public MyHashSet() {
        set = new byte[1000001];
    }

    public void add(int key) {
        set[key] = 1;
    }

    public void remove(int key) {
        set[key] = 0;
    }

    public boolean contains(int key) {
        return set[key] == 1;
    }
}



