package com.ali.second;

import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-09-24-7:17 下午
 */

public class Main{
    static int N = 10000+10;
    static int[][] d = new int[N][N];
    static int n, m;
    static int s;
    static int t;
    static int max = 0x3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//城市的个数
        m = sc.nextInt();//道路的个数
        int[] w = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i == j) d[i][j] = 0;
                else d[i][j] = max;
            }
        }
        for (int i = 0; i < n; i++) w[i] = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = sc.nextInt();
        int T = m;

        while (T-- > 0) {
            int x = sc.nextInt();//u-->v
            int y = sc.nextInt();
            int z = sc.nextInt();
            d[x][y] = Math.min(d[x][y], z);
            d[y][x] = d[x][y];
        }
        floyd();
        s = sc.nextInt();
        t = sc.nextInt();
        int dist = d[s][t];
        if (dist>max/2){
            System.out.println(-1);
        }else{
            System.out.println(dist);
        }

    }

    static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}