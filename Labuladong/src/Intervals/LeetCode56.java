package Intervals;

import java.util.*;

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        //base case
        if (intervals == null) {
            return new int[intervals.length][];
        }
        LinkedList<int[]> list = new LinkedList<>();

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = list.getLast();
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                list.addLast(curr);
            }
        }
        int size = list.size();
        int[][] res = new int[size][];
        for (int k = 0; k < size; k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
