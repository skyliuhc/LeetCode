package WeekTest;

import java.util.Arrays;

/**
 * @author skyliuhc
 * @create 2021-07-04-10:39 上午
 */
public class LeetCode5801 {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arr = new int[n];
        //按照时间排序
        for (int i = 0; i < n; i++) {
            arr[i] = Math.max(0, (dist[i] - 1) / speed[i]);
        }

        Arrays.sort(arr);
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (cur <= arr[i]){
                cur++;
            }else{
                break;
            }
        }
        return cur;
    }
}


