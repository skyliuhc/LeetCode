package com.offer2.HashMap;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-08-19-9:58 上午
 */
public class offer35_findMinDifference {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> timelist = new ArrayList<>();
        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            int realtime = 0;//以分钟为单位
            int sh = Integer.parseInt(s.substring(0, 2));
            int sm = Integer.parseInt(s.substring(3));
            realtime = sh * 60 + sm;
            timelist.add(realtime);
            realtime = sh * 60 + sm+24*60;
            timelist.add(realtime);
        }
        Collections.sort(timelist);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timelist.size() - 1; i++) {
            min = Math.min(min, Math.abs(timelist.get(i) - timelist.get(i + 1)));
        }
        return min;
    }
}
