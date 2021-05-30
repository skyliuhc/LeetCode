package LinkedList;

public class LeetCode92 {

    //    反转链表 II
//    输入：head = [1,2,3,4,5], left = 2, right = 4
//    输出：[1,4,3,2,5]
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode d = dummy;
        //确定节点位置
        for (int i = 0; i < m-1; i++) {
            a=a.next;
        }
        for (int i =0;i<n;i++){
            d=d.next;
        }
        ListNode b= a.next;
        ListNode c= d.next;
        for (ListNode p=b,q=b.next;q!=c;){
            ListNode o = q.next;
            q.next=p;
            p=q;
            q=o;
        }
        b.next=c;
        a.next=d;
        return dummy.next;
    }

}
