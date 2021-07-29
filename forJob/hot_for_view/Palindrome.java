package forJob.hot_for_view;

/**
 * @author skyliuhc
 * @create 2021-07-07-9:40 下午
 */
public class Palindrome {

    //暴力解法
    public int getLongestPalindrome(String A, int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <=n ; j++) {
                String now = A.substring(i, j);
                if(check(now)){
                    ans=Math.max(ans,now.length());
                }

            }
        }
        return ans;

    }

    private boolean check(String now) {
        int n = now.length();
        for (int i = 0; i < n/2; i++) {
            if(now.charAt(i)!=now.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    public int getLongestPalindrome_dp(String A, int n){
        boolean[][] dp = new boolean[n][n];
        //dp[i][j]表示s[i..j]是否是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        char[] chars = A.toCharArray();
        for (int l =2; l <=n; l++) {//枚举子串长度
            for (int i = 0; i< n; i++) {//枚举左边界
                int j = i+l-1;//结束对位置
                if(j>=n){
                    break;
                }
                if(chars[i]!=chars[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] =dp[i+1][j-1] ;
                    }
                }
                if (dp[i][j] && l>maxLen){
                    maxLen=l;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "0123456";
        System.out.println(s.substring(0,3));
    }

}
