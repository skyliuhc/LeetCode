package com.每日一题.Shopee;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author skyliuhc
 * @create 2021-09-22-4:21 下午
 */
public class Solution2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(9);
        System.out.println(minEffort(list));
    }
    public static int minEffort(ArrayList<Integer> cases) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < cases.size(); i++) {
            q.offer(cases.get(i));
        }
        int all=0;
        while (q.size()>=2){
            int res = 0;
            res+=q.poll()+q.poll();
            all+=res;
            q.offer(res);
        }

        return all;
    }
    public long Solve(int n, int m, int[] weights) {
        int times = n/m;//有几个区间
        long max = 0;
        long[] s = new long[n+1];
        for (int i = 1; i <=n ; i++) {
            s[i]=s[i-1]+weights[i-1];
        }
        for (int i = 0; i < m; i++) {
            long temp = s[times*(i+1)]-s[times*i];
            max=Math.max(max,temp);
        }
        return max;
    }
}
