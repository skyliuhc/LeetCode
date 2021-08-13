package WeekTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author skyliuhc
 * @create 2021-07-24-10:38 下午
 */
public class LeetCode5805 {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int maxStart = 0;
        int x = times[targetFriend][0];
        int y = times[targetFriend][1];

        for (int i = 0; i < n; i++) {
            maxStart = Math.max(maxStart, times[i][0]);
        }
        Arrays.sort(times, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int p = 0;
        Queue<int[]> q=new LinkedList<>();
        for (int[] time : times) {
            q.add(time);
        }
        for (int i = 0; i < x; i++) {
            int[] peek = q.peek();
            int start=peek[0];
            int end=peek[1];
            if(i==start){
                p++;
            }
            if(i==end){

            }

        }
        return p;
    }

    public static void main(String[] args) {
        int[][] t = {{33889, 98676}, {80071, 89737},
                {44118, 52565}, {52992, 84310},
                {78492, 88209}, {21695, 67063},
                {84622, 95452}, {98048, 98856},
                {98411, 99433}, {55333, 56548},
                {65375, 88566}, {55011, 62821},
                {48548, 48656}, {87396, 94825},
                {55273, 81868}, {75629, 91467}};
        int target = 6;
    }
}
