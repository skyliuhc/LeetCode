package forJob.yidian;

/**
 * @author skyliuhc
 * @create 2021-08-08-10:33 上午
 */
public class LeetCode5813 {
    public boolean isPrefixString(String s, String[] words) {
        int len = s.length();
        int n = words.length;
        String[] ss = new String[n + 1];
        ss[0] = "";
        for (int k = 1; k <= n; k++) {
            ss[k] = ss[k - 1] + words[k - 1];
        }
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            String p = ss[i];
            if(p.equals(s)){
                flag=true;
                break;
            }
        }
        return flag;
    }
    boolean check(String s,String p){
        int pl = p.length();
        int len = s.length();
        if (len<pl) return false;
        int j = 0;
        for (; j < len / pl; j++) {
            String substring = s.substring(j * pl, pl * j + pl);
            if (!substring.equals(p)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode5813 l1 = new LeetCode5813();
        String t = "iloveleetcode";
        String t2="aaa";
        String[] str = new String[]{"i", "love", "leetcode", "apples"};
        String[] str2 = new String[]{"aa","aaa","fjaklfj"};
        System.out.println(l1.isPrefixString(t2, str2));
//        System.out.println(t.substring(0 + 5, 5 * 2));
    }
}
