package com.weekTest;

/**
 * @author skyliuhc
 * @create 2021-08-21-10:33 下午
 */
public class LeetCode5834 {
    //转盘
    public static int minTimeToType(String word) {
        char pre = 'a';
        int res =0;
        for (int i = 0; i <word.length() ; i++) {
            if(pre==word.charAt(i)){
                res++;//移动到指针
            }else{
                int need = word.charAt(i)-'a'+1;
                int now1 = pre-'a'+1;
                res+=Math.min(Math.abs(need-now1),26-Math.abs(need-now1));
                pre=word.charAt(i);
                res++;//键入
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToType("abc"));
    }
}
