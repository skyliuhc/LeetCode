package com.每日一题.mon_day_9_22_lc725;

/**
 * @author skyliuhc
 * @create 2021-09-22-10:09 上午
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n  = 0;
        ListNode temp = head;
        while(temp!=null){
            n++;
            temp = temp.next;//统计链表的长度
        }
        int quotient = n / k;
        int remainder = n % k;
        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for(int i=0;i<k && curr!=null;i++){
            parts[i] = curr;
            System.out.println("第"+i+"次循环"+">>"+"curr.val-->"+curr.val);
            int partSize = quotient + (i<remainder ? 1:0);
            System.out.println("第"+i+"次循环"+">>"+"partSize-->"+partSize);
            for(int j=1;j<partSize;j++){
                curr = curr.next;
                System.out.println("进来没");
            }
            ListNode next = curr.next;
            curr.next = null;//断开链表
            curr = next;
            System.out.println("#######################");
        }
        return parts;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        s.splitListToParts(head,5);
    }


}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }
    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
