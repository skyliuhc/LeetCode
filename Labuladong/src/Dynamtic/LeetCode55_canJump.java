package Labuladong.src.Dynamtic;

/**
 * @author skyliuhc
 * @create 2021-07-06-8:20 上午
 */
public class LeetCode55_canJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && nums[j]+j>=i){//是否可以到达i点
                    dp[i]= true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}
