package com.拼多多.第二题;

/**
 * @author skyliuhc
 * @create 2021-10-11-7:46 下午
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        char[] chars = s.toCharArray();

        int cnta = 0;
        int cntb = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'a') {
                cnta++;
            } else {
                cntb++;
            }
        }
        if(n<2){
            System.out.println(s);
        }else if(n==2 ){
            if (s.equals("aa")){
                System.out.println("aa");
            }else if (s.equals("bb")){
                System.out.println("bb");
            }else {
                System.out.println(s);
            }
        }


    }
}
