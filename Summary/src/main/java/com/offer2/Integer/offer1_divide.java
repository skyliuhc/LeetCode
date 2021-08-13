package com.offer2.Integer;

/**
 * @author skyliuhc
 * @create 2021-08-09-10:54 下午
 */
public class offer1_divide {
    public int divide(int dividend, int divisor) {
        //特殊情况-2^31/-1 会溢出
        if(dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //记录负数的个数，并将两数都转为负数
        int negative = 2;
        if(dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if(divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        //两个负数的除法
        int result = divideCore(dividend,divisor);
        //根据负号对商进行符号的修改
        return negative == 1 ? -result : result;
    }
    private int divideCore(int dividend, int divisor) {
        int result = 0;
        //注意是两个负数的比较大小
        while(dividend <= divisor){
            //value用来存储除数翻倍后的值
            int value = divisor;
            //quotient用来存储除数翻的倍数
            int quotient = 1;
            //除数每次从1倍开始翻倍。直到-2^31的一半-2^30
            while(value >= 0xc0000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            //倍数累加为商
            result += quotient;
            //被除数减去这部分除数翻倍后的值
            dividend -= value;
        }
        return result;
    }
}
