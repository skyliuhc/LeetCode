package com.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = str.length;
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i]= Integer.parseInt(str[i]);
        }
        int m = br.read()-'0';
        int res = 0;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            int l =i;
            int r = n-1;
            while(r>0 && a[l]+a[r]>m) r--;
            if(l<r){
                res+=(r-l);
            }

        }
        System.out.println(res);
        br.close();
    }
}


//import java.io.*;
//import java.util.*;
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//        int n = str.length;
//        int[] a = new int[n];
//        for (int i = 0; i < a.length; i++) {
//            a[i]= Integer.parseInt(str[i]);
//        }
//        int m = br.read()-'0';
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if(a[i]+a[j]<m){
//                    res++;
//                }
//            }
//        }
//        System.out.println(res);
//        br.close();
//    }
//}