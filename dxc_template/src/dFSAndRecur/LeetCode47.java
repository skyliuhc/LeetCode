package dFSAndRecur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;

    }

    private void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
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
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;

            perm.remove(idx);

        }
    }

    public static void main(String[] args) {
//        System.out.println(-3%3);
//        int num = 10;
//        System.out.println("num = " + num);
//        String[] arr ={"cnm","nmsl","fuck"};
//        for (int i = 0; i < arr.length; i++) {
//            String s = arr[i];
//        }
//        ArrayList<Object> list = new ArrayList<>();
//        list.add(123);
//        list.add(456);
//        list.add(789);
    }
}
