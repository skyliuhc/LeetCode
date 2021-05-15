package LeetCode13_romanToInt;

import java.util.HashMap;

public class Solution {
    int[] values = {1, 5, 10, 50, 100, 500, 1000};
    char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    public int romanToInt(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(symbols[i], values[i]);
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                    res -= map.get(s.charAt(i));
                } else {
                    res += map.get(s.charAt(i));
                }
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }


}
