package LinkedList;

public class LeetCode206 {
    //反转链表
//    输入：head = [1,2,3,4,5]
//    输出：[5,4,3,2,1]
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head.next;
        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        head.next = null;
        return a;
    }
}
