package com.offer2.String;

import java.util.Arrays;

/**
 * @author skyliuhc
 * @create 2021-08-13-11:03 上午
 */
public class offer14_checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = s1.length();
        if (s1.length() > s2.length()) {//如果s1的长度大于s2，那么s1一定不是s2的子串
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        //初始化滑动窗口
        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (check(cnt1, cnt2)) return true;
        while (right < s2.length()) {
            cnt2[s2.charAt(left) - 'a']--;//窗口往右边移动，左边被滑出
            cnt2[s2.charAt(right) - 'a']++;//窗口往右边移动，右边移进来一个
            if (check(cnt1, cnt2)) return true;
            left++;
            right++;
        }
        return false;
    }

    boolean check(int[] cnt1, int[] cnt2) {
        return Arrays.equals(cnt1, cnt2);
    }


}
