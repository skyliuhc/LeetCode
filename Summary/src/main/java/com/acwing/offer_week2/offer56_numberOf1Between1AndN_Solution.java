package com.acwing.offer_week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-08-13-10:30 上午
 */
public class offer56_numberOf1Between1AndN_Solution {

    public int numberOf1Between1AndN_Solution(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }
        Collections.reverse(nums);
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int l = 0, r = 0;
            int t = 1;
            for (int j = 0; j < i; j++) {
                l = l * 10 + nums.get(j);
            }
            for (int j = i + 1; j < nums.size(); j++) {
                r = r * 10 + nums.get(j);
                t *= 10;
            }
            res += l * t;
            if (nums.get(i) == 1) res += r + 1;
            else if (nums.get(i) > 1) res += t;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 12345;
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        //list此时是5，4，3，2，1
        Collections.reverse(list);
        list.forEach(System.out::println);
    }
}
