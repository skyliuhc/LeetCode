package HouseRobber;

public class LeetCode213 {

    public int rob(int[] nums) {
        //房子排成一个圈
        //手尾 两个房间 存在三种情况:
        //1.都不被抢 可以忽略，肯定亏
        //2.首被抢 尾不被抢
        //3.首不抢 尾被抢
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        return Math.max(robRange(nums,0,n-2),robRange(nums,1,n-1));
        
    }

    private int robRange(int[] nums, int start, int end) {
        int n =nums.length;
        //dp[i+1] dp[i+2]
        int dp_i_1 =0,dp_i_2=0;
        int dp_i = 0;
        for (int j = end; j >=start ; j--) {
            dp_i=Math.max(dp_i_1,nums[j]+dp_i_2);
            dp_i_2=dp_i_1;
            dp_i_1=dp_i;
        }
        return dp_i;
    }

}
