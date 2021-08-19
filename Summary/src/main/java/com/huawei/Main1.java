package com.huawei;

import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-08-18-6:55 下午
 */
public class Main1 {

    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int N = sc.nextInt();
//        int[][] a = new int[N][3];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < 3; j++) {
//                a[i][j] = sc.nextInt();//价格，数量，喜爱度
//            }
//        }
//        int[][] b = new int[N][3];
//        for (int i = 0; i < b.length; i++) {
//            b[i][0] = a[i][2] / a[i][0];
//            b[i][1] = a[i][1];//数量
//            b[i][2] = i;//序号
//        }
//        Arrays.sort(b, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[0] - o1[0];
//            }
//        });//将单位元内喜爱程度排在前面
//        int res = 0;
//        for (int i = 0; i < N && x >= 0; i++) {//N种零食
//            for (int j = 0; j < b[i][1] && x >= 0; j++) {
//                x -= a[j][0];
//                res += a[j][2];
//            }
//        }
//        System.out.println(res);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int N = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();

            s[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        System.out.println(solver(N, V, s, v, w));
    }

    static int solver(int N, int V, int[] s, int[] v, int[] w) {
        int[] f = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= 0; j--) {
                for (int k = 1; k <= s[i] && k * v[i] <= j; k++) {
                    f[j] = Math.max(f[j], f[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return f[V];
    }


}
