package Hot32;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int longestValidParentheses(String s){
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);//初始时，保持统一，在栈中放入-1的元素
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                //遇到的每个 '('，把它的下标入栈
                stack.push(i);
            }else{
                stack.pop();
                //弹出元素表示匹配了当前右括号
                if (stack.isEmpty()){
                    //如果当前的右括号为没有被匹配的右括号，将其下标放入栈中更新「最后一个没有被匹配的右括号的下标」
                    stack.push(i);
                }else {
                    //如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                    maxans=Math.max(maxans,i-stack.peek());
                }
            }
        }
        return maxans;
    }
}
