package Share;

public class LeetCode121 {
    //在第202个测试用例的时候超过时间限制
    //这种思路相当于固定了买入的时间，然后将buy后面的每一天作为sell进行穷举找最高的售价
//    public int maxProfit(int[] prices){
//        int res=0;
//        for (int buy = 0; buy < prices.length; buy++) {
//            for (int sell = buy+1; sell <prices.length ; sell++) {
//                res=Math.max(res,prices[sell]-prices[buy]);
//            }
//        }
//        return res;
//    }
    //
    //固定卖出时间sell，向前穷举买入时间buy，寻找成本最小的那天
    public int maxProfit(int[] prices){
        int res =0;
        int curMin = prices[0];
        for (int sell = 1; sell < prices.length; sell++) {
            curMin=Math.min(curMin,prices[sell]);
            res=Math.max(res,prices[sell]-curMin);
        }
        return res;
    }


}
