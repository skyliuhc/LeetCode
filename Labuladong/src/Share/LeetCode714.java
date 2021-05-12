package Share;

public class LeetCode714 {

    public  int maxProfit(int[] prices,int fee){
        int n =prices.length;
        int buy = prices[0]+fee;
        int profit = 0;
        for (int i = 0; i < n; i++) {
            if(prices[i]+fee<buy){
                buy =prices[i]+fee;
            }else if(prices[i]>buy){
                profit+=prices[i]-buy;
                buy=prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int test;
    }

}
