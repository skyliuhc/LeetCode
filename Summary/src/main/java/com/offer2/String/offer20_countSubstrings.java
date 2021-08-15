package com.offer2.String;

/**
 * @author skyliuhc
 * @create 2021-08-14-4:18 下午
 */
public class offer20_countSubstrings {
    //动态规划
    //转移方程解释
    //当有一个字符时，必然时回文串
    //当有两个字符时，如果是相等当，也是一个回文串
    //当有三个以及三个以上的字符时，如果两边的字符相等的话，则取决于dp[i+1][j-1])的符号
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }


    boolean check(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (2 * nums[i] == nums[i - 1] + nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
