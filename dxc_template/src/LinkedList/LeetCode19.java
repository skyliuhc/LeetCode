package LinkedList;

public class LeetCode19 {
    //    删除链表的倒数第 N 个结点

    public ListNode removeNthFromEnd(ListNode head, int n) {
//        删除链表的倒数第 N 个结点
        int len = getLen(head);
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode cur = dummy;//用dummy来做就不会空指针
        for (int i = 1; i < len-n+1; i++) {
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return dummy.next;
    }


    public int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
