package com.gld;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-09-01-8:42 下午
 */
//广联达
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a=new int[n];
        int[] b = {1,2,3};
        for (int i = 0; i < m; i++) {
            HashSet<Integer> set = new HashSet<>();
            int start = b[i];
            for (int j = start-1; j < n; j++) {
                set.add(a[j]);
            }
            System.out.println(set.size());
        }
    }
}
