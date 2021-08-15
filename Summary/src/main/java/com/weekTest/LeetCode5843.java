package com.weekTest;

/**
 * @author skyliuhc
 * @create 2021-08-15-3:05 下午
 */
public class LeetCode5843 {
    public int numOfStrings(String[] patterns, String word) {
        int res =0;
        for (String pattern : patterns) {
            if (word.contains(pattern)){
                res++;
            }
        }
        return res;
    }
}
