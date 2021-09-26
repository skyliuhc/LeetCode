package com.offer2.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author skyliuhc
 * @create 2021-08-21-10:07 上午
 */
public class offer40_maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
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
}
