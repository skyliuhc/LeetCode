package offer_63;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int currMin=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<currMin){
                currMin=prices[i];
            }
            if(prices[i]-currMin>maxProfit){
                maxProfit=prices[i]-currMin;
            }
        }
        return maxProfit;
    }

}
