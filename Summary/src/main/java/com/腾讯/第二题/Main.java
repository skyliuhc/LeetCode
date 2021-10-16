package com.腾讯.第二题;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-09-26-8:31 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i]=sc.nextInt();
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i]=dfs(nums,i,0);
            }

            Arrays.sort(res);
            System.out.println(res[n-1]);
        }
    }

    public static int dfs(int[] arr,int start,int score){
        if(start<0|| start>=arr.length) return score;
        return dfs(arr,start+arr[start],score+arr[start]);
    }
}
