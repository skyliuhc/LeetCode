package LinkedList;

public class LeetCode24 {
    // 两两旋转链表

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode p = dummy; p.next != null && p.next.next != null; ) {
            ListNode a = p.next;
            ListNode b = a.next;
            p.next = b;
            a.next = b.next;
            b.next=a;
            p = a;
        }
        return dummy.next;
    }


}
