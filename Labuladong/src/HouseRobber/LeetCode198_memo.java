package HouseRobber;

import java.util.Arrays;

public class LeetCode198_memo {
    private int[] memo;
    public int rob(int[] nums) {
        //初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        //强盗从第0间房子开始抢劫
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        //在start位置上存在两个选择
        //1 不抢，去下一家
        //2 抢，去下下家
        //存在重叠子问题，leetcode运行超时

        //避免重复计算
        if(memo[start]!=-1){
            return memo[start];
        }
        int res = Math.max(dp(nums, start + 1), nums[start]+dp(nums,start+2));
        //记入备忘录
        memo[start]=res;
        return res;
    }
}
