package com.honor.h828;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-08-28-7:50 下午
 */
public class Solution1 {
    //ac
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean[] st = new boolean[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (!st[i]) {
                prev = nums[i];
                st[i] = true;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(prev);
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] < prev && !st[j]) {
                        tmp.add(nums[j]);
                        prev = nums[j];
                        st[j] = true;
                    }
                }
                res.add(tmp);
            }
        }
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            List<Integer> ti = res.get(i);
            for (int j = 0; j < ti.size()-1; j++) {
                System.out.print(ti.get(j)+",");
            }
            System.out.print(ti.get(ti.size()-1));
            System.out.println();
        }
    }
}
