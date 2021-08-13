package Labuladong.src.Window;

import java.util.ArrayList;
import java.util.List;

public class LeetCode438_arr {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] need = new int[26];
        int[] window = new int[26];
        int left = 0, right = 0, total = p.length();
        for (char ch : p.toCharArray()) {
            need[ch - 'a']++;
        }
        while (right < s.length()) {
            char chr = s.charAt(right);
            if (need[chr - 'a'] > 0) {
                window[chr - 'a']++;
                if (window[chr - 'a'] <= need[chr - 'a']) {
                    total--;
                }
            }

            while (total == 0) {
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                char ch1 = s.charAt(left);
                if (need[ch1 - 'a'] > 0) {
                    window[ch1 - 'a']--;
                    if (window[ch1 - 'a'] < need[ch1 - 'a']) {
                        total++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }

}
