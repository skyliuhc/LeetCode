package com.acwing.offer_week2;

/**
 * @author skyliuhc
 * @create 2021-08-16-11:15 上午
 */
public class offer26_NumberOf1 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(3));
    }
    public static int NumberOf1(int n)
    {
        return Integer.bitCount(n);
    }
}
