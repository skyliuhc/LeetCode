package Labuladong.src.Dynamtic;

import java.util.Arrays;

public class LeetCode416_plus {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        //奇数无法换分
        if (sum%2!=0){
            return false;
        }
        sum=sum/2;
        int n = nums.length;
        boolean[] dp= new boolean[sum+1];
        //base case
        dp[0]=true;

        for (int i = 0; i <=n; i++) {
            for (int j = sum; j >=0 ; j--) {
                if(j-nums[i]>=0){
                    dp[j]=dp[j]||dp[j-nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
