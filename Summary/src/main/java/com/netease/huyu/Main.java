package com.netease.huyu;

import java.util.*;

public class Main {
    static int target;
    static int n;
    static List<Integer> path = new ArrayList<>();
    static int[] nums;
    static int path_sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < sum; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j + nums[i]] + nums[j], dp[i - 1][j - nums[i]] + nums[i]));
            }
        }
        System.out.println(dp[n][0]);
    }

}