package com.美团.旅行;

import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-09-25-4:56 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();//城市
            int m = sc.nextInt();//道路
            int k = sc.nextInt();//记录
            int[][] g = new int[n + 1][n + 1];
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                g[x][y] = 1;
                g[y][x] = 1;
            }
            int[] record = new int[k];
            for (int j = 0; j < k; j++) {
                record[j] = sc.nextInt();
            }
            boolean flag = true;
            for (int j = 1; j < k; j++) {
                if (!dfs(record[j - 1], record[j], g)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean dfs(int x, int y, int[][] map) {
        if (map[x][y] == 1) return true;
        else {
            boolean flag = false;
            for (int i = x; i < map.length; i++) {
                if (map[x][i] == 1) {
                    flag = flag || dfs(i, y, map);
                }
            }
            return flag;
        }
    }
}
