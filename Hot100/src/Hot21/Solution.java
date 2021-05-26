package Hot21;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            this.val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    //迭代解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l2 == null && l1 != null) {
            return l1;
        }
        //上面这些其实也可以不用写，但是效率会降低
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l2 != null && l1 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 > val2) {
                dummy.next = l2;
                l2 = l2.next;

            } else {
                dummy.next = l1;
                l1 = l1.next;
            }
            dummy = dummy.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                dummy.next = l2;
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        if (l2 == null) {
            while (l1 != null) {
                dummy.next = l1;
                l1 = l1.next;
                dummy = dummy.next;
            }
        }
        return head.next;
    }

}
