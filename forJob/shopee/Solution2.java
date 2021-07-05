package forJob.shopee;

import java.util.HashMap;

/**
 * @author skyliuhc
 * @create 2021-07-05-3:42 下午
 */
public class Solution2 {
    //字符串压缩
    public String compressString(String param) {
        char[] chars = param.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(map.get(c)==1){
                sb.append(c);
            }else{
                sb.append(c+""+map.get(c));
                i+=map.get(c)-1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.compressString("shopeew"));
    }
}
