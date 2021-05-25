package Hot17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Character, String> map;
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n < 1) {
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<>();
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        dp(res,0,digits,sb);
        return res;
    }

    void dp(List<String> list,int index,String s,StringBuilder sb){
        if (index==s.length()){
            list.add(sb.toString());
            return;
        }
        String zimu = map.get(s.charAt(index));
        for (int i = 0; i < zimu.length(); i++) {
            sb.append(zimu.charAt(i));
            dp(list,index+1,s,sb);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(s.length());
    }
}
