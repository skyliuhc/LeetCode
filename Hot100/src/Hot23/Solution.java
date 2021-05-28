package Hot23;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
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
    //暴力求解
    //时间复杂度O(NlogN) 空间复杂度 O(N)
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> temList = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            traverse(list,temList);
        }
        Integer[] temp = temList.toArray(new Integer[temList.size()]);
        Arrays.sort(temp);
        ListNode dummy = new ListNode(-1);
        ListNode head =dummy;
        for (int i = 0; i < temp.length; i++) {
            head.next=new ListNode(temp[i]);
            head=head.next;
        }
        return dummy.next;

    }
    void traverse(ListNode head,List list){
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b){
        if (a==null||b==null){
            return a!=null?a:b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr =a,bPtr = b;
        while (aPtr!=null &&bPtr!=null){
            if (aPtr.val<bPtr.val){
                tail.next =aPtr;
                aPtr=aPtr.next;
            }else{
                tail.next=bPtr;
                bPtr=bPtr.next;
            }
            tail=tail.next;
        }
        tail.next =(aPtr!=null?aPtr:bPtr);
        return head.next;
    }
    //两两合并，效率比暴力还低
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode ans =null;
        for (int i = 0; i < lists.length; i++) {
            ans=mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ans =null;
        for (int i = 0; i < lists.length; i++) {
            ans=mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }

    public ListNode mergeKLists3(ListNode[] lists){
        PriorityQueue<ListNode> q = new PriorityQueue<>((x,y)->x.val-y.val);
        for (ListNode node : lists) {
            if (node!=null){
                q.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!q.isEmpty()){
            tail.next = q.poll();
            tail=tail.next;
            if (tail.next!=null){
                q.add(tail.next);
            }
        }
        return head.next;
    }

}
