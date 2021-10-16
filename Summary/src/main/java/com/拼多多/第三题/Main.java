package com.拼多多.第三题;

import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-10-11-8:16 下午
 * 2
 * 3
 * ?
 * 18
 * 1?
 * 2
 * ??
 * ?
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            String[] str = new String[n];
            int curMax = 0;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                str[i]=sc.next();
               if (!str[i].contains("?")){
                   int cur = Integer.parseInt(str[i]);
                   if (curMax<cur){
                       curMax=Math.max(cur,curMax);
                   }else{
                       flag = false;
                       break;
                   }
               }else {

               }
            }
        }
    }
}
