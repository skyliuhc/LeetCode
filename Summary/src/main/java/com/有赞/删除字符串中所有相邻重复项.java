package com.有赞;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author skyliuhc
 * @create 2021-10-16-4:06 下午
 */
public class 删除字符串中所有相邻重复项 {
    public static void main(String[] args) {

    }
    public String removeDuplicates(String s) {
        char[] cs = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for(char c: cs){
            if(!stack.isEmpty() && stack.peekLast().equals(c)){
                stack.pollLast();
            }else {
                stack.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
