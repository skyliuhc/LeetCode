package com.offer2.Integer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skyliuhc
 * @create 2021-08-10-2:59 上午
 */
public class offer6_twoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]))
                return new int[]{map.get(target - numbers[i]), i};
            map.put(numbers[i], i);
        }
        return new int[]{1, 1};
    }
}
