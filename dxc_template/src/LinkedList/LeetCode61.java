package LinkedList;

public class LeetCode61 {
    //选择链表
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int n =0;
        //求链表的长度
        for (ListNode p = head; p!=null ; p=p.next) {
            n++;
        }
        k%=n;//先取余
        ListNode first = head,second = head;
        while (k-->0){
            first=first.next;
        }
        //将快指针移动到最后一个元素
        //此时慢指针的下一个元素就是倒数第k个元素
        while (first.next!=null){
            first=first.next;
            second=second.next;
        }
        first.next = head;
        head = second.next;
        second.next=null;
        return head;
    }
}
