package com.Lc刷题;

import java.util.Arrays;

/**
 * @author skyliuhc
 * @create 2021-09-29-2:31 下午
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);
    }
}
