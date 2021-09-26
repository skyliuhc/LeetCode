package com.redbook.second;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author skyliuhc
 * @create 2021-09-19-11:17 上午
 */
public class Test {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    public static void main(String[] args) {
        String s = new String("nb");
        System.out.println(s instanceof String);
        Long l = 3L;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(4>>1);
        Deque<Integer> stack = new LinkedList<>();
        System.out.println(CAPACITY);//536870911
        System.out.println(3/5);
        System.out.println('a'-'A');
    }
}
