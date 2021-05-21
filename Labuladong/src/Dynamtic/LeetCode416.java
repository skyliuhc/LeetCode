package Labuladong.src.Dynamtic;

import java.util.Arrays;

public class LeetCode416 {
    //  分割等和子集   canPartition
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        //奇数无法换分
        if (sum%2!=0){
            return false;
        }
        sum=sum/2;
        int n = nums.length;
        boolean[][] dp= new boolean[n+1][sum+1];
        //base case
        for (int i = 0; i <=n; i++) {
            dp[i][0] =true;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=sum ; j++) {
                    if(j-nums[i-1]<0){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j] =dp[i-1][j] |dp[i-1][j-nums[i-1]];
                    }
            }
        }
    return dp[n][sum];
    }

}
