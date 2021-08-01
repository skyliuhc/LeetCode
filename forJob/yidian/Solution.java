package forJob.yidian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-07-30-7:52 下午
 */
public class Solution {

    public int countMaxActivity(List<List<String>> time) {
        int n = time.size();
        int[][] t = new int[n][2];
        for (int i = 0; i < time.size(); i++) {
            List<String> strings = time.get(i);
            String start = strings.get(0);String end = strings.get(1);
            int sh = Integer.parseInt(start.substring(0, 2));
            int sm = Integer.parseInt(start.substring(3, start.length()));
            int eh = Integer.parseInt(end.substring(0, 2));
            int em = Integer.parseInt(end.substring(3, end.length()));
            t[i][0] = sh * 60 + sm;
            t[i][1] = eh * 60 + em;
        }
        Arrays.sort(t, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int last = 0;
        int ddl = 23 * 60 + 59;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (t[i][0] >= last && t[i][1] < ddl) {
                res++;
                last = t[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> time = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("10:00");
        list1.add("12:00");
        time.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("03:00");
        list2.add("11:30");
        time.add(list2);
        List<String> list3 = new ArrayList<>();
        list3.add("11:30");
        list3.add("14:00");
        time.add(list3);
        Solution solution = new Solution();
        System.out.println(solution.countMaxActivity(time));


    }
}
