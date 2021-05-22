public class Hot5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2){
            return s;
        }
        int maxLen=1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        // dp[i][j]表示s[i..j]是否是回文串
        for (int i = 0; i <=len; i++) {
                dp[i][i]=true;
        }
        char[] charArray = s.toCharArray();
        //开始递归
        //先枚举子串长度
        for (int L = 2; L <=len ; L++) {
            for (int i = 0; i < len; i++) {
                //i 是左边界
                int j= L+i-1;
                // j是右边界
                if(j>=len){
                    //越界就退出循环
                    break;
                }
                if(charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else{
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if(j-i<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                //L=j-i+1
                if(dp[i][j]&&L>maxLen){
                    maxLen=L;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
