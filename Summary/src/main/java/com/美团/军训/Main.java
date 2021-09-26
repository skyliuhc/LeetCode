package com.美团.军训;

import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-09-25-5:02 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n个人
        int m = sc.nextInt();//m组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[][] dp = new int[n][m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            dp[i][1] = max - min;
        }
        for (int k = 1; k < m; k++) {
            for (int i = k; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int temp = 0;
                    int maxx = Integer.MIN_VALUE;
                    int minn = Integer.MAX_VALUE;
                    for (int z = j + 1; z < j; z++) {
                        maxx = Math.max(maxx, nums[z]);
                        minn = Math.min(minn, nums[z]);
                        temp = maxx - minn;
                    }
                    dp[i][k] = Math.max(dp[j][k - 1], temp);
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
