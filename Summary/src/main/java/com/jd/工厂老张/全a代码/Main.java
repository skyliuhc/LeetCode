package com.jd.工厂老张.全a代码;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
/**
 * @author skyliuhc
 * @create 2021-10-09-10:40 下午
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] targetArray = new int[n];
        for (int i = 0; i < n; i++) {
            targetArray[i] = sc.nextInt();
        }
        //6
        //3 2 1 2 2 3
        System.out.println(getRes(targetArray));
    }

    private static String getRes(int[] targetArray) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> resMap = new HashMap<>();
        for (int i : targetArray) {
            if (resMap.containsKey(i)) {
                resMap.put(i, resMap.get(i) + 1);
            } else {
                resMap.put(i, 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> iE : resMap.entrySet()) {
            Integer value = iE.getValue();
            if (value > max) {
                max = value;
            }
        }
        int bigTarget = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> iE : resMap.entrySet()) {
            Integer value = iE.getValue();
            Integer key = iE.getKey();
            if (value == max) {
                int l = 0;
                int r = targetArray.length - 1;
                for (int i = 0; i < targetArray.length; i++) {
                    if (key == targetArray[i]) {
                        l = i + 1;
                        break;
                    }
                }
                for (int i = targetArray.length - 1; i >= 0; i--) {
                    if (key == targetArray[i]) {
                        r = i + 1;
                        break;
                    }
                }
                if ((r - l) < bigTarget) {
                    bigTarget = r-l;
                    sb = new StringBuilder(l + " " + r);
                }
            }
        }
        return sb.toString();
    }
}
