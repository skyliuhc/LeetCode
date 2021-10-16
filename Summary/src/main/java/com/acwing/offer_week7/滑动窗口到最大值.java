package com.acwing.offer_week7;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author skyliuhc
 * @create 2021-10-08-7:54 下午
 */
public class 滑动窗口到最大值 {
    public int[] maxInWindows(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> q = new LinkedList<>();//这个队是单调下降的，队头就是最大的元素(存的是下标)
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (q.size()>0 && q.peekFirst()<=i-k) q.pollFirst();//判断是否需要出队
            while (q.size()>0 && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.add(i);
            if (i>=k-1){//i=k-1窗口就开始取最大值
                res[idx++]=nums[q.peekFirst()];
            }
        }
        return res;
    }
}
