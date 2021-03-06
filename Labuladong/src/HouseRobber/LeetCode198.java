package HouseRobber;

public class LeetCode198 {


    public int rob(int[] nums) {
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
        int res = Math.max(dp(nums, start + 1), nums[start]+dp(nums,start+2));
        return res;
    }

}
