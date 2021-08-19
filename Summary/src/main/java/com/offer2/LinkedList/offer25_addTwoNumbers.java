package com.offer2.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author skyliuhc
 * @create 2021-08-16-2:34 下午
 */
public class offer25_addTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            //注意这里的判断条件有三个缺一不可，有进位的话得多创建一个
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur = cur % 10;
            ListNode curNode = new ListNode(cur);//头插法
            curNode.next = ans;
            ans = curNode;
        }
        return ans;
    }
}
