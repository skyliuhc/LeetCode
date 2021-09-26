package com.美团.立方;

/**
 * @author skyliuhc
 * @create 2021-09-25-4:16 下午
 */

import java.util.*;

public class Main {
    static int n, m;
    static boolean flag = false;
    static int target;
    static int sum = 0;
    static boolean[] vis  ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            vis = new boolean[n];
            m = sc.nextInt();
            int val = sc.nextInt();
            target = val;
            int[] nums = new int[n];
            sum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                sum += nums[i];
            }
            Arrays.sort(nums);
            if (check(nums, m, 0, sum)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }


    private static boolean check(int[] nums, int m, int val, int tempSum) {
        backtrack(nums, 0, 0, tempSum);
        return flag;
    }

    static void backtrack(int[] nums, int idx, int times, int tempSum) {
        if (tempSum == target) {
            flag = true;
            return;
        }
        if (flag) {
            return;
        }
        if (idx >= n) {
            return;
        }
        if (times == m) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (vis[i]||(i>0 && nums[i]==nums[i-1]) && !vis[i-1]){
                continue;
            }
            int temp = tempSum;
            int a = nums[idx];
            int idxSum = tempSum - a + a * a * a;
            vis[idx]=true;
            backtrack(nums, idx + 1, times + 1, idxSum);
            vis[idx]=false;
            backtrack(nums, idx + 1, times, temp);
        }

    }
}
// 1
// 4 3 37
// 1 1 2 3