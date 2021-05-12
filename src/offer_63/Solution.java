package offer_63;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int n=prices.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j <n ; j++) {
                int temp=prices[j]-prices[i];
                if(temp>maxProfit){
                    maxProfit=temp;
                }
            }
        }
        return maxProfit;
    }


}
