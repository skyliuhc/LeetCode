package Labuladong.src.Window;

import java.util.Arrays;

public class LeetCode567_arr {
//    由于排列不会改变字符串中每个字符的个数，
//    所以只有当两个字符串每个字符的个数均相等时，
//    一个字符串才是另一个字符串的排列。
    //判断字符相等
    public boolean checkInclusion(String s1,String s2){
        int n = s1.length(),m=s2.length();
        if(n>m){
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            ++cnt1[s1.charAt(i)-'a'];
            ++cnt2[s2.charAt(i)-'a'];
        }
        if(Arrays.equals(cnt1,cnt2)){
            return true;
        }
        for (int i = n;  i <m ; i++) {
            ++cnt2[s2.charAt(i)-'a'];
            --cnt2[s2.charAt(i-n)-'a'];
            if(Arrays.equals(cnt1,cnt2)){
                return true;
            }
        }
        return false;
    }



}
