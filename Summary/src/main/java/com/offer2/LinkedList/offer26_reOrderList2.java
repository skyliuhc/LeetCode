package com.offer2.LinkedList;

/**
 * @author skyliuhc
 * @create 2021-08-16-3:21 下午
 */
public class offer26_reOrderList2 {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //找到链表的中点
    public ListNode getMiddle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }


//    1 -> 2 -> 3 -> 4 -> 5 -> 6
//    第一步，将链表平均分成两半
//        1 -> 2 -> 3
//        4 -> 5 -> 6
//
//    第二步，将第二个链表逆序
//        1 -> 2 -> 3
//        6 -> 5 -> 4
//
//    第三步，依次连接两个链表
//       1 -> 6 -> 2 -> 5 -> 3 -> 4
    //合并链表
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_t;
        ListNode l2_t;
        while (l1 != null && l2 != null) {
            l1_t = l1.next;
            l2_t = l2.next;

            l1.next = l2;
            l1 = l1_t;

            l2.next = l1;
            l2 = l2_t;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;//主要要对两个指针都要更新
            curr = t;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = getMiddle(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

   


}
