package com.netease;

import java.util.Arrays;


public class Solution {

    public int minSailCost(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i <m ; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int value = 10000;
                if (nums[i][j] == 0) {
                    value = 2;
                } else if (nums[i][j] == 1) {
                    value = 1;
                }
                if(i==0){
                    dp[i][j] = dp[i][j-1] + value;
                }else if(j==0){
                    dp[i][j] = dp[i-1][j] + value;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+value;
                }
            }
        }
        if(dp[m-1][n-1]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[m-1][n-1];
    }
}