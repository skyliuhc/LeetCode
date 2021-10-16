package com.腾讯.第一题;
import java.util.*;
/**
 * @author skyliuhc
 * @create 2021-09-26-8:19 下午
 */
public class Main{
    static int N = 1000010;
    static int[] primes = new int[N];
    static int cnt;
    static boolean st[] = new boolean[N];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        get_primes(1000000);
        TreeSet<Integer> set  = new TreeSet<>();
        for (int i = 0; i < cnt; i++) {
            set.add(primes[i]);
        }
        for(int i=0;i<T;i++){
            int temp = sc.nextInt();
            int temp1 = set.ceiling(1+temp);
            int temp2 = set.ceiling(temp1+temp);
            System.out.println(temp1*temp2);
        }

    }
    static void get_primes(int n){
        for(int i=2;i<=n;i++){
            if(!st[i]) primes[cnt++]=i;
            for(int j=0;primes[j]<=n/i;j++){
                st[primes[j]*i]=true;
                if(i%primes[j]==0) break;
            }
        }
    }
}