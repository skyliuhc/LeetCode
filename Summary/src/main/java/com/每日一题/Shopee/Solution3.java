package com.每日一题.Shopee;

import java.util.concurrent.Executors;

/**
 * @author skyliuhc
 * @create 2021-09-22-4:47 下午
 */
public class Solution3 {

    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        int[] weights = {4, 2, 3, 1};
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(3);
        Executors.newCachedThreadPool();
        System.out.println(Solve(n, m, weights));
    }

    public static long Solve(int n, int m, int[] weights) {
        int times = n / m;//有几个区间
        long max = 0;
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + weights[i - 1];
        }
        for (int i = 0; i < m - 1; i++) {
            long temp = s[times * (i + 1)] - s[times * i];
            max = Math.max(max, temp);
        }
        long temp = s[m] - s[times * (m - 1)];
        max = Math.max(max, temp);
        return max;
    }


    public long Solve_other(int n, int m, int[] weights) {
        // write code here
        int max = -1;
        long sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > max) {
                max = weights[i];
            }
            sum += weights[i];
        }
        long start = Math.max(max, sum / m);//二分最小容量
        long end = sum;
        long mid = (start + end) / 2;
        while (start < end) {
            mid = (start + end) / 2;
            if (canHave(m, n, weights, mid)) {
                end = mid;
            } else {
                start = mid + 1;
                mid = mid + 1;
            }
        }
        return mid;
    }

    private boolean canHave(int m, int n, int[] weights, long k) {
        int leftNum = m - 1;
        long leftWeight = k;
        for (int j = 0; j < weights.length; j++) {
            if (leftWeight >= weights[j]) {
                leftWeight -= weights[j];
            } else {
                leftNum--;
                leftWeight = k;//容量复位
                leftWeight -= weights[j];
            }
        }
        if (leftNum >= 0) {
            return true;
        }
        return false;

    }

}
