package com.sf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-08-30-6:38 下午
 */

public class Main {

    static int dir;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] uva = new int[m][3];
        int[][] pow = new int[n + 1][n + 1];
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                uva[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            pow[uva[i][0]][uva[i][1]] = uva[i][2];
            pow[uva[i][1]][uva[i][0]] = uva[i][2];
            int e1 = uva[i][0];
            int e2 = uva[i][1];
            list[e1].add(e2);
            list[e2].add(e1);
        }
        int[][] start_end = new int[q][2];
        for (int i = 0; i < q; i++) {
            start_end[i][0] = sc.nextInt();//开始
            start_end[i][1] = sc.nextInt();//终点
        }
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int q1 = start_end[i][0];
            int q2 = start_end[i][1];

            dir = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            boolean[] vis = new boolean[n + 1];
            vis[q1] = true;
            dfs(list, pow, q1, q2, 0, Integer.MIN_VALUE, vis);
            if (max == Integer.MIN_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(max);
            }

        }


    }


    static void dfs(List<Integer>[] list, int[][] pow, int start, int end, int tempdir, int tempmax, boolean[] vis) {
        if (start == end) {
            if (tempdir < dir) {
                dir = tempdir;
                max = Math.max(max, tempmax);
            } else if (tempdir == dir) {
                max = Math.max(max, tempmax);
            }
            return;
        }
        if (tempdir >= dir) {
            return;
        }
        for (Integer integer : list[start]) {
            if (!vis[integer]) {
                vis[integer] = true;
                dfs(list, pow, integer, end, tempdir + 1, Math.max(tempmax, pow[start][integer]), vis);
                vis[integer] = false;
            }
        }
    }


}