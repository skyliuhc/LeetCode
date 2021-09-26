package com.mi;

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 3;
        int[] num = new int[n];
        int p = n;
        int index = 0;
        int cnt = 0;
        while(p>1){
            if(num[index]==0){
                cnt++;
                if(cnt==m){
                    num[index]=1;
                    cnt = 0;
                    p--;
                }
            }
            index ++;
            if(index == num.length){
                index =0;
            }
        }
        for(int i=0;i<num.length;i++){
            if(num[i]==0){
                System.out.println(i+1);
            }
        }
    }
}