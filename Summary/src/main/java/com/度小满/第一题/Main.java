package com.度小满.第一题;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-09-26-4:13 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        int i = 0;
        int temp = 0;
        while (list.size() > 1) {
            temp++;
            if (temp % 2 == 0) {
                i = (i + b - 1) % n;
            } else {
                i = (i + a - 1) % n;
            }
            list.remove(i);
            n--;
        }
        System.out.println(list.get(0));

    }
}
