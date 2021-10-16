package com.携程.第一题;

/**
 * @author skyliuhc
 * @create 2021-09-30-7:23 下午
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int target;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        LinkedList<Integer> path = new LinkedList<>();
        back_track(nums, path);
        for (List<Integer> re : res) {
            for (int i = 0; i < re.size(); i++) {
                System.out.print(re.get(i) + " ");
            }
        }
    }

    static List<List<Integer>> res = new ArrayList<>();

    private static void back_track(int[] nums, LinkedList<Integer> path) {
        if (res.size() >= 1) {
            return;
        }
        if (path.size() == nums.length) {
            int cnt = 0;
            for (int i = 0; i < path.size(); i++) {
                if (gcd(i + 1, path.get(i)) == 1) {
                    cnt++;
                }
            }
            if (cnt == target) {
                res.add(new ArrayList<>(path));
            } else {
                return;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            back_track(nums, path);
            path.removeLast();
        }
    }

    public static int gcd(int num1, int num2) {
        while (num1 > 0) {
            int temp = num2 % num1;
            num2 = num1;
            num1 = temp;
        }
        return num2;
    }
}