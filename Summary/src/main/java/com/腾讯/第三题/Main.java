package com.腾讯.第三题;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author skyliuhc
 * @create 2021-09-26-8:42 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> pMap = new HashMap<>();
        pMap.put('+', 1);
        pMap.put('x', 2);
        pMap.put('@', 3);
        pMap.put('(', -1);
        Stack<Character> ops = new Stack<>();
        Stack<Long> nums = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = chs.length;
        for (int i = 0; i < n; i++) {
            char c = chs[i];
            if (Character.isDigit(c)) {
                sb.append(c);
                int j = i + 1;
                while (j < n && Character.isDigit(chs[j])) sb.append(chs[j++]);
                long anInt = Long.parseLong(sb.toString());
                nums.push(anInt);
                sb.delete(0, sb.length());
                i = j - 1;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') eval(ops, nums);
                ops.pop();
            } else {
                while (!ops.isEmpty() && (pMap.get(ops.peek()) >= pMap.get(c))) {
                    eval(ops, nums);
                }
                ops.push(c);
            }

        }
        while (!ops.isEmpty()) {
            eval(ops, nums);
        }
        System.out.println(nums.peek());
    }

    public static void eval(Stack<Character> ops, Stack<Long> nums) {
        long nums1 = nums.pop();
        long nums2 = nums.pop();//第一个进栈的元素
        char op = ops.pop();
        if (op == '+') nums.push(nums1 + nums2);
        else if (op == 'x') {
            nums.push(nums2 * nums1);
        } else if (op == '@') {
            long temp = nums2 | (nums1 + nums2);
            nums.push(temp);
        }

    }
}
