package com.ali;

import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-09-24-7:08 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int bCnt = 0;
        int flag = 0;//0表示red
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i]=='B' && flag==0){
                flag = 1;
            }
            if(chars[i]=='R' && flag==1){
                flag=0;
                bCnt++;
            }
        }
        int rCnt = 0;
        flag = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i]=='R' && flag==0){
                flag=1;
            }
            if (chars[i]=='B' && flag==1){
                flag=0;
                rCnt++;
            }
        }
        if (chars[n-1]=='R'){
            rCnt++;
        }else {
            bCnt++;
        }
        int res = Math.min(rCnt,bCnt)+1;
        System.out.println(res);
    }
}
