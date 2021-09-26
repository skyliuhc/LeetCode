package com.offer2.back_track.offerII84;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-09-05-11:11 上午
 */
public class Solution {
    boolean[] vis;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> perm = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(0);
        return ans;
    }

    private void backtrack(int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                //如果该数字被访问过，跳过继续下一个数字
                //如果该数字没有被访问，但是上一个和它相同的数字也没有被访问，则也跳过继续下一个数字
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(idx + 1);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
