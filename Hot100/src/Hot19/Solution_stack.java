package Hot19;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_stack {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int x){
            this.val = x;
        }
        ListNode(int x, ListNode next){
            this.val = x;
            this.next = next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy = new ListNode(0,head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre =stack.peek();
        pre.next=pre.next.next;
        return dummy.next;
    }

}
