package com.offer2.String;

/**
 * @author skyliuhc
 * @create 2021-08-14-10:28 上午
 */
public class offer18_isPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {//判断是否是数字和字母
                sb.append(Character.toLowerCase(c));//转换成小写
            }
        }
        String str = sb.toString();
        return check(str);
    }

    //for循环
    boolean check(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }
        return true;
    }

    //用StringBuider，反转字符串再比较
    boolean check(StringBuilder sb) {
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        return s1.equals(s2);
    }

    //双指针
    boolean check1(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    boolean check(String s,int low, int high) {
        for (int i=low,j=high;i<j;i++,j--){
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public boolean isPalindrome_DoublePointer(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < r && !(Character.isLetterOrDigit(s.charAt(l)))) {
                ++l;
            }
            while (l < r && !(Character.isLetterOrDigit(s.charAt(r)))) {
                --r;
            }
            if (l < r) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                    return false;
                ++l;
                --r;
            }
        }
        return true;
    }

}
