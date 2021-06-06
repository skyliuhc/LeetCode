package String;

import java.util.HashMap;

public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.get(s.charAt(i)) > 1) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }


}
