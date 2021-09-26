package com.redbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author skyliuhc
 * @create 2021-09-04-9:57 上午
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(split[i*n+j]);
            }
        }
        System.out.println(getM(matrix));
        br.close();
    }

    static int getM(int[][] matrix){
        int N =  matrix.length;
        int M = matrix[0].length;
        int[] b = new int[M];
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int t =0;t<M;t++){
                b[t] = 0;
            }

            for(int j = i;j<N;j++){
                sum = 0;
                for(int k =0;k<M;k++){
                    b[k]+=matrix[j][k];
                    if(sum>0) sum+=b[k];
                    else  sum = b[k];
                    if(sum>maxSum){
                        maxSum = sum;
                    }
                }
            }
        }
        return maxSum;
    }
}
