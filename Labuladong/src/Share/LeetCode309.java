package Labuladong.src.Share;

import java.util.Arrays;

public class LeetCode309 {

    int[] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo=new int[n];
        Arrays.fill(memo,-1);
        return dp(0,prices);
    }
    int dp(int start,int[] prices){
        if(start>=prices.length){
            return 0;
        }
        if (memo[start]!=-1){
            return memo[start];
        }
        int res =0;
        int curMin = prices[start];
        for (int sell = start+1; sell <prices.length ; sell++) {
            curMin=Math.min(curMin,prices[sell]);
            res=Math.max(res,dp(sell +2,prices)+prices[sell]-curMin);
            //sell+1变成sell+2
        }
        memo[start]=res;
        return res;
    }


}
