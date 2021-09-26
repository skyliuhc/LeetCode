package com.huawei.my;

/**
 * @author skyliuhc
 * @create 2021-08-25-6:42 下午
 */

// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

import java.util.*;

public class Main {
    static int[][] s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        s = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int q = 1; q <= m; q++) {
                        res = Math.max(res, getSum(i, j, k, q));
                    }
                }

            }
        }
    }

    static int getSum(int r1, int c1, int r2, int c2) {
        return s[r2][c2] - s[r1 - 1][c2] - s[r2][c1 - 1] + s[r1 - 1][c1 - 1];
    }

    static int getM(int[][] matrix) {
        //最大子序和-->最大和的连续子数组
        int N = matrix.length;
        int M = matrix[0].length;
        int[] b = new int[M];//纵向累加数组，记录当前i~j行组成大矩阵的每一列的和，将二维转化为一维
        int dp = 0;//小矩阵元素之和
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {//小矩阵的第一行
            for (int t = 0; t < M; t++) {
                b[t] = 0;//把累加数组重新初始化一下
            }//等价于b = new int[M]; 数组b表示matrix 的i~j行对应列元素的和
            //求最大子序列和
            for (int j = i; j < N; j++) {//小矩阵的最后一行
                dp = 0;
                for (int k = 0; k < M; k++) {//列值
                    b[k] += matrix[j][k];//纵向累加数组加一个数组
                    if (dp > 0) dp += b[k];
                    else dp = b[k];
                    //这里是dp[i]=max(dp[i-1]+nums[i],nums[i])
                    if (dp > maxSum) {//更新答案
                        maxSum = dp;
                    }
                }
            }
        }
        return maxSum;
    }


}
