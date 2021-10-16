package com.携程.第三题;

/**
 * @author skyliuhc
 * @create 2021-09-30-8:15 下午
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        String s = sc.next();
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        int[] ans = new int[n];
        while (m-- > 0) {
            ans=change(nums);
            for (int i = 0; i < nums.length; i++) {
                nums[i]=ans[i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
        }
    }

    static int[] change(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if (nums[0] == nums[1]) {
            res[0] = 0;
        } else {
            res[0] = 1;
        }
        if (nums[n - 2] == nums[n - 1]) {
            res[n - 1] = 0;
        } else {
            res[n - 1] = 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] == nums[i + 1]) {
                res[i] = 0;
            } else {
                res[i] = 1;
            }
        }
        return res;
    }
}