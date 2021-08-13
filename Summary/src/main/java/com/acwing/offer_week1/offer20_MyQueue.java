package com.acwing.offer_week1;

import java.util.Stack;

/**
 * @author skyliuhc
 * @create 2021-08-10-5:40 下午
 */
public class offer20_MyQueue {
    class MyQueue {

        /** Initialize your data structure here. */
        Stack<Integer> s1 ;
        Stack<Integer> cache ;
        public MyQueue() {
            s1 = new Stack<>();
            cache = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!s1.isEmpty()){
                cache.push(s1.pop());
            }
            int  x = cache.pop();
            while (!cache.isEmpty()){
                s1.push(cache.pop());
            }
            return x;
        }

        /** Get the front element. */
        public int peek() {
            while (!s1.isEmpty()){
                cache.push(s1.pop());
            }
            int  x = cache.peek();
            while (!cache.isEmpty()){
                s1.push(cache.pop());
            }
            return x;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty();
        }
    }

}
