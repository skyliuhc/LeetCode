package Labuladong.src.WeekTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-07-24-10:32 下午
 */
public class LeetCode5804 {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++){
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : map.values()) {
            list.add(i);
        }
        int pre=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(pre!=list.get(i)){
                return false;
            }
            pre=list.get(i);
        }
        return true;
    }
}
