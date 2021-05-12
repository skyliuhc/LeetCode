package Window;

import java.util.HashMap;

public class LeetCode567 {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> need =new HashMap<>();
        HashMap<Character,Integer> window =new HashMap<>();
        for (char c:s1.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left =0,right=0;
        int valid =0;
        while(right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            //判断⬅左侧窗口是否要收缩
            while (right-left>=s1.length()){
                if (valid==need.size()){
                    return true;
                }
                char d =s2.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }

        }
        return false;
    }
}
