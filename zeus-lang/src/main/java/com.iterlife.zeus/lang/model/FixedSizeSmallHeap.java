package com.iterlife.zeus.lang.model;

import java.util.*;

/**
 * @desc 小顶堆
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class FixedSizeSmallHeap<E extends Comparable> {
    private int capacity;
    private PriorityQueue<E> body;

    public FixedSizeSmallHeap(int maxSize) {
        this.capacity = maxSize;
        this.body = new PriorityQueue<E>(maxSize, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.compareTo(o2);
            }

        });
    }

    public void add(E e) {
        if (body.size() < capacity) {
            body.add(e);
            System.out.println("S:" + list());
            return;
        }
        E data = body.peek();
        if (e.compareTo(data) > 0) {
            body.poll();
            body.add(e);
        }
        System.out.println("S:" + list());
    }

    public int size() {
        return body.size();
    }

    public List<E> list() {
        List<E> heapList = new ArrayList<E>(body);
        Collections.sort((List<E>) heapList);
        return heapList;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public PriorityQueue<E> getBody() {
        return body;
    }

    public void setBody(PriorityQueue<E> body) {
        this.body = body;
    }
}
