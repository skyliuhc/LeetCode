package com.exam;

/**
 * @author skyliuhc
 * @create 2021-08-20-12:19 上午
 */
public class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += k * 2) {
            reverse(arr, i, Math.min(i + k, n) - 1);//数组的下标是从0开始取的
        }
        return new String(arr);
    }

    public static void reverse(char[] arr, int l, int r) {
//        将arr数组里的[l,r]进行翻转
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdef";
        char[] chars = s.toCharArray();

        reverse(chars, 0, 5);
        System.out.println(new String(chars));
    }

    public String reverseStr2(String s, int k) {
        int n = s.length();
        if (k >= n) {
            StringBuilder sb = new StringBuilder(s);
            StringBuilder reverse = sb.reverse();
            String s1 = reverse.toString();
            return s1;
        }
        String res = "";
        String sub = "";
        for (int i = 0; i < n; i += 2 * k) {
            if (n <= i + k) {
                sub = s.substring(i, n);
                StringBuilder sb = new StringBuilder(sub);
                StringBuilder reverse = sb.reverse();
                String s1 = reverse.toString();
                res += s1;
            } else if (n <= i + 2 * k) {
                String substring = s.substring(i, i + k);
                StringBuilder sb = new StringBuilder(substring);
                StringBuilder reverse = sb.reverse();
                String s1 = reverse.toString();
                res += s1;
                res += s.substring(i + k, n);
            } else {
                String substring = s.substring(i, i + k);
                StringBuilder sb = new StringBuilder(substring);
                StringBuilder reverse = sb.reverse();
                String s1 = reverse.toString();
                res += s1;
                res += s.substring(i + k, i + 2 * k);
            }
        }
        return res;
    }
}
