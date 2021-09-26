package com.tplink;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author skyliuhc
 * @create 2021-09-13-2:46 下午
 */
public class Main {

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        String s = ")((())))";
        int n = s.length();
        int ans = 0;
        stack.push(-1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if(chars[i]=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    ans = Math.max(ans,i-stack.peek());
                }
            }

        }
        System.out.println(ans);
    }
}
