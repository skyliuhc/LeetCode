package Labuladong.src.Share;

public class LeetCode123 {

        public  int maxProfit(int[] prices){
            int n = prices.length;
            int[][] dp = new int[n][5];
            //五个状态
            // 0 没有操作
            // 1 第一次买入
            // 2 第一次卖出
            // 3 第二次买入
            // 4 第二次卖出
            dp[0][1] = - prices[0];//第0天做一次买入操作
            dp[0][3] = - prices[0];//第0天第二次买入
            for (int i = 1; i <n ; i++) {
                dp[i][1] =Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
                dp[i][2] =Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
                dp[i][3] =Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
                dp[i][4] =Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
            }
            return dp[n-1][4];
        }


}
