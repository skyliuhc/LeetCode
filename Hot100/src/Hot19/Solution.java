package Hot19;

public class Solution {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int x){
            this.val = x;
        }
        ListNode(int x,ListNode next){
            this.val = x;
            this.next = next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //创建一个哑节点
        ListNode dummy = new ListNode(0,head);
        int len=0;
        while (head!=null){
            head=head.next;
            len++;
        }
        head=dummy;
        for (int i = 0; i < len-n; i++) {
            head=head.next;
        }
        head.next=head.next.next;
        return dummy.next;
    }

}
