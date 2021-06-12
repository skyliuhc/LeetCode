package dFSAndRecur;

import java.util.*;

public class LeetCode90 {


    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> t = new ArrayList<Integer>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);//前提是要排序
        dfs( nums,0);
        return ans;
    }

    private void dfs(int[] nums, int u) {
        if(u==nums.length){
            ans.add(new ArrayList<>(t));
            return;
        }
        int k =0;//当前数字对个数
        while (u+k<nums.length && nums[u+k]==nums[u]) k++;
        for (int i = 0; i <= k; i++) {
            dfs(nums,u+k);//第一不选
            t.add(nums[u]);//选一个。。。。选k个
        }
        for (int i = 0; i <=k; i++) {
            t.remove(t.size()-1);
        }
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));//默认就是{}
            return;
        }
        dfs(false, cur + 1, nums);
        //如果说不选前一个数的话，就提前返回
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }
}
