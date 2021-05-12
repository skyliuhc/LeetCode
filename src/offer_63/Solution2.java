package offer_63;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution2 {
    public int maxProfit(int[] prices){
        int cost= Integer.MAX_VALUE,profit=0;
        for(int price:prices){
            cost=Math.min(cost,price);
            profit=Math.max(profit,price-cost);
        }
        return profit;
    }

}
