package HouseRobber;

public class LeetCode198_bottom_to_up {

    public int rob(int[] nums) {
        int n = nums.length;
        //dp[i] = x表示 从第i间房子开始抢劫，最多能抢到的钱为x
        //base case: dp[n] = 0
        int[] dp = new int[n + 2];
        //n+2是为了更新公式的统一
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }


}
