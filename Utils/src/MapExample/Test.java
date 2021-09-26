package MapExample;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skyliuhc
 * @create 2021-09-21-10:02 上午
 */
public class Test {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for(int i=0;i<n;i++){
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }
        int cnt = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

        }
        if(n%2==0 && cnt==0){
            return true;
        }else if(n%2==1 && cnt ==1){
            return true;
        }else{
            return false;
        }
    }
}
