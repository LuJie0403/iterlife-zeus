package com.iterlife.zeus.leetcode;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Lu Jie
 * @desc https://leetcode-cn.com/problems/lfu-cache/
 * @date 2021-05-06 15:59:00
 * @tags 最不经常使用算法 LRU
 */
public class LFUCache {
    public static void main(String[] args) throws InterruptedException {
        LFUCache cache = new LFUCache(3);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5, 5);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);
    }

    private final Cache cache;

    public LFUCache(int capacity) {
        this.cache = new Cache(capacity);
    }

    public int get(int key) {
        Node node = cache.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }
        this.cache.info("get(" + key + ")");
        return node.getValue();
    }

    public Object put(int key, int value) {
        Node node = new Node(key, value, 1);
        this.cache.putIfAbsent(node);
        this.cache.info("put(" + key + "," + value + ")");
        return null;
    }

}

class Cache {

    private final HashMap<String, Node> cacheMap;
    private final int capacity;

    public Cache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
    }

    public void info(String prefixMsg) {
        System.out.print(prefixMsg + " : ");
        for (String key : cacheMap.keySet()) {
            System.out.print(cacheMap.get(key).toString() + " ");
        }
        System.out.println();
    }

    public Node getOrDefault(int key, Node defaultNode) {
        String refKey = String.valueOf(key);
        if (cacheMap.isEmpty()) {
            return defaultNode;
        }
        Node node = cacheMap.get(refKey);
        if (node != null) {
            putIfAbsent(node);
        }
        return node != null ? node : defaultNode;
    }

    private Node find(int key) {
        String refKey = String.valueOf(key);
        if (cacheMap.isEmpty()) {
            return null;
        }
        Node node = cacheMap.get(refKey);
        return node;
    }

    public void putIfAbsent(Node node) {
        Node tNode = find(node.getKey());
        if (cacheMap.isEmpty() && capacity == 0) {
            return;
        }
        if (tNode != null) {
            cacheMap.remove(String.valueOf(node.getKey()));
            putIfAbsent(new Node(tNode.getKey(), node.getValue(), tNode.getUsedCnt().addAndGet(1)));
            return;
        }

        if (cacheMap.size() < capacity) {
            cacheMap.put(String.valueOf(node.getKey()), node);
            return;
        }

        //倒叙排列
        Optional<Node> unUsedNode = cacheMap.values().stream().sorted((o1, o2) -> {
            if (o1.getUsedCnt().get() < o2.getUsedCnt().get()) {
                return -1;
            }
            if (o1.getUsedCnt().get() > o2.getUsedCnt().get()) {
                return 1;
            }
            if (o1.getUsedCnt().get() == o2.getUsedCnt().get()) {
                if (o1.getUsedTime().get() <= o2.getUsedTime().get()) {
                    return -1;
                }
                if (o1.getUsedTime().get() > o2.getUsedTime().get()) {
                    return 1;
                }
                if (o1.getUsedTime().get() == o2.getUsedTime().get()) {
                    return 0;
                }
                return 0;
            }
            return 0;
        }).findFirst();
        if (unUsedNode.isPresent()) {
            cacheMap.remove(String.valueOf(unUsedNode.get().getKey()));
            cacheMap.put(String.valueOf(node.getKey()), node);
        }
    }
}

class Node {
    private int key;
    private int value;
    private AtomicInteger usedCnt;
    private AtomicLong usedTime;

    public Node(int key, int value, int usedCnt) {
        this.key = key;
        this.value = value;
        this.usedCnt = new AtomicInteger(usedCnt);
        this.usedTime = new AtomicLong(System.nanoTime());
    }

    public Node update() {
        this.usedCnt = new AtomicInteger(this.usedCnt.addAndGet(1));
        this.usedTime = new AtomicLong(System.nanoTime());
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                ", usedCnt=" + usedCnt +
                ", usedTime=" + usedTime +
                '}';
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AtomicInteger getUsedCnt() {
        return usedCnt;
    }

    public void setUsedCnt(AtomicInteger usedCnt) {
        this.usedCnt = usedCnt;
    }

    public AtomicLong getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(AtomicLong usedTime) {
        this.usedTime = usedTime;
    }

}