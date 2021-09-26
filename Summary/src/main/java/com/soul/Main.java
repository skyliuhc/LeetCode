package com.soul;
/**
 * @author skyliuhc
 * @create 2021-08-26-9:11 下午
 */

import java.util.Scanner;

public class Main {
//    迷失的括号序列
    //贪心
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);
        System.out.println(MissingBrackets(str));
    }


    public static String MissingBrackets(String brackets) {
        int a = 0;
        char[] chars = brackets.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if(chars[i]=='(') a++;//统计左括号的数量
        }
        int ans = n/2- a;//在合法的字符中左括号的数量和右括号的数量一致
        for (int i = 0; i < n; i++) {
            if(chars[i]=='?'){
                if(ans>0){
                    chars[i] = '(';
                }else{
                    chars[i] = ')';
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(chars[i]=='(') sum++;
            if(chars[i]==')') sum--;
        }
        String s = new String(chars);
        if (sum==0) return s;
        else return "Impossible";
    }

}
