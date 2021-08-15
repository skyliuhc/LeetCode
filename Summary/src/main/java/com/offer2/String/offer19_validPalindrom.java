package com.offer2.String;

/**
 * @author skyliuhc
 * @create 2021-08-14-11:17 上午
 */
public class offer19_validPalindrom {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return check(s, l + 1, r) || check(s, l, r - 1);
            }
        }
        return true;
    }

    private boolean check(String s, int l, int r) {
        for (int i = l, j = r; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
