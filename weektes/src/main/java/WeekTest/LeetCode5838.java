package WeekTest;

/**
 * @author skyliuhc
 * @create 2021-08-08-10:33 上午
 */
public class LeetCode5838 {
//    给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
//
//    字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，
//    且 k 不超过 words.length 。
//
//    如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
//

    //利用前缀和数组
    public boolean isPrefixString(String s, String[] words) {
        int n = words.length;
        String[] ss = new String[n + 1];
        ss[0] = "";
        for (int k = 1; k <= n; k++) {
            ss[k] = ss[k - 1] + words[k - 1];
        }
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            String p = ss[i];
            if (p.equals(s)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean isPrefixString_solution(String s, String[] words){
        String c="";
        int sl= s.length();
        for (String i : words) {
            c+=i;
            if (c.equals(s)){
                return true;
            }else if(c.length()>sl){
                return false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        LeetCode5838 l1 = new LeetCode5838();
        String t = "iloveleetcode";
        String t2 = "aaa";
        String[] str = new String[]{"i", "love", "leetcode", "apples"};
        String[] str2 = new String[]{"aa", "aaa", "fjaklfj"};
        System.out.println(l1.isPrefixString(t2, str2));
    }
}
