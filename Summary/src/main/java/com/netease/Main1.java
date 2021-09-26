package com.netease;

import java.io.*;


public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = str.length;
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }

        br.close();
        System.out.println(solve(a));
    }

    static int solve(int[] r){
        int n = r.length;
        int[] left = new int[n];
        for (int i = 0; i <n ; i++) {
            if(i>0 && r[i]>r[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i]=1;
            }
        }
        int right =0,ret=0;
        for (int i = n - 1; i >= 0; i--) {
            if(i<n-1 && r[i]>r[i+1]){
                right++;
            }else{
                right=1;
            }
            ret += Math.max(left[i],right);
        }
        return ret;
    }
}
