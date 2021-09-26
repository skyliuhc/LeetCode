package com.sf.Mondy95;

import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-09-06-8:12 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i]=sc.nextInt();
            if(check(nums[i])){
                res++;
            }
        }
        System.out.println(res);
    }

    static boolean check(int n){
        String s = String.valueOf(n);
        int len = s.length();
        String temp = generate(len);
        while (n>0){
            n-=Integer.parseInt(temp);
            s = String.valueOf(n);
            len = s.length();
            temp = generate(len);
        }
        if(n<0){
            return false;
        }else {
            return  true;
        }
    }
    static String generate(int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("1");
        }
        return sb.toString();
    }
}
