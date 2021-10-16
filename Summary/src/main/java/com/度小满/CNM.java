package com.度小满;

/**
 * @author skyliuhc
 * @create 2021-09-26-4:01 下午
 */
public class CNM {
    public static void main(String[] args) {
        String s = "08:00-09:00";
        String[] split = s.split("-");
        for (String s1 : split) {
            System.out.println(s1);
            System.out.println(s1.substring(0, 2));
            System.out.println(s1.substring(3));
        }
    }
}
