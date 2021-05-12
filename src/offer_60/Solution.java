package offer_60;

import java.util.Arrays;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution {
    public double[] dicesProbability(int n){
        double[] dp = new double[6];
        Arrays.fill(dp,1.0/6.0);
        for (int i = 2; i <=n; i++) {
            //当有i个骰子时的点数之和的值数组先假定是temp
            double[] temp=new double[5*i+1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j+k]+=dp[j]*(1.0/6.0);
                }
            }
            dp=temp;
        }
        return dp;
    }
}
