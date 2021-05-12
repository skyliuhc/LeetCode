package Share;

import java.util.Arrays;

public class LeetCode188 {
    int[][] memo ;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        memo=new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i],-1);
        }
        return dp(0,k,prices);
    }
    int dp(int start,int k,int[] prices){
        if(start>=prices.length){
            return 0;
        }
        if(k==0){
            return 0;
        }
        if(memo[start][k]!=-1){
            return memo[start][k];
        }
        int curMin =prices[start];
        int res =0;
        for (int sell = start; sell < prices.length; sell++) {
            curMin=Math.min(curMin,prices[sell]);
            res=Math.max(dp(sell+1,k-1,prices)+prices[sell]-curMin,res);
        }
        memo[start][k]=res;
        return res;
    }

    public static void main(String[] args) {
        int[][] test = new int[3][2];
        for (int i = 0; i < test.length; i++) {
            Arrays.fill(test[i],-1);
        }

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                System.out.print(test[i][j]);
            }
        }
    }

}
