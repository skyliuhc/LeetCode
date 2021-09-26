package com.weekTest;

/**
 * @author skyliuhc
 * @create 2021-08-21-11:03 下午
 */
public class LeetCode5835 {
    //acwing 3763 分奇数偶数讨论
    public long maxMatrixSum(int[][] matrix) {
        long res =0;
        int t=0;
        int min=Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]<0) t++;
                min=Math.min(min,Math.abs(matrix[i][j]));
                res+=Math.abs(matrix[i][j]);
            }
        }
        if(t%2!=0){
            res-=2*min;
        }
        return res;
    }
}
