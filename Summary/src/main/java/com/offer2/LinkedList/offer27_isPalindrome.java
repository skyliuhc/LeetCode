package com.offer2.LinkedList;

/**
 * @author skyliuhc
 * @create 2021-08-17-9:30 上午
 */
public class offer27_isPalindrome {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //判断链表长度为奇数还是偶数
        //如果是奇数的话，慢指针会走到中点 如链表1->2->3->4->5，会走到3
        if(fast!=null){
            slow = slow.next;
        }
        //下面是反转链表
        ListNode prev =  null;//反转后的头节点
        while(slow!=null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        //对两个链表进行逐一对比
        while(head!=null && prev!=null){
            if (head.val != prev.val) return false;
            head = head.next;
            prev=prev.next;
        }
        return true;
    }
}
