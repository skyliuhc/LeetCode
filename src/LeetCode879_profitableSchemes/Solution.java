package LeetCode879_profitableSchemes;

public class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length,MOD= (int)1e9+7;
        int[][][] dp = new int[len+1][n+1][minProfit+1];
        //dp[i][j][k] 表示在前i个工作中选择了j个员工，并且满足工作利润至少为k的情况下的盈利
        dp[0][0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int members = group[i-1],earn = profit[i-1];
            for (int j = 0; j <=n ; j++) {
                for (int k = 0; k <=minProfit; k++) {
                    if(j<members){
                        dp[i][j][k] = dp[i-1][j][k];
                    }else{
                        dp[i][j][k] = (dp[i-1][j][k]+dp[i-1][j-members][Math.max(0,k-earn)])%MOD;
                    }
                }
            }
        }
        int sum =0;
        for (int i = 0; i <=n; i++) {
            sum=(sum+dp[len][i][minProfit])%MOD;
        }
        return sum;
    }
}
