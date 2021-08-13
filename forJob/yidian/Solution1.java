package forJob.yidian;

/**
 * @author skyliuhc
 * @create 2021-08-07-10:14 下午
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        System.out.println(s1.makeFancyString("aaabaaaa"));
    }

    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);//当前字符
            sb.append(c);
            int j = i;
            int cnt = 0;
            while (j < n - 1 && s.charAt(j) == s.charAt(j + 1)) {
//                System.out.println("j "+j+" "+s.charAt(j));
                cnt++;
                j++;
            }
            if (cnt >= 1) {
                sb.append(c);
            }
            i = j+1;
        }
        return sb.toString();
    }
}
