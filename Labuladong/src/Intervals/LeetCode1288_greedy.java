package Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1288_greedy {
    //greedy
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int count = 0; //不被删除的区间数
        int end, prev_end = 0;
        for (int[] cur : intervals) {
            end = cur[1];
            if (prev_end < end) {
                count++;
                prev_end =end;
            }
        }
        return count;
    }
}
