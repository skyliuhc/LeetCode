package offer_59II;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author skyliuhc
 * @create 2021/5/5
 *
 * 队列offer() 在末尾添加元素
 * 单调队列队基本情况
 */
public class Solution {
    class MaxQueue {
        Queue<Integer> q;//只允许在前面删除，后面插入
        Deque<Integer> d;//维护队最大值

        public MaxQueue() {
                q=new LinkedList<Integer>();
                d=new LinkedList<Integer>();
        }

        public int max_value(){
            if(d.isEmpty()){
                return -1;
            }
            return d.peekFirst();
        }
        //入队
        public void push_back(int value){
            while(!d.isEmpty() && d.peekLast() <value){
                d.pollLast();
            }
            d.offerLast(value);
            q.offer(value);
        }
        //出队
        public int pop_front(){
            if(q.isEmpty()){
                return -1;
            }
            int ans =q.poll();
            //如果头部是最大值的花，得同时出队
            if(ans==d.peekFirst()){
                d.pollFirst();
            }
            return ans;
        }

    }

}
