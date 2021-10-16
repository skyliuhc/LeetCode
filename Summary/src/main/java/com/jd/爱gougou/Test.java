package com.jd.爱gougou;

/**
 * @author skyliuhc
 * @create 2021-10-13-7:14 下午
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(get(9));
    }
    public  static int get(int n){
        if (n<=2){
            return n;
        }
        return get(n-1)+get(n-2)+1;
    }
}
