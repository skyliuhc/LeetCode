package com.offer2.back_track.offerII83;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-09-05-10:41 上午
 */
public class Solution {
    //没有重复元素集合的全排列
    int n;
    boolean[] st;
    List<Integer> path;
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        if (n == 0) {
            return res;
        }
        st = new boolean[n];
        path = new ArrayList<>();
        this.nums = nums;
        back_track(0);
        return res;
    }

    private void back_track(int u) {
        if (u == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!st[i]) {
                st[i] = true;
                path.add(nums[i]);
                back_track(u + 1);
                path.remove(path.size() - 1);
                st[i] = false;
            }
        }
    }
}
