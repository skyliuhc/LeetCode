package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author skyliuhc
 * @create 2021-08-11-7:02 下午
 */
//class seg {
//    int l;
//    int r;
//
//    public seg(int l, int r) {
//        this.l = l;
//        this.r = r;
//    }
//}

public class Main {

    //    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String strs = in.readLine();
//        System.out.println(strs);
//        int len = strs.length();
//        String sub1 = strs.substring(1, strs.length() - 1);//求掉首尾的括号
//        System.out.println(sub1);
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            char c =sub1.charAt(i);
//            StringBuilder sb = new StringBuilder();
//            while (c>='0' && c<='9'){
//                sb.append(c);
//                c =strs.charAt(++i);
//            }
//            String value = sb.toString();
//            int t = Integer.parseInt(value);
//            list.add(t);
//        }
//
//        System.out.println(list);
//        int size = list.size() / 2;
//        int[][] arr = new int[size][2];
//        for (int i = 0; i < size; i++) {
//            int a = Integer.parseInt(String.valueOf(list.get(2* i)));
//            int b = Integer.parseInt(String.valueOf(list.get(i * 2 + 1)));
//            arr[i][0] = Math.min(a,b);
//            arr[i][1] = Math.max(a,b);
//        }
//        System.out.println(maxW(arr));
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String strs = in.readLine();
        int len = strs.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (strs.charAt(i) != '[' && strs.charAt(i) != ']' && strs.charAt(i) != ' '){
                sb.append(strs.charAt(i));
            }
        }
        String[] split = sb.toString().split(",");
        int size = split.length / 2;
        int[][] arr = new int[size][2];
        for (int i = 0; i < size; i++) {
            int a = Integer.parseInt(split[2 * i]);
            int b = Integer.parseInt(split[2 * i + 1]);
            arr[i][0] = Math.min(a,b);
            arr[i][1] = Math.max(a,b);
        }
        System.out.println(maxW(arr));
    }


    public static int maxW(int[][] array) {
        if (array.length == 0) {
            return 0;
        }
        int n = array.length;
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e1[1] - e2[1];
                }
            }
        });
        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (array[j][1] <= array[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}


