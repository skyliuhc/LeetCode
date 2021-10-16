package com.度小满;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-09-26-3:49 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int T = m+n;
        int[][] events = new int[m+n][2];
        String s = sc.nextLine();
        for (int i = 0; i < T; i++) {
            s = sc.nextLine();
            String[] split = s.split("-");

            int sh = Integer.parseInt(split[0].substring(0,2));
            int sm = Integer.parseInt(split[0].substring(3));
            int eh = Integer.parseInt(split[1].substring(0,2));
            int em = Integer.parseInt(split[1].substring(3));
            events[i][0]=sh*60+sm;
            events[i][1]=eh*60+em;
        }
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int res = 0;
        int start =events[0][0];
        int end = events[0][1];
        res++;
        for (int i = 1; i < events.length; i++) {
            int ts = events[i][0];
            int te = events[i][1];
            if(ts>=end){
                res++;
                end = te;
            }
        }
        System.out.println(res);
    }
}