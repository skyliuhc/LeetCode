package Window;

import java.util.HashMap;

public class LeetCode76 {
//    Java 用Map记录字母出现个数的写法，
//    最后一个测试用例通不过时，要明白一件事。
//    Integer是对象
//    Integer会缓存频繁使用的数值，
//    数值范围为-128到127，在此范围内直接返回缓存值。
//    超过该范围就会new 一个对象。
    public String minWindow(String s, String t) {

        if(s==null||s.length()==0||t==null||t.length()==0){
            return "";
        }
        HashMap<Character,Integer> need =new HashMap<>();
        HashMap<Character,Integer> window =new HashMap<>();
        for(Character c:t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left =0,right=0;
        int valid = 0;//记录最小覆盖子串的起始索引长度
        int start = 0,len=Integer.MAX_VALUE;
        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //判断左侧窗口是否要收缩
            while(valid==need.size()){
                if(right-left<len){
                    start=left;
                    len=right-left;
                }
                char d= s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d,0)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE ?"":s.substring(start,start+len);
    }

    public static void main(String[] args) {
        String test="123456";
        System.out.println(test.substring(1,3+1));
    }
}
