package Labuladong.src.WeekTest;

/**
 * @author skyliuhc
 * @create 2021-07-25-10:30 上午
 */
public class leetCode5823 {
    public int getLucky(String s, int k) {
        char[] chars = s.toCharArray();
        int res =0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]-'a'+1);
        }
        k=k-1;
        String s1 = sb.toString();

        while(k-->0){
            char[] chars1 = s1.toCharArray();
            int temp=0;
            for (int i = 0; i < chars1.length; i++) {
                temp+=chars1[i]-'0';
            }
            s1=temp+"";
        }
        return Myfun(s1);
    }
    int Myfun(String s){
        char[] chars = s.toCharArray();
        int res =0;
        for (int i = 0; i < chars.length; i++) {
            res+=chars[i]-'0';
        }
        return res;
    }
}
