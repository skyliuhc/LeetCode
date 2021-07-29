package LeetCode1736_maximumTime;

/**
 * @author skyliuhc
 * @create 2021-07-24-9:59 上午
 */
public class Solution {
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[0]=='?'){
               if(chars[1]>='4' && chars[1]<='9'){
                   chars[0]='1';
               }else{
                   chars[0]='2';
               }
            }
            if (chars[1]=='?'){
                if(chars[0]=='1'){
                    chars[1]='9';
                }else{
                    chars[1]='3';
                }
            }
            if(chars[3]=='?')chars[i]='5';
            if(chars[4]=='?')chars[i]='9';
        }
        return new String(chars);
    }
}
