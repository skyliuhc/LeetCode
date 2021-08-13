package com.offer2.Integer;

import java.util.HashMap;

/**
 * @author skyliuhc
 * @create 2021-08-10-2:36 上午
 */
public class offer5_maxProduct {
    public static void main(String[] args) {
        System.out.println((int)'a');
        HashMap<Integer,Integer> map = new HashMap<>();
    }

    public int maxProduct(String[] words) {
        int len = words.length;
        int[] has = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                int loc = word.charAt(j) - 'a';
                has[i] = has[i] | (1 << loc);
            }
        } // 得到每个数字都有什么
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((has[i] & has[j]) == 0) { // 无重复
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }

}
