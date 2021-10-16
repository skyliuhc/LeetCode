package com.jd.工厂老张;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-10-09-7:58 下午
 */
public class Main {
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        int key = -1;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > max) {
//                key = entry.getKey();
//                max=entry.getValue();
//            }
//        }
//        int l = 0, r = n-1;
//        while (l < n && nums[l] != key) l++;
//        while (r > 0 && nums[r] != key) r--;
//        l++;r++;
//        System.out.println(l+" "+r);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] cnt = new int[10000 + 10];
        int max = 0;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int key = -1;
        for (int i = 0; i < n; i++) {
            if (cnt[nums[i]] > max) {
                max = cnt[nums[i]];
                key = nums[i];
            }
        }
        int l = 0, r = n - 1;
        while (l < n && nums[l] != key) l++;
        while (r > 0 && nums[r] != key) r--;
        l++;
        r++;
        System.out.println(l + " " + r);
    }
}