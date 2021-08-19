package com.acwing.offer_week2;

import java.util.LinkedList;

/**
 * @author skyliuhc
 * @create 2021-08-16-10:31 上午
 */
public class offer24_movingCount {
    class pair {
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int movingCount(int threshold, int rows, int cols) {
        int res = 0;
        if (rows == 0 || cols == 0) return 0;
        boolean[][] flag = new boolean[rows][cols];//标记是否被访问过
        LinkedList<pair> list = new LinkedList<>();
        list.add(new pair(0, 0));
        res++;
        flag[0][0] = true;
        //定义方向数组
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!list.isEmpty()) {
            pair t = list.removeFirst();
            for (int i = 0; i < 4; i++) {
                int xx = t.x + dx[i];
                int yy = t.y + dy[i];
                if (xx >= 0 && xx < rows && yy >= 0 && yy < cols && !flag[xx][yy]) {
                    pair p = new pair(xx, yy);
                    if (getSum(p) <= threshold) {
                        list.add(p);
                        res++;
                    }
                    flag[xx][yy] = true;

                }
            }

        }
        return res;

    }

    int getSum(pair t) {
        return getSingleSum(t.x) + getSingleSum(t.y);
    }

    int getSingleSum(int x) {//用来计算数位之和
        int sum = 0;
        while (x > 0) {
            sum += x % 10;//每次都取个位上的数字进行相加
            x /= 10;
        }
        return sum;
    }
}
