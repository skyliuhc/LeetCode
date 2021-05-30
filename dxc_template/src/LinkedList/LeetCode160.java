package LinkedList;

public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode p = a;
        ListNode q = b;
        while (p != q) {
            if (p != null) {
                p = p.next;
            } else {
                p = b;
            }
            if (q != null) {
                q = q.next;
            } else {
                q = a;
            }
        }
        return p;
    }


}
