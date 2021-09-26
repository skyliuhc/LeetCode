package com.honor.zxl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author skyliuhc
 * @create 2021-09-14-7:55 下午
 */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split(" ");
        int base = countNum(str[0]);
        int min = Integer.MAX_VALUE;
        String ss = " ";
        for(int i=1;i<str.length;i++){
            int temp = countNum(str[i]);
            if(Math.abs(base-temp)<min){
                min = Math.abs(base-temp);
                ss=str[i];
            }
        }
        System.out.println(ss);
    }
    public static int countNum(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            count+=(str.toUpperCase().charAt(i)-'A');
        }
        return count;
    }
}