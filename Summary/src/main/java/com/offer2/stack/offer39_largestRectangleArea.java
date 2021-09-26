package com.offer2.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author skyliuhc
 * @create 2021-08-21-10:07 上午
 */
public class offer39_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;//加入头哨兵
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;//加入尾哨兵
        len += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
//        stack.addLast(0);
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peek()]) {
                int curHeight = heights[stack.poll()];
                int curWidth = i - stack.peek() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
         int[] heights = {2, 1, 5, 6, 2, 3};
//        int[] heights = {1, 1};
        offer39_largestRectangleArea solution = new offer39_largestRectangleArea();
        int res = solution.largestRectangleArea(heights);
        System.out.println(res);
    }

}
