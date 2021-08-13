package Labuladong.src.Window;

import java.util.HashMap;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> window = new HashMap<>();
        int left =0,right=0;
        int res =0 ;
        while (right<s.length()){
            char c =s.charAt(right);
            right++;
            //进行窗口内数据的一系列更新
            window.put(c,window.getOrDefault(c,0)+1);
            while (window.get(c)>1){// window[c]值大于 1 时，说明窗口中存在重复字符，不符合条件
                // 判断左侧窗口是否要收缩
                char d = s.charAt(left);
                left++;
                window.put(d,window.getOrDefault(d,0)-1);
            }
            res=Math.max(res,right-left);
        }
        return  res;
    }


}
