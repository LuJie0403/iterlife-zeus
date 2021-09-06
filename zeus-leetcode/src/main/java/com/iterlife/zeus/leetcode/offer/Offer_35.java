package com.iterlife.zeus.leetcode.offer;

/**
 * @desc: https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * @desc: https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/4 20:53
 **/
public class Offer_35 {
}

class Offer_35_Solution {
    /**
     * Definition for a Node.
     **/
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 原地处理，将克隆结点放在原结点后面，在原链表上处理克隆结点的random指针，最后分离两个链表
     * 空间复杂度O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node pNode = head;
        //将复制的新节点加入到当前节点的后置位置，节点总数翻倍,变为两倍
        while (pNode != null) {
            //复制的新节点
            Node cNode = new Node(pNode.val);
            Node nNode = pNode.next;
            cNode.next = nNode;
            pNode.next = cNode;
            pNode = nNode;
        }
        //处理 random 指针问题
        pNode = head;
        while (pNode != null) {
            pNode.next.random = (pNode.random == null ? null : pNode.random.next);
            pNode = pNode.next.next;
        }
        pNode = head;
        Node cHead = head.next;
        while (pNode.next != null) {
            Node tNode = pNode.next;
            pNode.next = pNode.next.next;
            pNode = tNode;
        }
        return cHead;
    }
}
