package Labuladong.src.Intervals;

import java.util.Arrays;

public class LeetCode1288 {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        //记录合并区间的起点和终点
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] intv =intervals[i];

            //情况一、找到覆盖区间
            if(left<=intv[0] && right>=intv[1]){
                res++;//被覆盖的区间+1
            }
            if(left<=intv[0] && right<=intv[1]){
                right=intv[1];
            }
            if( right<intv[0]){
                left=intv[0];
                right=intv[1];
            }

        }
        return intervals.length-res;
    }


}
