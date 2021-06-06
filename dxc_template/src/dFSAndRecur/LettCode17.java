package dFSAndRecur;

import java.util.*;

public class LettCode17 {

    //通过迭代的方式
    public List<String> letterCombinations(String digits) {
        String[] s = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> state = new ArrayList<>();
        state.add("");
        for (char w : digits.toCharArray()) {
//           String now = "";
            List<String> now = new ArrayList<>();
            for (char c : s[w - '2'].toCharArray()) {
                for (String st : state) {
                    now.add(st + c);
                }
            }
            state = now;
        }
        return state;
    }
}
