package LeetCode1449_largestNumber;

public class Solution {

    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target+1];
        dp[0]="";
        for(int i=1; i<=target; i++){
            dp[i]="0";//无法得到整数的时候
            for(int j=8; j>=0; j--){
                if(i-cost[j]<0 || "0".equals(dp[i-cost[j]])) continue;
                //添加一个数位
                dp[i]=strMax(dp[i], (j+1)+dp[i-cost[j]]);
            }
        }
        return dp[target];
    }
    String strMax(String s1, String s2){
        if(s1.length()==s2.length()){
            return s1.compareTo(s2)>0?s1:s2;
        }else{
            return s1.length()>s2.length()?s1:s2;
        }
    }
}
