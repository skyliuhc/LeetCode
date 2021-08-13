package com.lhc.String;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author skyliuhc
 * @create 2021-08-08-9:04 下午
 */
public class LC_20_isValid {
//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) return false;//奇数不适合
        Map<Character, Character> paris = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (paris.containsKey(c)) {//如果遇到的是右括号
                if (stack.isEmpty() || stack.peek() != paris.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
