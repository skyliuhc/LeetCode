package WeekTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode5742 {
    //将句子排序
    public String sortSentence(String s) {
        HashMap<Integer,String> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i)==' '){
                continue;
            }
            if(s.charAt(i)>='1'&&s.charAt(i)<='9'){
                String temp = "";
                for (int j = 0; j < list.size(); j++) {
                    temp+=list.get(j);
                }
                map.put(s.charAt(i)-'0',temp);
                list.clear();
            }else{
                list.add(s.charAt(i));
            }
        }
        String res="";
        for (int i = 1; i < map.size()+1; i++) {
            res+=map.get(i);
            res+=" ";
        }
        return res.trim();
    }

    public static void main(String[] args) {
        LeetCode5742 l1 = new LeetCode5742();
        String test ="is2 sentence4 This1 a3";
        System.out.println(l1.sortSentence(test));
    }
}
