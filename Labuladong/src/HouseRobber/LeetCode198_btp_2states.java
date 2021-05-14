package HouseRobber;

public class LeetCode198_btp_2states {
    public int rob(int[] nums){
        int n =nums.length;
        //dp[i+1] dp[i+2]
        //状态转移只和dp[i]最近的两个状态有关
        int dp_i_1 =0, dp_i_2=0;
        int dp_i=0;
        for (int i = n-1; i >=0 ; i--) {
            dp_i=Math.max(dp_i_1,nums[i]+dp_i_2);
            dp_i_2=dp_i_1;
            dp_i_1=dp_i;
        }
        return  dp_i;
    }


}
