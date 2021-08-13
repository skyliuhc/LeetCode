package WeekTest;

import java.util.HashMap;

public class LeetCode5754 {


    public int countGoodSubstrings(String s) {
        int widLen = 3;
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length - widLen+1; i++) {
            String temp = s.substring(i, i + 3);
            System.out.println(temp);
            if (check(temp)) {
                count++;
            }
        }
        return count;
    }

    private boolean check(String temp) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length(); i++) {
            if (map.containsKey(temp.charAt(i))) {
                return false;
            } else {
                map.put(temp.charAt(i), map.getOrDefault(temp.charAt(i), 0) + 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode5754 l = new LeetCode5754();
        l.countGoodSubstrings("aababcabc");
    }
}
