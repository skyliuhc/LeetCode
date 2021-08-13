package com.acwing.offer_week1;

import java.util.ArrayList;

/**
 * @author skyliuhc
 * @create 2021-08-10-3:49 下午
 */
public class offer17_printListReversingly {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int[] printListReversingly(ListNode head) {
            if (head == null) {
                return new int[0];
            }
            int n = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            n = list.size();
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = list.get(n - i - 1);
            }
            return res;
        }
    }
}
