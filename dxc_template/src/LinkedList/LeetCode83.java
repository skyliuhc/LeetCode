package LinkedList;

public class LeetCode83 {


//    删除排序链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next=head;
            while (head!=null){
                //第一种情况
                //当前节点和下一个节点的val相同
                if(head.next!=null&&head.val== head.next.val){
                    head.next=head.next.next;
                }else{
                    head=head.next;
                }
            }
            return dummy.next;
    }
}
