package com.netease.huyu;

import java.io.*;
import java.util.Arrays;

/**
 * @author skyliuhc
 * @create 2021-09-17-8:04 下午
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split(" ");
        int n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int k = Integer.parseInt(br.readLine());
        if (check( nums, k)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
        br.close();
    }
    static int N;
    static int K;
    static boolean check(int[] nums,int k){
        int n = nums.length;
        int sum = 0;
        int eachSum = 0;
        if(n==0 || k==0){
            return false;
        }
        N = n;
        K = k;
        int[] arr = new int[k];
        for (int num : nums) {
            sum+=num;
        }
        if (sum % k != 0) {
            return false;
        }
        eachSum = sum/k;
        Arrays.fill(arr,eachSum);
        Arrays.sort(nums);
        return helper(nums,n-1,arr);

    }

    private static boolean helper(int[] nums, int cur, int[] arr) {
        if (cur<0){
            return true;
        }
        int temp = nums[cur];
        for (int i = 0; i < K; i++) {
            if (arr[i]==temp || (cur>0 && arr[i]-temp>=nums[0])){
                arr[i]-=temp;
                if (helper(nums,cur-1,arr)){
                    return true;
                }
                arr[i] +=temp;
            }
        }
        return false;
    }
    static int Max = 1000000000+9;
    static int[] temp = new int[Max];
    public int findNthNumber (int n, int a, int b, int c) {
        int[] select = new int[3];
        select[0]=a;
        select[1]=b;
        select[2]=c;
        Arrays.sort(select);
        int i=0;
        while(i<Max){
            int t = i%3+1;
            temp[i]=select[i]*t;
            temp[i+1]=select[i+1]*t;
            temp[i+2]=select[i+2]*t;
        }
        return temp[n]%Max;
    }
}
