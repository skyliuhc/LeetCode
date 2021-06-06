package String;

public class LeetCode5 {
    //最长回文子序列
    public String longestPalindrome(String s) {
        String res="";
        //枚举中心点
        for(int i=0;i<s.length();i++){
            //当这个子串是奇数的时候
            for(int j=i,k=i;j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k);j--,k++){
                if(res.length()<k-j+1){
                    res=s.substring(j,k+1);
                    //substring是全小写的
                }
            }
            //当这个子串是偶数的时候
            for(int j=i,k=i+1;j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k);j--,k++){
                if(res.length()<k-j+1){
                    res=s.substring(j,k+1);
                }
            }
        }
        return res;
    }
}
