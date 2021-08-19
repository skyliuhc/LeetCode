package com.offer2.LinkedList;

/**
 * @author skyliuhc
 * @create 2021-08-17-10:23 上午
 */
public class offer28_flatten {

    class Node{
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    private Node node;
    public Node flatten(Node head) {
        if(head == null) {
            return null;
        }
        if(node != null) {//区别第一次调用
            node.next = head;
            head.prev = node;
            node.child = null;
        }
        node = head;
        //开始遍历child时（比如3, 7)，next会被改变，所以用nextNode保存一下
        Node nextNode = head.next;
        flatten(head.child);
        flatten(nextNode);
        return head;
    }
}
