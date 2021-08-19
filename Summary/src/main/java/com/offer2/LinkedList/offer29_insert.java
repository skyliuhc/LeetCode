package com.offer2.LinkedList;

/**
 * @author skyliuhc
 * @create 2021-08-17-10:42 上午
 */
public class offer29_insert {
    class Node {
        public int val;
        public Node next;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    public Node insert1(Node head, int insertVal) {
        Node curr = null;
        Node next = null;
        Node realHead = null;//真正的头节点
        if(head == null){//链表为空时
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        curr = head;
        next = head.next;
        //寻找真正的头节点
        while(curr.val <=next.val){
            curr = curr.next;
            next = next.next;
            if(curr == head){
                break;
            }
        }
        realHead = next;
        while (next.val <= insertVal){
            curr = next;
            next= next.next;
            if(next==realHead){
                break;
            }
        }

        //插入该节点
        curr.next= new Node(insertVal);
        curr= curr.next;
        curr.next = next;
        return head;
    }
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {//链表为空的时候
            node.next = node;
            return node;
        }
        Node cur = head;
        while (cur.val <= cur.next.val) {
            cur = cur.next;
            if (cur == head) {
                break;
            }
        }
        if (node.val <= cur.next.val || node.val >= cur.val) {
            node.next = cur.next;
            cur.next = node;
            return head;
        }
        cur = cur.next;
        while (node.val > cur.next.val) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        return head;
    }
}
