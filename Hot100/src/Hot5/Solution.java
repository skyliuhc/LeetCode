package Hot5;

public class Solution {
    //暴力解法
    public boolean isPalindromic(String s){
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i)!=s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+max; j <= len; j++) {
                //一定是i+max这样才能过
                // j是代表长度
                String test = s.substring(i,j);
                if (isPalindromic(test)&&test.length()>max){
                    ans = test;
                    max =test.length();
                }
            }
        }
        return ans;
    }

}
